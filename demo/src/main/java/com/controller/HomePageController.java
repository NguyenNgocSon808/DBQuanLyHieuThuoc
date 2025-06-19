package com.controller;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Modality;
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

    // Tài khoản view controls
    @FXML private Button btnThem;
    @FXML private Button btnSua;
    @FXML private Button btnXoa;
    @FXML private Button btnInfo;
    @FXML private Button refreshButton;
    @FXML private ComboBox<String> filterVaiTroTaiKhoan;
    @FXML private TextField searchFieldTaiKhoan;
    @FXML private TableView<?> taiKhoanTable;

    // Nhân viên view controls
    @FXML private Button btnThemNV;
    @FXML private Button btnSuaNV;
    @FXML private Button btnXoaNV;
    @FXML private Button btnInfoNV;
    @FXML private Button refreshButtonNV;
    @FXML private ComboBox<String> filterComboNV;
    @FXML private TextField searchFieldNV;
    @FXML private TableView<?> nhanVienTable;

    // Phiếu nhập view controls
    @FXML private Button btnHuyPhieuNhap;
    @FXML private Button btnPrintPhieuNhap;
    @FXML private TextField txtMaPN;
    @FXML private TextField txtTenNCC;
    @FXML private TextField txtTenNV;
    @FXML private TextField txtTong;
    @FXML private TableView<?> tableCTPN;

    // Thuốc view controls
    @FXML private Button btnThemThuoc;
    @FXML private Button btnSuaThuoc;
    @FXML private Button btnXoaThuoc;
    @FXML private Button btnInfoThuoc;
    @FXML private Button refreshButtonThuoc;
    @FXML private ComboBox<String> filterVaiTroThuoc;
    @FXML private ComboBox<String> danhMucCombo;
    @FXML private ComboBox<String> xuatXuCombo;
    @FXML private ComboBox<String> donViTinhCombo;
    @FXML private TextField searchFieldThuoc;
    @FXML private TextField hanSuDungField;
    @FXML private Button hanSuDungSearchBtn;
    @FXML private TableView<?> thuocTable;

    // Khách hàng view controls
    @FXML private Button btnThemKhachHang;
    @FXML private Button btnSuaKhachHang;
    @FXML private Button btnXoaKhachHang;
    @FXML private Button btnInfoKhachHang;
    @FXML private Button refreshButtonKhachHang;
    @FXML private TableView<?> khachHangTable;
    @FXML private ComboBox<String> filterComboKhachHang;
    @FXML private TextField searchFieldKhachHang;

    // Nhà cung cấp view controls
    @FXML private Button btnThemNhaCungCap;
    @FXML private Button btnSuaNhaCungCap;
    @FXML private Button btnXoaNhaCungCap;
    @FXML private Button btnInfoNhaCungCap;
    @FXML private Button refreshButtonNhaCungCap;
    @FXML private TableView<?> nhaCungCapTable;
    @FXML private ComboBox<String> filterComboNhaCungCap;
    @FXML private TextField searchFieldNhaCungCap;

    @FXML
    private void initialize() {
        // Tài khoản actions (if present)
        if (btnThem != null) btnThem.setOnAction(e -> handleThemTaiKhoan());
        if (btnSua != null) btnSua.setOnAction(e -> handleSuaTaiKhoan());
        if (btnXoa != null) btnXoa.setOnAction(e -> handleXoaTaiKhoan());
        if (btnInfo != null) btnInfo.setOnAction(e -> handleInfoTaiKhoan());
        if (refreshButton != null) refreshButton.setOnAction(e -> handleRefreshTaiKhoan());
        // Nhân viên actions (if present)
        if (btnThemNV != null) btnThemNV.setOnAction(e -> handleThemNhanVien());
        if (btnSuaNV != null) btnSuaNV.setOnAction(e -> handleSuaNhanVien());
        if (btnXoaNV != null) btnXoaNV.setOnAction(e -> handleXoaNhanVien());
        if (btnInfoNV != null) btnInfoNV.setOnAction(e -> handleInfoNhanVien());
        if (refreshButtonNV != null) refreshButtonNV.setOnAction(e -> handleRefreshNhanVien());
        // Phiếu nhập actions
        if (btnHuyPhieuNhap != null) btnHuyPhieuNhap.setOnAction(e -> handleHuyPhieuNhap());
        if (btnPrintPhieuNhap != null) btnPrintPhieuNhap.setOnAction(e -> handlePrintPhieuNhap());
        // Thuốc actions
        if (btnThemThuoc != null) btnThemThuoc.setOnAction(e -> handleThemThuoc());
        if (btnSuaThuoc != null) btnSuaThuoc.setOnAction(e -> handleSuaThuoc());
        if (btnXoaThuoc != null) btnXoaThuoc.setOnAction(e -> handleXoaThuoc());
        if (btnInfoThuoc != null) btnInfoThuoc.setOnAction(e -> handleInfoThuoc());
        if (refreshButtonThuoc != null) refreshButtonThuoc.setOnAction(e -> handleRefreshThuoc());
        // Khách hàng actions
        if (btnThemKhachHang != null) btnThemKhachHang.setOnAction(e -> handleThemKhachHang());
        if (btnSuaKhachHang != null) btnSuaKhachHang.setOnAction(e -> handleSuaKhachHang());
        if (btnXoaKhachHang != null) btnXoaKhachHang.setOnAction(e -> handleXoaKhachHang());
        if (btnInfoKhachHang != null) btnInfoKhachHang.setOnAction(e -> handleInfoKhachHang());
        if (refreshButtonKhachHang != null) refreshButtonKhachHang.setOnAction(e -> handleRefreshKhachHang());
        // Nhà cung cấp actions
        if (btnThemNhaCungCap != null) btnThemNhaCungCap.setOnAction(e -> handleThemNhaCungCap());
        if (btnSuaNhaCungCap != null) btnSuaNhaCungCap.setOnAction(e -> handleSuaNhaCungCap());
        if (btnXoaNhaCungCap != null) btnXoaNhaCungCap.setOnAction(e -> handleXoaNhaCungCap());
        if (btnInfoNhaCungCap != null) btnInfoNhaCungCap.setOnAction(e -> handleInfoNhaCungCap());
        if (refreshButtonNhaCungCap != null) refreshButtonNhaCungCap.setOnAction(e -> handleRefreshNhaCungCap());
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

    // Tài khoản actions
    private void handleThemTaiKhoan() { showPopup("/com/add-tai-khoan.fxml", "Thêm tài khoản"); }
    private void handleSuaTaiKhoan() { showPopup("/com/update-tai-khoan.fxml", "Cập nhật tài khoản"); }
    private void handleXoaTaiKhoan() { showAlert("Xóa tài khoản"); }
    private void handleInfoTaiKhoan() { showAlert("Thông tin tài khoản"); }
    private void handleRefreshTaiKhoan() { showAlert("Làm mới danh sách tài khoản"); }

    // Nhân viên actions
    private void handleThemNhanVien() { showPopup("/com/add-nhan-vien.fxml", "Thêm nhân viên"); }
    private void handleSuaNhanVien() { showPopup("/com/update-nhan-vien.fxml", "Cập nhật nhân viên"); }
    private void handleXoaNhanVien() { showAlert("Xóa nhân viên"); }
    private void handleInfoNhanVien() { showAlert("Thông tin nhân viên"); }
    private void handleRefreshNhanVien() { showAlert("Làm mới danh sách nhân viên"); }

    // Phiếu nhập actions
    private void handleHuyPhieuNhap() {
        showAlert("Đã hủy phiếu nhập hoặc đóng dialog.");
    }
    private void handlePrintPhieuNhap() {
        showAlert("In phiếu nhập (chức năng in chưa được triển khai).");
    }

    private void showPopup(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thuốc handlers
    private void handleThemThuoc() { showPopup("/com/add-thuoc.fxml", "Thêm thuốc"); }
    private void handleSuaThuoc() { showPopup("/com/update-thuoc.fxml", "Cập nhật thuốc"); }
    private void handleXoaThuoc() { showAlert("Xóa thuốc"); }
    private void handleInfoThuoc() { showAlert("Thông tin thuốc"); }
    private void handleRefreshThuoc() { showAlert("Làm mới danh sách thuốc"); }
    // Khách hàng handlers
    private void handleThemKhachHang() { showPopup("/com/add-khach-hang.fxml", "Thêm khách hàng"); }
    private void handleSuaKhachHang() { showPopup("/com/update-khach-hang.fxml", "Cập nhật khách hàng"); }
    private void handleXoaKhachHang() { showAlert("Xóa khách hàng"); }
    private void handleInfoKhachHang() { showAlert("Thông tin khách hàng"); }
    private void handleRefreshKhachHang() { showAlert("Làm mới danh sách khách hàng"); }
    // Nhà cung cấp handlers
    private void handleThemNhaCungCap() { showPopup("/com/add-nha-cung-cap.fxml", "Thêm nhà cung cấp"); }
    private void handleSuaNhaCungCap() { showPopup("/com/update-nha-cung-cap.fxml", "Cập nhật nhà cung cấp"); }
    private void handleXoaNhaCungCap() { showAlert("Xóa nhà cung cấp"); }
    private void handleInfoNhaCungCap() { showAlert("Thông tin nhà cung cấp"); }
    private void handleRefreshNhaCungCap() { showAlert("Làm mới danh sách nhà cung cấp"); }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
