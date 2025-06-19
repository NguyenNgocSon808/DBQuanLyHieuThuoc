package com.controller;

import com.model.dao.KhachHangDAO;
import com.model.entities.KhachHang;
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

public class KhachHangController {
    @FXML private TableView<KhachHang> khachHangTable;
    @FXML private TableColumn<KhachHang, String> colMaKhachHang;
    @FXML private TableColumn<KhachHang, String> colTenKhachHang;
    @FXML private TableColumn<KhachHang, String> colSdtKhachHang;
    @FXML private TableColumn<KhachHang, String> colGioiTinhKhachHang;
    @FXML private Button btnThemKhachHang;
    @FXML private Button btnSuaKhachHang;
    @FXML private Button btnXoaKhachHang;
    @FXML private Button btnInfoKhachHang;
    @FXML private Button refreshButtonKhachHang;

    private final KhachHangDAO khachHangDAO = new KhachHangDAO();

    @FXML
    private void initialize() {
        btnThemKhachHang.setOnAction(e -> handleThemKhachHang());
        btnSuaKhachHang.setOnAction(e -> handleSuaKhachHang());
        if (btnXoaKhachHang != null) btnXoaKhachHang.setOnAction(e -> handleXoaKhachHang());
        refreshButtonKhachHang.setOnAction(e -> setupKhachHangTable());
        setupKhachHangTable();
    }

    private void handleThemKhachHang() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/add-khach-hang.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm khách hàng");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnThem = (Button) root.lookup("#btnThemKhachHang");
            Button btnHuy = (Button) root.lookup("#btnHuyBoKhachHang");
            TextField idField = (TextField) root.lookup("#idKhachHangField");
            TextField hoTenField = (TextField) root.lookup("#hoTenField");
            TextField sdtField = (TextField) root.lookup("#sdtField");
            TextField gioiTinhField = (TextField) root.lookup("#gioiTinhField");
            btnThem.setOnAction(e -> {
                try {
                    KhachHang kh = new KhachHang(
                        idField.getText(),
                        hoTenField.getText(),
                        sdtField.getText(),
                        gioiTinhField.getText()
                    );
                    khachHangDAO.create(kh);
                    setupKhachHangTable();
                    stage.close();
                } catch (Exception ex) {
                    showAlert("Lỗi khi thêm khách hàng: " + ex.getMessage());
                }
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            showAlert("Lỗi khi mở cửa sổ thêm khách hàng: " + e.getMessage());
        }
    }
    private void handleSuaKhachHang() {
        try {
            KhachHang selected = khachHangTable.getSelectionModel().getSelectedItem();
            if (selected == null) { showAlert("Chọn khách hàng để cập nhật!"); return; }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/update-khach-hang.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cập nhật khách hàng");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnCapNhat = (Button) root.lookup("#btnCapNhatKhachHang");
            Button btnHuy = (Button) root.lookup("#btnHuyBoKhachHang");
            TextField idField = (TextField) root.lookup("#idKhachHangField");
            TextField hoTenField = (TextField) root.lookup("#hoTenField");
            TextField sdtField = (TextField) root.lookup("#sdtField");
            TextField gioiTinhField = (TextField) root.lookup("#gioiTinhField");
            idField.setText(selected.getId());
            idField.setDisable(true);
            hoTenField.setText(selected.getHoTen());
            sdtField.setText(selected.getSdt());
            gioiTinhField.setText(selected.getGioiTinh());
            btnCapNhat.setOnAction(e -> {
                try {
                    KhachHang kh = new KhachHang(
                        idField.getText(),
                        hoTenField.getText(),
                        sdtField.getText(),
                        gioiTinhField.getText()
                    );
                    khachHangDAO.update(kh);
                    setupKhachHangTable();
                    stage.close();
                } catch (Exception ex) {
                    showAlert("Lỗi khi cập nhật khách hàng: " + ex.getMessage());
                }
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            showAlert("Lỗi khi mở cửa sổ cập nhật khách hàng: " + e.getMessage());
        }
    }
    private void handleXoaKhachHang() {
        KhachHang selected = khachHangTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Chọn khách hàng để xóa!");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Xác nhận xóa");
        confirm.setHeaderText(null);
        confirm.setContentText("Bạn có chắc chắn muốn xóa khách hàng này?");
        if (confirm.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            try {
                khachHangDAO.deleteById(selected.getId());
                setupKhachHangTable();
                showAlert("Đã xóa khách hàng thành công!");
            } catch (Exception ex) {
                showAlert("Lỗi khi xóa khách hàng: " + ex.getMessage());
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
    private void setupKhachHangTable() {
        colMaKhachHang.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTenKhachHang.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        colSdtKhachHang.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        colGioiTinhKhachHang.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        ObservableList<KhachHang> list = FXCollections.observableArrayList(khachHangDAO.selectAll());
        khachHangTable.setItems(list);
    }
}
