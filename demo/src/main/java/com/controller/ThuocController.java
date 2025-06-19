package com.controller;

import com.model.dao.ThuocDAO;
import com.model.entities.Thuoc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ThuocController {
    @FXML private TableView<Thuoc> thuocTable;
    @FXML private TableColumn<Thuoc, String> colMaThuoc;
    @FXML private TableColumn<Thuoc, String> colTenThuoc;
    @FXML private TableColumn<Thuoc, String> colDanhMuc;
    @FXML private TableColumn<Thuoc, String> colXuatXu;
    @FXML private TableColumn<Thuoc, String> colDonViTinh;
    @FXML private TableColumn<Thuoc, Integer> colSoLuong;
    @FXML private TableColumn<Thuoc, Double> colDonGia;
    @FXML private Button btnThemThuoc;
    @FXML private Button btnSuaThuoc;
    @FXML private Button btnXoaThuoc;
    @FXML private Button refreshButtonThuoc;

    private final ThuocDAO thuocDAO = new ThuocDAO();

    @FXML
    private void initialize() {
        btnThemThuoc.setOnAction(e -> handleThemThuoc());
        btnSuaThuoc.setOnAction(e -> handleSuaThuoc());
        if (btnXoaThuoc != null) btnXoaThuoc.setOnAction(e -> handleXoaThuoc());
        refreshButtonThuoc.setOnAction(e -> setupThuocTable());
        setupThuocTable();
    }

    private void handleThemThuoc() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/add-thuoc.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm thuốc");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnThem = (Button) root.lookup("#btnThemThuoc");
            Button btnHuy = (Button) root.lookup("#btnHuyBoThuoc");
            TextField idField = (TextField) root.lookup("#idThuocField");
            TextField tenField = (TextField) root.lookup("#tenThuocField");
            TextField thanhPhanField = (TextField) root.lookup("#thanhPhanField");
            TextField donViTinhField = (TextField) root.lookup("#donViTinhField");
            TextField danhMucField = (TextField) root.lookup("#danhMucField");
            TextField xuatXuField = (TextField) root.lookup("#xuatXuField");
            TextField giaNhapField = (TextField) root.lookup("#giaNhapField");
            TextField giaBanField = (TextField) root.lookup("#giaBanField");
            TextField soLuongTonField = (TextField) root.lookup("#soLuongTonField");
            btnThem.setOnAction(e -> {
                try {
                    Thuoc thuoc = new Thuoc(
                        idField.getText(),
                        tenField.getText(),
                        thanhPhanField.getText(),
                        donViTinhField.getText(),
                        danhMucField.getText(),
                        xuatXuField.getText(),
                        Double.parseDouble(giaNhapField.getText()),
                        Double.parseDouble(giaBanField.getText()),
                        Integer.parseInt(soLuongTonField.getText())
                    );
                    thuocDAO.create(thuoc);
                    setupThuocTable();
                    stage.close();
                } catch (Exception ex) {
                    showAlert("Lỗi khi thêm thuốc: " + ex.getMessage());
                }
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            showAlert("Lỗi khi mở cửa sổ thêm thuốc: " + e.getMessage());
        }
    }
    private void handleSuaThuoc() {
        try {
            Thuoc selected = thuocTable.getSelectionModel().getSelectedItem();
            if (selected == null) { showAlert("Chọn thuốc để cập nhật!"); return; }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/update-thuoc.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cập nhật thuốc");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnCapNhat = (Button) root.lookup("#btnCapNhatThuoc");
            Button btnHuy = (Button) root.lookup("#btnHuyBoThuoc");
            TextField idField = (TextField) root.lookup("#idThuocField");
            TextField tenField = (TextField) root.lookup("#tenThuocField");
            TextField thanhPhanField = (TextField) root.lookup("#thanhPhanField");
            TextField donViTinhField = (TextField) root.lookup("#donViTinhField");
            TextField danhMucField = (TextField) root.lookup("#danhMucField");
            TextField xuatXuField = (TextField) root.lookup("#xuatXuField");
            TextField giaNhapField = (TextField) root.lookup("#giaNhapField");
            TextField giaBanField = (TextField) root.lookup("#giaBanField");
            TextField soLuongTonField = (TextField) root.lookup("#soLuongTonField");
            idField.setText(selected.getIdThuoc());
            idField.setDisable(true);
            tenField.setText(selected.getTen());
            thanhPhanField.setText(selected.getThanhPhan());
            donViTinhField.setText(selected.getDonViTinh());
            danhMucField.setText(selected.getDanhMuc());
            xuatXuField.setText(selected.getXuatXu());
            giaNhapField.setText(String.valueOf(selected.getGiaNhap()));
            giaBanField.setText(String.valueOf(selected.getGiaBan()));
            soLuongTonField.setText(String.valueOf(selected.getSoLuongTon()));
            btnCapNhat.setOnAction(e -> {
                try {
                    Thuoc thuoc = new Thuoc(
                        idField.getText(),
                        tenField.getText(),
                        thanhPhanField.getText(),
                        donViTinhField.getText(),
                        danhMucField.getText(),
                        xuatXuField.getText(),
                        Double.parseDouble(giaNhapField.getText()),
                        Double.parseDouble(giaBanField.getText()),
                        Integer.parseInt(soLuongTonField.getText())
                    );
                    thuocDAO.update(thuoc);
                    setupThuocTable();
                    stage.close();
                } catch (Exception ex) {
                    showAlert("Lỗi khi cập nhật thuốc: " + ex.getMessage());
                }
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            showAlert("Lỗi khi mở cửa sổ cập nhật thuốc: " + e.getMessage());
        }
    }
    private void handleXoaThuoc() {
        Thuoc selected = thuocTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Chọn thuốc để xóa!");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Xác nhận xóa");
        confirm.setHeaderText(null);
        confirm.setContentText("Bạn có chắc chắn muốn xóa thuốc này?");
        if (confirm.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            try {
                thuocDAO.deleteById(selected.getIdThuoc());
                setupThuocTable();
                showAlert("Đã xóa thuốc thành công!");
            } catch (Exception ex) {
                showAlert("Lỗi khi xóa thuốc: " + ex.getMessage());
            }
        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void setupThuocTable() {
        colMaThuoc.setCellValueFactory(new PropertyValueFactory<>("idThuoc"));
        colTenThuoc.setCellValueFactory(new PropertyValueFactory<>("ten"));
        colDanhMuc.setCellValueFactory(new PropertyValueFactory<>("danhMuc"));
        colXuatXu.setCellValueFactory(new PropertyValueFactory<>("xuatXu"));
        colDonViTinh.setCellValueFactory(new PropertyValueFactory<>("donViTinh"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuongTon"));
        colDonGia.setCellValueFactory(new PropertyValueFactory<>("giaBan"));
        ObservableList<Thuoc> list = FXCollections.observableArrayList(thuocDAO.selectAll());
        thuocTable.setItems(list);
    }
}
