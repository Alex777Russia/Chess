package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;

public class Queen implements Figure {

    Color figureColor;

    ImageView fieldModel;

    int row;
    int column;

    public Queen(ImageView fieldModel, Color color, int row, int column) {
        this.fieldModel = fieldModel;
        this.figureColor = color;
        this.row = row;
        this.column = column;
    }

    @Override
    public ImageView getFigureModel() {
        return fieldModel;
    }

    @Override
    public Color getColor() {
        return figureColor;
    }

    @Override
    public boolean canMakeMove(int row, int column) {
        return true;
    }

    @Override
    public void makeMove(int row, int column) {

    }

    @Override
    public void kill() {

    }
}
