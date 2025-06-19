package com.controller;

import com.model.dao.ThuocDAO;
import com.model.dao.HoaDonDAO;
import com.model.dao.ChiTietHoaDonDAO;
import com.model.dao.KhachHangDAO;
import com.model.entities.Thuoc;
import com.model.entities.HoaDon;
import com.model.entities.ChiTietHoaDon;
import com.model.entities.KhachHang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.util.*;
import java.util.stream.Collectors;

public class HoaDonController {
    // Thuoc table (lower left)
    @FXML private TableView<Thuoc> thuocTableHD;
    @FXML private TableColumn<Thuoc, String> colMaThuocHD;
    @FXML private TableColumn<Thuoc, String> colTenThuocHD;
    @FXML private TableColumn<Thuoc, String> colDanhMucHD;
    @FXML private TableColumn<Thuoc, String> colXuatXuHD;
    @FXML private TableColumn<Thuoc, String> colDonViTinhHD;
    @FXML private TableColumn<Thuoc, Integer> colSoLuongHD;
    @FXML private TableColumn<Thuoc, Double> colDonGiaHD;
    // Info fields (upper left)
    @FXML private TextField maThuocField;
    @FXML private TextField tenThuocField;
    @FXML private TextArea thanhPhanField;
    @FXML private TextField donGiaField;
    @FXML private TextField soLuongFieldHoaDon;
    @FXML private Button addToCartButtonHoaDon;
    // Cart table (upper right)
    @FXML private TableView<ChiTietHoaDon> cartTable;
    @FXML private TableColumn<ChiTietHoaDon, Number> colSttCart;
    @FXML private TableColumn<ChiTietHoaDon, String> colTenThuocCart;
    @FXML private TableColumn<ChiTietHoaDon, Integer> colSoLuongCart;
    @FXML private TableColumn<ChiTietHoaDon, Double> colDonGiaCart;
    @FXML private Button removeCartItemButton;
    // Invoice fields (lower right)
    @FXML private TextField maHoaDonField;
    @FXML private TextField soDienThoaiField;
    @FXML private TextField tenKhachHangField;
    @FXML private ComboBox<String> gioiTinhCombo;
    @FXML private TextField tongHoaDonField;
    @FXML private TextField tienKhachDuaField;
    @FXML private TextField tienThuaField;
    @FXML private Button inHoaDonButton;
    @FXML private Button huyBoButton;
    @FXML private ComboBox<String> filterComboHoaDon;
    @FXML private TextField searchFieldHoaDon;
    @FXML private Button refreshButtonHoaDon;

    private final ThuocDAO thuocDAO = new ThuocDAO();
    private final HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private final ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private final KhachHangDAO khachHangDAO = new KhachHangDAO();
    private ObservableList<Thuoc> thuocList = FXCollections.observableArrayList();
    private ObservableList<ChiTietHoaDon> cartList = FXCollections.observableArrayList();
    private String currentHoaDonId = null;

    @FXML
    private void initialize() {
        // Setup thuốc table
        colMaThuocHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getIdThuoc()));
        colTenThuocHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTen()));
        colDanhMucHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDanhMuc()));
        colXuatXuHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getXuatXu()));
        colDonViTinhHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getDonViTinh()));
        colSoLuongHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getSoLuongTon()).asObject());
        colDonGiaHD.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getGiaBan()).asObject());
        thuocList.setAll(thuocDAO.selectAll());
        thuocTableHD.setItems(thuocList);
        // Show info when select thuốc
        thuocTableHD.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> showThuocInfo(newVal));
        // Add to cart
        addToCartButtonHoaDon.setOnAction(e -> handleAddToCart());
        // Setup cart table columns
        if (colSttCart != null) {
            colSttCart.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cartList.indexOf(cell.getValue()) + 1));
        }
        if (colTenThuocCart != null) {
            colTenThuocCart.setCellValueFactory(cell -> {
                String idThuoc = cell.getValue().getIdThuoc();
                Thuoc thuoc = thuocList.stream().filter(t -> t.getIdThuoc().equals(idThuoc)).findFirst().orElse(null);
                return new javafx.beans.property.SimpleStringProperty(thuoc != null ? thuoc.getTen() : idThuoc);
            });
        }
        if (colSoLuongCart != null) {
            colSoLuongCart.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getSoLuong()).asObject());
        }
        if (colDonGiaCart != null) {
            colDonGiaCart.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getDonGia()).asObject());
        }
        // Setup cart table
        cartTable.setItems(cartList);
        // Remove from cart
        if (removeCartItemButton != null) {
            removeCartItemButton.setOnAction(e -> handleRemoveCartItem());
        }
        // Print invoice
        inHoaDonButton.setOnAction(e -> handleInHoaDon());
        // Cancel
        huyBoButton.setOnAction(e -> handleHuyBo());
        // Refresh
        if (refreshButtonHoaDon != null) {
            refreshButtonHoaDon.setOnAction(e -> reloadThuocTable());
        }
    }

    private void showThuocInfo(Thuoc thuoc) {
        if (thuoc == null) {
            maThuocField.setText("");
            tenThuocField.setText("");
            thanhPhanField.setText("");
            donGiaField.setText("");
            return;
        }
        maThuocField.setText(thuoc.getIdThuoc());
        tenThuocField.setText(thuoc.getTen());
        thanhPhanField.setText(thuoc.getThanhPhan());
        donGiaField.setText(String.valueOf(thuoc.getGiaBan()));
    }

    private void handleAddToCart() {
        Thuoc selected = thuocTableHD.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Chọn thuốc để thêm vào giỏ hàng!");
            return;
        }
        String soLuongStr = soLuongFieldHoaDon.getText();
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            showAlert("Số lượng không hợp lệ!");
            return;
        }
        // Check if already in cart
        for (ChiTietHoaDon cthd : cartList) {
            if (cthd.getIdThuoc().equals(selected.getIdThuoc())) {
                cthd.setSoLuong(cthd.getSoLuong() + soLuong);
                cartTable.refresh();
                return;
            }
        }
        // Add new
        cartList.add(new ChiTietHoaDon(null, selected.getIdThuoc(), soLuong, selected.getGiaBan()));
        cartTable.refresh();
    }

    private void handleRemoveCartItem() {
        ChiTietHoaDon selected = cartTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cartList.remove(selected);
            cartTable.refresh();
        }
    }

    private void handleInHoaDon() {
        if (cartList.isEmpty()) {
            showAlert("Giỏ hàng trống!");
            return;
        }
        try {
            // 1. Create HoaDon if needed
            String idhd = maHoaDonField.getText();
            if (idhd == null || idhd.isEmpty()) {
                idhd = UUID.randomUUID().toString();
                maHoaDonField.setText(idhd);
            }
            String idkh = null;
            // Optionally, lookup/create KhachHang by phone/name
            // ...
            HoaDon hd = new HoaDon(idhd, 0, new Date(), null, null, idkh);
            hoaDonDAO.create(hd);
            // 2. Add all ChiTietHoaDon
            for (ChiTietHoaDon cthd : cartList) {
                cthd.setIdhd(idhd);
                chiTietHoaDonDAO.create(cthd);
            }
            // 3. Triggers will update inventory and tongtien
            showAlert("Đã bán!");
            cartList.clear();
            cartTable.refresh();
            thuocList.setAll(thuocDAO.selectAll());
            thuocTableHD.refresh();
        } catch (Exception e) {
            showAlert("Lỗi khi in hóa đơn: " + e.getMessage());
        }
    }

    private void handleHuyBo() {
        cartList.clear();
        cartTable.refresh();
        maHoaDonField.clear();
        soDienThoaiField.clear();
        tenKhachHangField.clear();
        tongHoaDonField.clear();
        tienKhachDuaField.clear();
        tienThuaField.clear();
    }

    private void reloadThuocTable() {
        String filter = filterComboHoaDon != null && filterComboHoaDon.getValue() != null ? filterComboHoaDon.getValue() : "";
        String search = searchFieldHoaDon != null && searchFieldHoaDon.getText() != null ? searchFieldHoaDon.getText().trim() : "";
        ObservableList<Thuoc> filtered = FXCollections.observableArrayList(thuocList);
        if (!filter.isEmpty() && !filter.equals("Tất cả")) {
            filtered = filtered.filtered(t -> t.getDanhMuc().equalsIgnoreCase(filter));
        }
        if (!search.isEmpty()) {
            filtered = filtered.filtered(t -> t.getTen().toLowerCase().contains(search.toLowerCase()) || t.getIdThuoc().toLowerCase().contains(search.toLowerCase()));
        }
        thuocTableHD.setItems(filtered);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }
}
