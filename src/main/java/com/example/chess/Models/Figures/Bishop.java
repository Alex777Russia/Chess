package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.util.ArrayList;

public class Bishop implements Figure {

    ArrayList<ArrayList<Figure>> field;

    Color figureColor;

    ImageView fieldModel;

    int row;
    int column;

    public Bishop(ImageView fieldModel, Color color, int row, int column, ArrayList<ArrayList<Figure>> field) {
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
    public Color getColor() {
        return figureColor;
    }

    @Override
    public ImageView getFigureModel() {
        return fieldModel;
    }

    @Override
    public boolean canMakeMove(int row, int column) {
        if (Math.abs(this.row - row) != Math.abs(this.column - column)) {
            return false;
        }

        if (row > this.row && column > this.column) {
            for (int i = this.row; i < row; ++i) {
                if (field.get(i + 1).get(this.column + (i - this.row) + 1) != null) {
                    return false;
                }
            }
        }

        if (row > this.row && column < this.column) {
            for (int i = this.row; i < row; ++i) {
                if (field.get(i + 1).get(this.column - (i - this.row) - 1) != null) {
                    return false;
                }
            }
        }

        if (row < this.row && column > this.column) {
            for (int i = 0; i < column - this.column; ++i) {
                if (field.get(this.row - i - 1).get(this.column + i + 1) != null) {
                    return false;
                }
            }
        }

        if (row < this.row && column < this.column) {
            for (int i = row; i < this.row; ++i) {
                if (field.get(i).get(column - row + i) != null) {
                    return false;
                }
            }
        }





        // Дописать пересечения
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
