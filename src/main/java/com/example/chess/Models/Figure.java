package com.example.chess.Models;

import javafx.scene.image.ImageView;

public interface Figure {

    ImageView figure = null;

    boolean canMakeMove(int row, int column);

    void makeMove(int row, int column);

    void kill();





}
