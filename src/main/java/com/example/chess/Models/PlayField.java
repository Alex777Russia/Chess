package com.example.chess.Models;

import com.example.chess.Controllers.PlayFieldController;
import com.example.chess.MainApp;
import com.example.chess.Models.Figures.Bishop;
import com.example.chess.Models.Figures.Pawn;
import com.example.chess.Models.Figures.King;
import com.example.chess.Models.Figures.Queen;
import com.example.chess.Models.Figures.Rook;
import com.example.chess.Models.Figures.Knight;
import javafx.css.SizeUnits;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract public class PlayField {

    static public ArrayList<Figure> playingFigures = new ArrayList<>();

    static public ArrayList<Figure> killedBlackFigures;

    static public ArrayList<Figure> killedWhiteFigures;

    static public Player whitePlayer;

    static public Player blackPlayer;

    static public Figure.Color whoseMove = null;

    static public Figure chosenFigure = null;

    static public void initGame(Player firstPlayer, Player secondPlayer, PlayFieldController playFieldController) {
        // Заполнение игрового поля основными фигурами
        System.out.println(playFieldController.white_king);
        Collections.addAll(playingFigures,
                new King(playFieldController.white_king, Figure.Color.WHITE, 0, 3),
                new King(playFieldController.black_king, Figure.Color.BLACK, 7, 3),

                new Queen(playFieldController.white_queen, Figure.Color.WHITE, 0, 4),
                new Queen(playFieldController.black_queen, Figure.Color.BLACK, 7, 4),

                new Bishop(playFieldController.white_bishop_1, Figure.Color.WHITE, 0, 2),
                new Bishop(playFieldController.white_bishop_2, Figure.Color.WHITE, 0, 5),

                new Bishop(playFieldController.black_bishop_1, Figure.Color.BLACK, 7, 2),
                new Bishop(playFieldController.black_bishop_2, Figure.Color.BLACK, 7, 5),

                new Knight(playFieldController.white_knight_1, Figure.Color.WHITE, 0, 1),
                new Knight(playFieldController.white_knight_2, Figure.Color.WHITE, 0, 6),

                new Knight(playFieldController.black_knight_1, Figure.Color.BLACK, 7, 1),
                new Knight(playFieldController.black_knight_2, Figure.Color.BLACK, 7, 6),

                new Rook(playFieldController.white_rook_1, Figure.Color.WHITE, 0, 0),
                new Rook(playFieldController.white_rook_2, Figure.Color.WHITE, 0, 7),

                new Rook(playFieldController.black_rook_1, Figure.Color.BLACK, 7, 0),
                new Rook(playFieldController.black_rook_2, Figure.Color.BLACK, 7, 7));

        // Инициализация пешек
        playingFigures.add(new Pawn(playFieldController.black_pawn_1, Figure.Color.BLACK, 1, 0));
        playingFigures.add(new Pawn(playFieldController.black_pawn_2, Figure.Color.BLACK, 1, 1));
        playingFigures.add(new Pawn(playFieldController.black_pawn_3, Figure.Color.BLACK, 1, 2));
        playingFigures.add(new Pawn(playFieldController.black_pawn_4, Figure.Color.BLACK, 1, 3));
        playingFigures.add(new Pawn(playFieldController.black_pawn_5, Figure.Color.BLACK, 1, 4));
        playingFigures.add(new Pawn(playFieldController.black_pawn_6, Figure.Color.BLACK, 1, 5));
        playingFigures.add(new Pawn(playFieldController.black_pawn_7, Figure.Color.BLACK, 1, 6));
        playingFigures.add(new Pawn(playFieldController.black_pawn_8, Figure.Color.BLACK, 1, 7));

        playingFigures.add(new Pawn(playFieldController.white_pawn_1, Figure.Color.WHITE, 6, 0));
        playingFigures.add(new Pawn(playFieldController.white_pawn_2, Figure.Color.WHITE, 6, 1));
        playingFigures.add(new Pawn(playFieldController.white_pawn_3, Figure.Color.WHITE, 6, 2));
        playingFigures.add(new Pawn(playFieldController.white_pawn_4, Figure.Color.WHITE, 6, 3));
        playingFigures.add(new Pawn(playFieldController.white_pawn_5, Figure.Color.WHITE, 6, 4));
        playingFigures.add(new Pawn(playFieldController.white_pawn_6, Figure.Color.WHITE, 6, 5));
        playingFigures.add(new Pawn(playFieldController.white_pawn_7, Figure.Color.WHITE, 6, 6));
        playingFigures.add(new Pawn(playFieldController.white_pawn_8, Figure.Color.WHITE, 6, 7));
    }

    static public void endGame() {

    }

    static public boolean isCheckMate() {
        return false;
    }

    static public boolean isCheck() {
        return false;
    }

    // Вызывается при нажатии на фигуру. Устанавливает фокус на нее. Также тут надо доделать механику убийства фигур
    static public void figureInFocus(String newFigureId) {
        Figure newFigure = findFigureById(newFigureId);

        if (chosenFigure == null) {
            chosenFigure = newFigure;
            whoseMove = newFigure.getColor();
            return;
        }

        if (newFigure.getColor() == newFigure.getColor()) {
            chosenFigure = newFigure;
        }

    }

    // Главный регулирующий метод хода. Вызывает метод проверки возможности хода для каждой фигуры и меняет UI.
    static public void moveTo(ImageView clickedCell) {

        if (chosenFigure != null && chosenFigure.getColor() == whoseMove) {

            Pair<Integer, Integer> coordinates = getCellCoordinates(clickedCell);

            if (chosenFigure.canMakeMove(coordinates.getKey(), coordinates.getValue())) {
                chosenFigure.makeMove(coordinates.getKey(), coordinates.getValue());

                // Пермещение фигуры в новый StackPane
                ((StackPane) clickedCell.getParent()).getChildren().add(chosenFigure.getFigureModel());
            }

            // Изменение переменной хода (если ходили белые - ходят черные, и наоборот)
            whoseMove = chosenFigure.getColor() == Figure.Color.WHITE ? Figure.Color.BLACK : Figure.Color.WHITE;
        }

    }

    // Метод для получения координат кликнутой клетки
    static private Pair<Integer, Integer> getCellCoordinates(ImageView clickedCell) {
        System.out.println(GridPane.getRowIndex(clickedCell.getParent()));
        System.out.println(GridPane.getColumnIndex(clickedCell.getParent()));
        return new Pair<>(GridPane.getRowIndex(clickedCell.getParent()),
                GridPane.getColumnIndex(clickedCell.getParent()));

    }

    // Метод для нахождения объекта фигуры из списка по id из верстки
    static private Figure findFigureById(String newFigureId) {
        for (Figure figure : playingFigures) {
            if (figure.getFigureModel().idProperty().getValueSafe().equals(newFigureId)) {
                return figure;
            }
        }
        return null;
    }

}
