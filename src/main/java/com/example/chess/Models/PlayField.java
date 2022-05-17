package com.example.chess.Models;

import java.util.ArrayList;

abstract public class PlayField {

    static ArrayList<Figure> playingFigures;

    static ArrayList<Figure> killedBlackFigures;

    static ArrayList<Figure> killedWhiteFigures;

    static Player whitePlayer;

    static Player blackPlayer;

    static void initGame() {

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
