package com.example.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.IOException;

public class MainApp extends Application {

    Media sound = new Media(getClass().getResource("/sounds/MenuSong1.mp3").toExternalForm());

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("enter-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Just Chess");
        stage.getIcons().add(new Image("icon.png"));

        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.stop();

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}