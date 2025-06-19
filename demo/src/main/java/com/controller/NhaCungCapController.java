package com.controller;

import com.model.dao.NhaCungCapDAO;
import com.model.entities.NhaCungCap;
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

public class NhaCungCapController {
    @FXML private TableView<NhaCungCap> nhaCungCapTable;
    @FXML private TableColumn<NhaCungCap, String> colMaNhaCungCap;
    @FXML private TableColumn<NhaCungCap, String> colTenNhaCungCap;
    @FXML private TableColumn<NhaCungCap, String> colSdtNhaCungCap;
    @FXML private TableColumn<NhaCungCap, String> colDiaChiNhaCungCap;
    @FXML private Button btnThemNhaCungCap;
    @FXML private Button btnSuaNhaCungCap;
    @FXML private Button refreshButtonNhaCungCap;
    @FXML private Button btnXoaNhaCungCap;

    private final NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

    @FXML
    private void initialize() {
        btnThemNhaCungCap.setOnAction(e -> handleThemNhaCungCap());
        btnSuaNhaCungCap.setOnAction(e -> handleSuaNhaCungCap());
        if (btnXoaNhaCungCap != null) btnXoaNhaCungCap.setOnAction(e -> handleXoaNhaCungCap());
        refreshButtonNhaCungCap.setOnAction(e -> setupNhaCungCapTable());
        setupNhaCungCapTable();
    }

    private void handleThemNhaCungCap() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/add-nha-cung-cap.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm nhà cung cấp");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnThem = (Button) root.lookup("#btnThemNhaCungCap");
            Button btnHuy = (Button) root.lookup("#btnHuyBoNhaCungCap");
            TextField idField = (TextField) root.lookup("#idNhaCungCapField");
            TextField tenField = (TextField) root.lookup("#tenNhaCungCapField");
            TextField sdtField = (TextField) root.lookup("#sdtField");
            TextField diaChiField = (TextField) root.lookup("#diaChiField");
            btnThem.setOnAction(e -> {
                try {
                    NhaCungCap ncc = new NhaCungCap(
                        idField.getText(),
                        tenField.getText(),
                        sdtField.getText(),
                        diaChiField.getText()
                    );
                    nhaCungCapDAO.create(ncc);
                    setupNhaCungCapTable();
                    stage.close();
                } catch (Exception ex) {
                    showAlert("Lỗi khi thêm nhà cung cấp: " + ex.getMessage());
                }
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            showAlert("Lỗi khi mở cửa sổ thêm nhà cung cấp: " + e.getMessage());
        }
    }
    private void handleSuaNhaCungCap() {
        try {
            NhaCungCap selected = nhaCungCapTable.getSelectionModel().getSelectedItem();
            if (selected == null) { showAlert("Chọn nhà cung cấp để cập nhật!"); return; }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/update-nha-cung-cap.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Cập nhật nhà cung cấp");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            Button btnCapNhat = (Button) root.lookup("#btnCapNhatNhaCungCap");
            Button btnHuy = (Button) root.lookup("#btnHuyBoNhaCungCap");
            TextField idField = (TextField) root.lookup("#idNhaCungCapField");
            TextField tenField = (TextField) root.lookup("#tenNhaCungCapField");
            TextField sdtField = (TextField) root.lookup("#sdtField");
            TextField diaChiField = (TextField) root.lookup("#diaChiField");
            idField.setText(selected.getIdncc());
            idField.setDisable(true);
            tenField.setText(selected.getTenNhaCungCap());
            sdtField.setText(selected.getSdt());
            diaChiField.setText(selected.getDiaChi());
            btnCapNhat.setOnAction(e -> {
                try {
                    NhaCungCap ncc = new NhaCungCap(
                        idField.getText(),
                        tenField.getText(),
                        sdtField.getText(),
                        diaChiField.getText()
                    );
                    nhaCungCapDAO.update(ncc);
                    setupNhaCungCapTable();
                    stage.close();
                } catch (Exception ex) {
                    showAlert("Lỗi khi cập nhật nhà cung cấp: " + ex.getMessage());
                }
            });
            btnHuy.setOnAction(e -> stage.close());
            stage.showAndWait();
        } catch (Exception e) {
            showAlert("Lỗi khi mở cửa sổ cập nhật nhà cung cấp: " + e.getMessage());
        }
    }
    private void handleXoaNhaCungCap() {
        NhaCungCap selected = nhaCungCapTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Chọn nhà cung cấp để xóa!");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Xác nhận xóa");
        confirm.setHeaderText(null);
        confirm.setContentText("Bạn có chắc chắn muốn xóa nhà cung cấp này?");
        if (confirm.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            try {
                nhaCungCapDAO.deleteById(selected.getIdncc());
                setupNhaCungCapTable();
                showAlert("Đã xóa nhà cung cấp thành công!");
            } catch (Exception ex) {
                showAlert("Lỗi khi xóa nhà cung cấp: " + ex.getMessage());
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
    private void setupNhaCungCapTable() {
        colMaNhaCungCap.setCellValueFactory(new PropertyValueFactory<>("idncc"));
        colTenNhaCungCap.setCellValueFactory(new PropertyValueFactory<>("tenNhaCungCap"));
        colSdtNhaCungCap.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        colDiaChiNhaCungCap.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        ObservableList<NhaCungCap> list = FXCollections.observableArrayList(nhaCungCapDAO.selectAll());
        nhaCungCapTable.setItems(list);
    }
}
