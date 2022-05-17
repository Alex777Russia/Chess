package com.example.chess.Controllers;

import com.example.chess.Models.PlayField;
import com.example.chess.Models.Player;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class PlayFieldController {

    // Черные фигуры

    @FXML
    static public ImageView black_knight_1;

    @FXML
    static public ImageView black_knight_2;

    @FXML
    static public ImageView black_rook_1;

    @FXML
    static public ImageView black_rook_2;

    @FXML
    static public ImageView black_bishop_1;

    @FXML
    static public ImageView black_bishop_2;

    @FXML
    private ImageView black_queen;

    @FXML
    private ImageView black_king;

    @FXML
    private ImageView black_pawn_1;

    @FXML
    private ImageView black_pawn_2;

    @FXML
    private ImageView black_pawn_3;

    @FXML
    private ImageView black_pawn_4;

    @FXML
    private ImageView black_pawn_5;

    @FXML
    private ImageView black_pawn_6;

    @FXML
    private ImageView black_pawn_7;

    @FXML
    private ImageView black_pawn_8;


    // Белые фигуры

    @FXML
    private ImageView white_knight_1;

    @FXML
    private ImageView white_knight_2;

    @FXML
    private ImageView white_rook_1;

    @FXML
    private ImageView white_rook_2;

    @FXML
    private ImageView white_bishop_1;

    @FXML
    private ImageView white_bishop_2;

    @FXML
    private ImageView white_queen;

    @FXML
    private ImageView white_king;

    @FXML
    private ImageView white_pawn_1;

    @FXML
    private ImageView white_pawn_2;

    @FXML
    private ImageView white_pawn_3;

    @FXML
    private ImageView white_pawn_4;

    @FXML
    private ImageView white_pawn_5;

    @FXML
    private ImageView white_pawn_6;

    @FXML
    private ImageView white_pawn_7;

    @FXML
    private ImageView white_pawn_8;


    @FXML
    private void fieldClicked(MouseEvent event) {
        ImageView clickedFigure = (ImageView) event.getSource();

        if (PlayField.playingFigures.contains(clickedFigure)) {  // Если элемент доски, вызвавший метод - фигура,
            // а не пустая ячейка что-то делаем
        } else {
            // тоже что-то делаем
        }

    }

    static void startGame(Player firstPlayer, Player secondPlayer) {
        PlayField.initGame(firstPlayer, secondPlayer);
    }

}
