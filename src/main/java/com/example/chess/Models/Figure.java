package com.example.chess.Models;

import javafx.scene.image.ImageView;
import javafx.util.Pair;

public interface Figure {

    enum Color {
        WHITE,
        BLACK
    }

    public Pair<Integer, Integer> getCoordinates();

    public Color getColor();

    public ImageView getFigureModel();

    public boolean canMakeMove(int row, int column);

    public void makeMove(int row, int column);

}
