package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.util.ArrayList;


public class Pawn implements Figure {

    ArrayList<ArrayList<Figure>> field;

    Color figureColor;

    ImageView fieldModel;

    int row;
    int column;

    public Pawn(ImageView fieldModel, Color color, int row, int column, ArrayList<ArrayList<Figure>> field) {
        this.fieldModel = fieldModel;
        this.figureColor = color;
        this.row = row;
        this.column = column;
        this.field = field;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return new Pair<Integer, Integer>(row, column);
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
        if (this.column == column) {
            if (this.figureColor == Color.WHITE && this.row - row > 0) {
                if (this.row == 6) {
                    if ((this.row - row <= 2) && (this.field.get(5).get(column) == null)) {
                        return true;
                    }
                } else if (this.row - row == 1) {
                    return true;
                }
            } else if (this.figureColor == Color.BLACK && row - this.row > 0) {
                if (this.row == 1) {
                    if ((row - this.row <= 2) && (this.field.get(2).get(column) == null)) {
                        return true;
                    }
                } else if (row - this.row == 1) {
                    return true;
                }
            }
        }
        return false;
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
