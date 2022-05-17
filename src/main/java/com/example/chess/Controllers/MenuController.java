package com.example.chess;

import com.example.chess.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private boolean findPlayer() {
        return true;
    }

    @FXML
    private void startLocalGame(MouseEvent event) throws IOException {
        startGameScene(event);
    }

    private void startGameScene(MouseEvent event) throws IOException {
        rootObject = new FXMLLoader(MainApp.class.getResource("play-field.fxml")).load();
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        sceneObject = new Scene(rootObject);
        stage.setScene(sceneObject);
        stage.show();
    }

}
