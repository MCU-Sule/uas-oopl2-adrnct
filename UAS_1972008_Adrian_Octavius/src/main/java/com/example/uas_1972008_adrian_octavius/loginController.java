package com.example.uas_1972008_adrian_octavius;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class loginController {
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    public void loginAction(ActionEvent actionEvent) throws IOException {
        if (txtUsername.getText().equals("1972008") && txtPassword.getText().equals("12345")) {
            Stage new_stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main-view.fxml"));
            loader.setResources(ResourceBundle.getBundle("Bundle"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            new_stage.setTitle("Login");
            new_stage.initModality(Modality.WINDOW_MODAL);
            new_stage.initOwner(txtPassword.getScene().getWindow());
            new_stage.setScene(scene);
            new_stage.show();
        }
    }
}
