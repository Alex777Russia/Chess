package com.example.chess.Controllers;

import com.example.chess.Models.PlayField;
import com.example.chess.Models.Player;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class PlayFieldController {

    // Черные фигуры

    @FXML
    public ImageView black_knight_1;

    @FXML
    public ImageView black_knight_2;

    @FXML
    public ImageView black_rook_1;

    @FXML
    public ImageView black_rook_2;

    @FXML
    public ImageView black_bishop_1;

    @FXML
    public ImageView black_bishop_2;

    @FXML
    public ImageView black_queen;

    @FXML
    public ImageView black_king;

    @FXML
    public ImageView black_pawn_1;

    @FXML
    public ImageView black_pawn_2;

    @FXML
    public ImageView black_pawn_3;

    @FXML
    public ImageView black_pawn_4;

    @FXML
    public ImageView black_pawn_5;

    @FXML
    public ImageView black_pawn_6;

    @FXML
    public ImageView black_pawn_7;

    @FXML
    public ImageView black_pawn_8;


    // Белые фигуры

    @FXML
    public ImageView white_knight_1;

    @FXML
    public ImageView white_knight_2;

    @FXML
    public ImageView white_rook_1;

    @FXML
    public ImageView white_rook_2;

    @FXML
    public ImageView white_bishop_1;

    @FXML
    public ImageView white_bishop_2;

    @FXML
    public ImageView white_queen;

    @FXML
    public ImageView white_king;

    @FXML
    public ImageView white_pawn_1;

    @FXML
    public ImageView white_pawn_2;

    @FXML
    public ImageView white_pawn_3;

    @FXML
    public ImageView white_pawn_4;

    @FXML
    public ImageView white_pawn_5;

    @FXML
    public ImageView white_pawn_6;

    @FXML
    public ImageView white_pawn_7;

    @FXML
    public ImageView white_pawn_8;

    @FXML
    private void figureClicked(MouseEvent event) {

        ImageView clickedFigure = (ImageView) event.getSource();

        if (PlayField.figureInFocus(clickedFigure.idProperty().getValueSafe())) {
            getStage(clickedFigure).setTitle("\"" + clickedFigure.getId() + "\" chosen");
        };
    }

    @FXML
    private void fieldClicked(MouseEvent event) {
        ImageView clickedCell = (ImageView) event.getSource();

        String resultOfMove = PlayField.moveTo(clickedCell);
         if (resultOfMove != null) {
             getStage(clickedCell).setTitle(resultOfMove);
         }

    }

    protected void startGame(Player firstPlayer, Player secondPlayer) {
        PlayField.initGame(firstPlayer, secondPlayer, this);
    }

    private Stage getStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }


}
