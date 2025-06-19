package com.controller;

import com.model.entities.TaiKhoan;
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

    private static TaiKhoan currentUser;

    public static void setCurrentUser(TaiKhoan user) {
        currentUser = user;
    }

    public static TaiKhoan getCurrentUser() {
        return currentUser;
    }

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
        applyRolePermissions();
    }

    private void showPermissionError() {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Lỗi phân quyền");
        alert.setHeaderText(null);
        alert.setContentText("Bạn không có quyền truy cập chức năng này!");
        alert.showAndWait();
    }

    private void applyRolePermissions() {
        // Không hiện thông báo khi chỉ mới đăng nhập
        if (currentUser == null) {
            // Không gọi showPermissionError ở đây nữa
            return;
        }
        String role = currentUser.getVaiTro();
        if (role.equalsIgnoreCase("Admin")) {
            // Admin: full access, do nothing
        } else if (role.equalsIgnoreCase("Quản lý")) {
            // Quản lý: chỉ xem phiếu nhập, nhân viên
            if (btnHoaDon != null) btnHoaDon.setOnAction(e -> showPermissionError());
            if (btnKhachHang != null) btnKhachHang.setOnAction(e -> showPermissionError());
            if (btnThuoc != null) btnThuoc.setOnAction(e -> showPermissionError());
            if (btnNhaCungCap != null) btnNhaCungCap.setOnAction(e -> showPermissionError());
            if (btnTaiKhoan != null) btnTaiKhoan.setOnAction(e -> showPermissionError());
        } else if (role.equalsIgnoreCase("Nhân viên")) {
            // Nhân viên: thao tác dữ liệu trừ tài khoản, phiếu nhập, nhân viên
            if (btnTaiKhoan != null) btnTaiKhoan.setOnAction(e -> showPermissionError());
            if (btnPhieuNhap != null) btnPhieuNhap.setOnAction(e -> showPermissionError());
            if (btnNhanVien != null) btnNhanVien.setOnAction(e -> showPermissionError());
        }
    }

    private boolean hasPermission(String action) {
        if (currentUser == null) return false;
        String role = currentUser.getVaiTro().toLowerCase();
        if (role.equals("admin")) return true;
        if (role.contains("quản lý") || role.contains("quan ly")) {
            // Quản lý chỉ không được thao tác tài khoản
            return !action.equals("taikhoan");
        }
        if (role.contains("nhân viên") || role.contains("nhan vien")) {
            // Nhân viên không được thao tác tài khoản, nhân viên, nhà cung cấp, phiếu nhập
            return !(action.equals("taikhoan") || action.equals("nhanvien") || action.equals("nhacungcap") || action.equals("phieunhap"));
        }
        return false;
    }

    @FXML
    private void handleHoaDonAction() {
        if (!hasPermission("hoadon")) { showPermissionError(); return; }
        loadService("/com/hoa-don.fxml");
    }
    @FXML
    private void handleKhachHangAction() {
        if (!hasPermission("khachhang")) { showPermissionError(); return; }
        loadService("/com/khach-hang.fxml");
    }
    @FXML
    private void handleThuocAction() {
        if (!hasPermission("thuoc")) { showPermissionError(); return; }
        loadService("/com/thuoc.fxml");
    }
    @FXML
    private void handlePhieuNhapAction() {
        if (!hasPermission("phieunhap")) { showPermissionError(); return; }
        loadService("/com/phieu-nhap.fxml");
    }
    @FXML
    private void handleNhaCungCapAction() {
        if (!hasPermission("nhacungcap")) { showPermissionError(); return; }
        loadService("/com/nha-cung-cap.fxml");
    }
    @FXML
    private void handleNhanVienAction() {
        if (!hasPermission("nhanvien")) { showPermissionError(); return; }
        loadService("/com/nhan-vien.fxml");
    }
    @FXML
    private void handleTaiKhoanAction() {
        if (!hasPermission("taikhoan")) { showPermissionError(); return; }
        loadService("/com/tai-khoan.fxml");
    }
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

    public void setMainContent(Node node) {
        servicePane.getChildren().setAll(node);
    }
}
