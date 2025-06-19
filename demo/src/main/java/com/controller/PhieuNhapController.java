package com.controller;

import com.model.dao.PhieuNhapHangDAO;
import com.model.dao.ChiTietPhieuNhapDAO;
import com.model.dao.ThuocDAO;
import com.model.entities.PhieuNhapHang;
import com.model.entities.ChiTietPhieuNhap;
import com.model.entities.Thuoc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class PhieuNhapController {
    @FXML private TextField txtMaPN;
    @FXML private TextField txtTenNCC;
    @FXML private TextField txtTenNV;
    @FXML private TableView<ChiTietPhieuNhap> tableCTPN;
    @FXML private TableColumn<ChiTietPhieuNhap, Integer> colStt;
    @FXML private TableColumn<ChiTietPhieuNhap, String> colTenThuoc;
    @FXML private TableColumn<ChiTietPhieuNhap, String> colDonViTinh;
    @FXML private TableColumn<ChiTietPhieuNhap, Integer> colSoLuong;
    @FXML private TableColumn<ChiTietPhieuNhap, Double> colGiaNhap;
    @FXML private TableColumn<ChiTietPhieuNhap, Double> colThanhTien;
    @FXML private TextField txtTong;
    @FXML private Button btnHuyPhieuNhap;
    @FXML private Button btnPrintPhieuNhap;
    @FXML private TableView<PhieuNhapHang> tablePhieuNhap;
    @FXML private TableColumn<PhieuNhapHang, String> colMaPhieu;
    @FXML private TableColumn<PhieuNhapHang, String> colNhaCungCap;
    @FXML private TableColumn<PhieuNhapHang, String> colNhanVien;
    @FXML private TableColumn<PhieuNhapHang, String> colTenNhapHang;
    @FXML private TableColumn<PhieuNhapHang, Double> colTongTien;
    @FXML private TableColumn<PhieuNhapHang, java.util.Date> colThoiGian;

    private final PhieuNhapHangDAO phieuNhapDAO = new PhieuNhapHangDAO();
    private final ChiTietPhieuNhapDAO chiTietDAO = new ChiTietPhieuNhapDAO();
    private final ThuocDAO thuocDAO = new ThuocDAO();
    private ObservableList<ChiTietPhieuNhap> chiTietList = FXCollections.observableArrayList();
    private ObservableList<PhieuNhapHang> phieuNhapList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Setup columns for chi tiết phiếu nhập
        colStt.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(tableCTPN.getItems().indexOf(cell.getValue()) + 1).asObject());
        colTenThuoc.setCellValueFactory(cell -> {
            Thuoc thuoc = thuocDAO.selectById(cell.getValue().getIdThuoc());
            return new javafx.beans.property.SimpleStringProperty(thuoc != null ? thuoc.getTen() : "");
        });
        colDonViTinh.setCellValueFactory(cell -> {
            Thuoc thuoc = thuocDAO.selectById(cell.getValue().getIdThuoc());
            return new javafx.beans.property.SimpleStringProperty(thuoc != null ? thuoc.getDonViTinh() : "");
        });
        colSoLuong.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getSoLuong()).asObject());
        colGiaNhap.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getGiaNhap()).asObject());
        colThanhTien.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getSoLuong() * cell.getValue().getGiaNhap()).asObject());
        tableCTPN.setItems(chiTietList);

        // Setup columns for phiếu nhập hàng
        colMaPhieu.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getIdPhieu()));
        colNhaCungCap.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getIdncc()));
        colNhanVien.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getIdnv()));
        colTenNhapHang.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTenNhapHang()));
        colTongTien.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getTongTien()).asObject());
        colThoiGian.setCellValueFactory(cell -> new javafx.beans.property.SimpleObjectProperty<>(cell.getValue().getThoiGian()));
        tablePhieuNhap.setItems(phieuNhapList);

        // Load data from DB
        phieuNhapList.setAll(phieuNhapDAO.selectAll());

        // Show chi tiết khi chọn phiếu nhập
        tablePhieuNhap.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> showPhieuNhap(newVal));
    }

    public void showPhieuNhap(PhieuNhapHang phieuNhap) {
        if (phieuNhap == null) return;
        txtMaPN.setText(phieuNhap.getIdPhieu());
        txtTenNCC.setText(phieuNhap.getIdncc()); // Cần join để lấy tên NCC nếu muốn
        txtTenNV.setText(phieuNhap.getIdnv());   // Cần join để lấy tên NV nếu muốn
        chiTietList.setAll(chiTietDAO.selectBySql("SELECT * FROM chitietphieunhap WHERE idphieu = ?", phieuNhap.getIdPhieu()));
        tableCTPN.refresh();
        double tong = chiTietList.stream().mapToDouble(ct -> ct.getSoLuong() * ct.getGiaNhap()).sum();
        txtTong.setText(String.valueOf(tong));
    }
}
