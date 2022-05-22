package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.util.ArrayList;

public class Rook implements Figure {

    ArrayList<ArrayList<Figure>> field;

    Color figureColor;

    ImageView fieldModel;

    int row;
    int column;

    public Rook(ImageView fieldModel, Color color, int row, int column, ArrayList<ArrayList<Figure>> field) {
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

        if (this.row != row && this.column != column) {
            return false;
        }

        if (this.row == row) {
            if (this.column > column) {
                for (int i = column + 1; i < this.column; ++i) {
                    if (field.get(row).get(i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.column + 1; i < column; ++i) {
                    if (field.get(row).get(i) != null) {
                        return false;
                    }
                }
            }
        } else {
            if (this.row > row) {
                for (int i = row; i < this.row; ++i) {
                    if (field.get(i).get(column) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.row + 1; i < row; ++i) {
                    if (field.get(i).get(column) != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void makeMove(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
