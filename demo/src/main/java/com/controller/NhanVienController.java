package com.controller;

import com.model.dao.NhanVienDAO;
import com.model.entities.NhanVien;
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

public class NhanVienController {
    @FXML private TableView<NhanVien> nhanVienTable;
    @FXML private TableColumn<NhanVien, String> colMaNhanVien;
    @FXML private TableColumn<NhanVien, String> colTenNhanVien;
    @FXML private TableColumn<NhanVien, String> colSdtNhanVien;
    @FXML private TableColumn<NhanVien, String> colGioiTinhNhanVien;
    @FXML private TableColumn<NhanVien, String> colVaiTroNhanVien;
    @FXML private TableColumn<NhanVien, Integer> colNamSinhNhanVien;
    @FXML private TableColumn<NhanVien, java.util.Date> colNgayVaoLamNhanVien;
    @FXML private Button btnThemNV;
    @FXML private Button btnSuaNV;
    @FXML private Button refreshButtonNV;

    private final NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @FXML
    private void initialize() {
        btnThemNV.setOnAction(e -> handleThemNhanVien());
        btnSuaNV.setOnAction(e -> handleSuaNhanVien());
        refreshButtonNV.setOnAction(e -> setupNhanVienTable());
        setupNhanVienTable();
    }

    private void handleThemNhanVien() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/add-nhan-vien.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm nhân viên");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnThem = (Button) root.lookup("#btnThemNhanVien");
            Button btnHuy = (Button) root.lookup("#btnHuyBoNhanVien");
            TextField idField = (TextField) root.lookup("#idNhanVienField");
            TextField hoTenField = (TextField) root.lookup("#hoTenField");
            TextField sdtField = (TextField) root.lookup("#sdtField");
            ComboBox<String> gioiTinhCombo = (ComboBox<String>) root.lookup("#gioiTinhCombo");
            TextField vaiTroField = (TextField) root.lookup("#vaiTroField");
            TextField namSinhField = (TextField) root.lookup("#namSinhField");
            DatePicker ngayVaoLamPicker = (DatePicker) root.lookup("#ngayVaoLamPicker");
            btnThem.setOnAction(e -> {
                NhanVien nv = new NhanVien(
                    idField.getText(),
                    hoTenField.getText(),
                    sdtField.getText(),
                    gioiTinhCombo.getValue() == null ? "" : gioiTinhCombo.getValue().toString(),
                    vaiTroField.getText(),
                    Integer.parseInt(namSinhField.getText()),
                    java.sql.Date.valueOf(ngayVaoLamPicker.getValue())
                );
                nhanVienDAO.create(nv);
                setupNhanVienTable();
                stage.close();
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleSuaNhanVien() {
        try {
            NhanVien selected = nhanVienTable.getSelectionModel().getSelectedItem();
            if (selected == null) { showAlert("Chọn nhân viên để cập nhật!"); return; }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/update-nhan-vien.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cập nhật nhân viên");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnCapNhat = (Button) root.lookup("#btnCapNhatNhanVien");
            Button btnHuy = (Button) root.lookup("#btnHuyBoNhanVien");
            TextField idField = (TextField) root.lookup("#idNhanVienField");
            TextField hoTenField = (TextField) root.lookup("#hoTenField");
            TextField sdtField = (TextField) root.lookup("#sdtField");
            ComboBox<String> gioiTinhCombo = (ComboBox<String>) root.lookup("#gioiTinhCombo");
            TextField vaiTroField = (TextField) root.lookup("#vaiTroField");
            TextField namSinhField = (TextField) root.lookup("#namSinhField");
            DatePicker ngayVaoLamPicker = (DatePicker) root.lookup("#ngayVaoLamPicker");
            idField.setText(selected.getIdnv());
            idField.setDisable(true);
            hoTenField.setText(selected.getHoTen());
            sdtField.setText(selected.getSdt());
            gioiTinhCombo.setValue(selected.getGioiTinh());
            vaiTroField.setText(selected.getVaiTro());
            namSinhField.setText(String.valueOf(selected.getNamSinh()));
            ngayVaoLamPicker.setValue(new java.sql.Date(selected.getNgayVaoLam().getTime()).toLocalDate());
            btnCapNhat.setOnAction(e -> {
                NhanVien nv = new NhanVien(
                    idField.getText(),
                    hoTenField.getText(),
                    sdtField.getText(),
                    gioiTinhCombo.getValue() == null ? "" : gioiTinhCombo.getValue().toString(),
                    vaiTroField.getText(),
                    Integer.parseInt(namSinhField.getText()),
                    java.sql.Date.valueOf(ngayVaoLamPicker.getValue())
                );
                nhanVienDAO.update(nv);
                setupNhanVienTable();
                stage.close();
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void setupNhanVienTable() {
        colMaNhanVien.setCellValueFactory(new PropertyValueFactory<>("idnv"));
        colTenNhanVien.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        colSdtNhanVien.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        colGioiTinhNhanVien.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        colVaiTroNhanVien.setCellValueFactory(new PropertyValueFactory<>("vaiTro"));
        colNamSinhNhanVien.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        colNgayVaoLamNhanVien.setCellValueFactory(new PropertyValueFactory<>("ngayVaoLam"));
        ObservableList<NhanVien> list = FXCollections.observableArrayList(nhanVienDAO.selectAll());
        nhanVienTable.setItems(list);
    }
}
