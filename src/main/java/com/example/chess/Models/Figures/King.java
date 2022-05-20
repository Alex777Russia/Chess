package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class King implements Figure {

    ArrayList<ArrayList<Figure>> field;

    public Color figureColor;

    public ImageView fieldModel;

    int row;
    int column;

    public King(ImageView fieldModel, Color color, int row, int column, ArrayList<ArrayList<Figure>> field) {
        this.fieldModel = fieldModel;
        this.figureColor = color;
        this.row = row;
        this.column = column;
        this.field = field;
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
        this.row = row;
        this.column = column;
    }

    @Override
    public void kill() {

    }
}
