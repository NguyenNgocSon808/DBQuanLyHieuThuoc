package com.controller;

import com.model.dao.TaiKhoanDAO;
import com.model.entities.TaiKhoan;
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

public class TaiKhoanController {
    @FXML private TableView<TaiKhoan> taiKhoanTable;
    @FXML private TableColumn<TaiKhoan, String> colMaTaiKhoan;
    @FXML private TableColumn<TaiKhoan, String> colUsername;
    @FXML private TableColumn<TaiKhoan, String> colPassword;
    @FXML private TableColumn<TaiKhoan, String> colTenNhanVienTK;
    @FXML private TableColumn<TaiKhoan, String> colVaiTroTK;
    @FXML private Button btnThem;
    @FXML private Button btnSua;
    @FXML private Button refreshButton;

    private final TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    @FXML
    private void initialize() {
        btnThem.setOnAction(e -> handleThemTaiKhoan());
        btnSua.setOnAction(e -> handleSuaTaiKhoan());
        refreshButton.setOnAction(e -> setupTaiKhoanTable());
        setupTaiKhoanTable();
    }

    private void handleThemTaiKhoan() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/add-tai-khoan.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm tài khoản");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnThem = (Button) root.lookup("#btnThemTaiKhoan");
            Button btnHuy = (Button) root.lookup("#btnHuyBoTaiKhoan");
            TextField idField = (TextField) root.lookup("#idTaiKhoanField");
            TextField usernameField = (TextField) root.lookup("#usernameField");
            PasswordField passwordField = (PasswordField) root.lookup("#passwordField");
            TextField idNhanVienField = (TextField) root.lookup("#idNhanVienField");
            TextField vaiTroField = (TextField) root.lookup("#vaiTroField");
            btnThem.setOnAction(e -> {
                TaiKhoan tk = new TaiKhoan(
                    idField.getText(),
                    usernameField.getText(),
                    passwordField.getText(),
                    idNhanVienField.getText(),
                    vaiTroField.getText()
                );
                taiKhoanDAO.create(tk);
                setupTaiKhoanTable();
                stage.close();
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleSuaTaiKhoan() {
        try {
            TaiKhoan selected = taiKhoanTable.getSelectionModel().getSelectedItem();
            if (selected == null) { showAlert("Chọn tài khoản để cập nhật!"); return; }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/update-tai-khoan.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cập nhật tài khoản");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnCapNhat = (Button) root.lookup("#btnCapNhatTaiKhoan");
            Button btnHuy = (Button) root.lookup("#btnHuyBoTaiKhoan");
            TextField idField = (TextField) root.lookup("#idTaiKhoanField");
            TextField usernameField = (TextField) root.lookup("#usernameField");
            PasswordField passwordField = (PasswordField) root.lookup("#passwordField");
            TextField idNhanVienField = (TextField) root.lookup("#idNhanVienField");
            TextField vaiTroField = (TextField) root.lookup("#vaiTroField");
            idField.setText(selected.getIdtk());
            idField.setDisable(true);
            usernameField.setText(selected.getUsername());
            passwordField.setText(selected.getPassword());
            idNhanVienField.setText(selected.getIdnv());
            vaiTroField.setText(selected.getVaiTro());
            btnCapNhat.setOnAction(e -> {
                TaiKhoan tk = new TaiKhoan(
                    idField.getText(),
                    usernameField.getText(),
                    passwordField.getText(),
                    idNhanVienField.getText(),
                    vaiTroField.getText()
                );
                taiKhoanDAO.update(tk);
                setupTaiKhoanTable();
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
    private void setupTaiKhoanTable() {
        colMaTaiKhoan.setCellValueFactory(new PropertyValueFactory<>("idtk"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colTenNhanVienTK.setCellValueFactory(new PropertyValueFactory<>("idnv"));
        colVaiTroTK.setCellValueFactory(new PropertyValueFactory<>("vaiTro"));
        ObservableList<TaiKhoan> list = FXCollections.observableArrayList(taiKhoanDAO.selectAll());
        taiKhoanTable.setItems(list);
    }
}
