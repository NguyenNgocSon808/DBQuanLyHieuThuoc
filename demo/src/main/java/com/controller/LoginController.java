package com.controller;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
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

    @FXML
    private void loginButtonPressed() {
        handleLogin();
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        TaiKhoan loggedIn = null;
        for (TaiKhoan tk : taiKhoanDAO.selectAll()) {
            if (tk.getUsername().equals(username) && tk.getPassword().equals(password)) {
                loggedIn = tk;
                break;
            }
        }
        if (loggedIn != null) {
            showAlert(Alert.AlertType.INFORMATION, "Đăng nhập thành công!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/home-page.fxml"));
                Parent root = loader.load();
                // Set current user for HomePageController
                com.controller.HomePageController.setCurrentUser(loggedIn);
                // Load Hóa Đơn view vào servicePane
                HomePageController homeController = loader.getController();
                FXMLLoader hoaDonLoader = new FXMLLoader(getClass().getResource("/com/hoa-don.fxml"));
                Node hoaDonView = hoaDonLoader.load();
                homeController.setMainContent(hoaDonView);
                Stage stage = new Stage();
                stage.setTitle("Trang chủ");
                stage.setScene(new Scene(root));
                stage.show();
                // Close login window
                loginButton.getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
