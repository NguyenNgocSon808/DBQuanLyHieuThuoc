package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert;

public class TaiKhoanController {
    @FXML private Button btnThem;
    @FXML private Button btnSua;
    @FXML private Button btnXoa;
    @FXML private Button btnInfo;
    @FXML private Button refreshButton;
    @FXML private ComboBox<String> filterVaiTro;
    @FXML private TextField searchField;
    @FXML private TableView<?> taiKhoanTable;
    @FXML private TableColumn<?, ?> sttColumn;
    @FXML private TableColumn<?, ?> maTaiKhoanColumn;
    @FXML private TableColumn<?, ?> usernameColumn;
    @FXML private TableColumn<?, ?> passwordColumn;
    @FXML private TableColumn<?, ?> tenNhanVienColumn;
    @FXML private TableColumn<?, ?> vaiTroColumn;

    @FXML
    private void initialize() {
        btnThem.setOnAction(e -> handleThem());
        btnSua.setOnAction(e -> handleSua());
        btnXoa.setOnAction(e -> handleXoa());
        btnInfo.setOnAction(e -> handleInfo());
        refreshButton.setOnAction(e -> handleRefresh());
    }

    private void handleThem() {
        showAlert("Thêm tài khoản");
    }
    private void handleSua() {
        showAlert("Sửa tài khoản");
    }
    private void handleXoa() {
        showAlert("Xóa tài khoản");
    }
    private void handleInfo() {
        showAlert("Thông tin tài khoản");
    }
    private void handleRefresh() {
        showAlert("Làm mới danh sách tài khoản");
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
