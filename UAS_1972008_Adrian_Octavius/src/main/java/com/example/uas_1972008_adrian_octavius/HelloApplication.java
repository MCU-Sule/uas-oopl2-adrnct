package com.example.uas_1972008_adrian_octavius;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("login-view.fxml"));
        loader.setResources(ResourceBundle.getBundle("bundle"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("UAS 1972008");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}