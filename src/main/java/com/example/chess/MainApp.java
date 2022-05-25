package com.example.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("enter-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Just Chess");
        stage.getIcons().add(new Image("file::src/main/resources/images/icon.png"));
        //stage.getIcons().add(new Image(<yourclassname>.class.getResourceAsStream("icon.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}