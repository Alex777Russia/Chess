package com.example.chess.Models;

import javafx.scene.image.ImageView;

public interface Figure {

    enum Color {
        WHITE,
        BLACK
    }

    public boolean canMakeMove(int row, int column);

    public void makeMove(int row, int column);

    public void kill();
}
