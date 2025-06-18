package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
    private void handleHoaDonAction() {
        loadService("/com/hoa-don.fxml");
    }

    @FXML
    private void handleKhachHangAction() {
        // TODO: Implement khach hang view loading
        System.out.println("Khach hang clicked");
    }

    @FXML
    private void handleThuocAction() {
        // TODO: Implement thuoc view loading
        System.out.println("Thuoc clicked");
    }

    @FXML
    private void handlePhieuNhapAction() {
        // TODO: Implement phieu nhap view loading
        System.out.println("Phieu nhap clicked");
    }

    @FXML
    private void handleNhaCungCapAction() {
        // TODO: Implement nha cung cap view loading
        System.out.println("Nha cung cap clicked");
    }

    @FXML
    private void handleNhanVienAction() {
        loadService("/com/nhan-vien.fxml");
    }

    @FXML
    private void handleTaiKhoanAction() {
        // TODO: Implement tai khoan view loading
        System.out.println("Tai khoan clicked");
    }

    @FXML
    private void handleDangXuatAction() {
        // TODO: Implement logout functionality
        System.out.println("Dang xuat clicked");
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
