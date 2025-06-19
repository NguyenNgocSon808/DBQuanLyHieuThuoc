package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HomePageController {
    @FXML private StackPane servicePane;
    @FXML private Button btnHoaDon;
    @FXML private Button btnKhachHang;
    @FXML private Button btnThuoc;
    @FXML private Button btnPhieuNhap;
    @FXML private Button btnNhaCungCap;
    @FXML private Button btnNhanVien;
    @FXML private Button btnTaiKhoan;
    @FXML private Button btnDangXuat;

    @FXML
    private void initialize() {
        if (btnHoaDon != null) btnHoaDon.setOnAction(e -> handleHoaDonAction());
        if (btnKhachHang != null) btnKhachHang.setOnAction(e -> handleKhachHangAction());
        if (btnThuoc != null) btnThuoc.setOnAction(e -> handleThuocAction());
        if (btnPhieuNhap != null) btnPhieuNhap.setOnAction(e -> handlePhieuNhapAction());
        if (btnNhaCungCap != null) btnNhaCungCap.setOnAction(e -> handleNhaCungCapAction());
        if (btnNhanVien != null) btnNhanVien.setOnAction(e -> handleNhanVienAction());
        if (btnTaiKhoan != null) btnTaiKhoan.setOnAction(e -> handleTaiKhoanAction());
        if (btnDangXuat != null) btnDangXuat.setOnAction(e -> handleDangXuatAction());
    }

    @FXML
    private void handleHoaDonAction() { loadService("/com/hoa-don.fxml"); }
    @FXML
    private void handleKhachHangAction() { loadService("/com/khach-hang.fxml"); }
    @FXML
    private void handleThuocAction() { loadService("/com/thuoc.fxml"); }
    @FXML
    private void handlePhieuNhapAction() { loadService("/com/phieu-nhap.fxml"); }
    @FXML
    private void handleNhaCungCapAction() { loadService("/com/nha-cung-cap.fxml"); }
    @FXML
    private void handleNhanVienAction() { loadService("/com/nhan-vien.fxml"); }
    @FXML
    private void handleTaiKhoanAction() { loadService("/com/tai-khoan.fxml"); }
    @FXML
    private void handleDangXuatAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Đăng nhập");
            stage.setScene(new Scene(root));
            stage.show();
            btnDangXuat.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadService(String fxmlPath) {
        try {
            Node content = FXMLLoader.load(getClass().getResource(fxmlPath));
            servicePane.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
