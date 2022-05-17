package com.example.chess.Models;

import com.example.chess.Controllers.PlayFieldController;
import com.example.chess.Models.Figures.Bishop;
import com.example.chess.Models.Figures.Pawn;
import com.example.chess.Models.Figures.King;
import com.example.chess.Models.Figures.Queen;
import com.example.chess.Models.Figures.Rook;
import com.example.chess.Models.Figures.Knight;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class PlayField {

    static public List<Figure> playingFigures;

    static public List<Figure> killedBlackFigures;

    static public List<Figure> killedWhiteFigures;

    static public Player whitePlayer;

    static public Player blackPlayer;

    static public Figure.Color whoseMove = Figure.Color.WHITE;

    static public void initGame(Player firstPlayer, Player secondPlayer) {

        // Заполнение игрового поля основными фигурами
        playingFigures = List.of(new King(Figure.Color.WHITE, 0, 3),
                new King(Figure.Color.BLACK, 7, 3),
                new Queen(Figure.Color.WHITE, 0, 4),
                new Queen(Figure.Color.BLACK, 7, 4),
                new Bishop(PlayFieldController.black_bishop_1, Figure.Color.WHITE, 0, 2),
                new Bishop(PlayFieldController.black_bishop_2, Figure.Color.BLACK, 7, 2),
                new Knight(Figure.Color.WHITE, 0, 1),
                new Knight(Figure.Color.BLACK, 7, 1),
                new Rook(Figure.Color.WHITE, 0, 0),
                new Rook(Figure.Color.BLACK, 7, 0));

        // Инициализация пешек
        for (int i = 0; i < 8; ++i) {
            playingFigures.add(new Pawn(Figure.Color.BLACK, 6, i));
            playingFigures.add(new Pawn(Figure.Color.WHITE, 1, i));
        }
    }

    static void endGame() {

    }

    static boolean isCheckMate() {
        return false;
    }

    static boolean isCheck() {
        return false;
    }

    static void moveTo(int row, int column) {

    }



}
