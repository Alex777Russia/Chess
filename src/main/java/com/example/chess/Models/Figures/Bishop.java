package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;

public class Bishop implements Figure {

    Color figureColor;

    ImageView fieldModel;

    int row;
    int column;

    public Bishop(ImageView fieldModel, Color color, int row, int column) {
        this.fieldModel = fieldModel;
        this.figureColor = color;
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean canMakeMove(int row, int column) {
        return false;
    }

    @Override
    public void makeMove(int row, int column) {

    }

    @Override
    public void kill() {

    }
}
