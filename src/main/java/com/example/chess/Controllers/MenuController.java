package com.example.chess.Controllers;

import com.example.chess.MainApp;
import com.example.chess.Models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Scene sceneObject;

    @FXML
    private Parent rootObject;

    @FXML
    private Stage stage;

    @FXML
    private Button localGameButton;

    @FXML
    private Button networkGameButton;

    @FXML
    private RadioButton volumeButton;

    private Media sound = null;
    private MediaPlayer mediaPlayer = null;

    @FXML
    private boolean findPlayer() {
        return true;
    }

    @FXML
    private void startLocalGame(MouseEvent event) throws IOException {
        PlayFieldController playFieldController = startGameScene(event);

        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        playFieldController.startGame(firstPlayer, secondPlayer);
    }

    private PlayFieldController startGameScene(MouseEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(MainApp.class.getResource("play-field.fxml"));
        rootObject = root.load();
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        sceneObject = new Scene(rootObject);
        stage.setScene(sceneObject);
        stage.show();
        return root.getController();
    }

    @FXML
    public void RadioButtonSwitch(MouseEvent event) {
        if (volumeButton.isSelected() == true) {
            int trackNumber = (int) (Math.random() * 5 + 1);
            String trackName = "/sounds/MenuSong" + trackNumber + ".mp3";
            sound = new Media(MainApp.class.getResource(trackName).toExternalForm());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } else {
            mediaPlayer.stop();
            sound = null;
            mediaPlayer = null;
        }
    }
}
