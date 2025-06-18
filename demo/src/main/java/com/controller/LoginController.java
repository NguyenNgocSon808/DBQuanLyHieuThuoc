package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.model.dao.TaiKhoanDAO;
import com.model.entities.TaiKhoan;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    @FXML
    private void initialize() {
        loginButton.setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean authenticated = false;
        for (TaiKhoan tk : taiKhoanDAO.selectAll()) {
            if (tk.getUsername().equals(username) && tk.getPassword().equals(password)) {
                authenticated = true;
                break;
            }
        }
        if (authenticated) {
            showAlert(Alert.AlertType.INFORMATION, "Đăng nhập thành công!");
            // TODO: Chuyển sang giao diện chính
        } else {
            showAlert(Alert.AlertType.ERROR, "Sai tài khoản hoặc mật khẩu!");
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
