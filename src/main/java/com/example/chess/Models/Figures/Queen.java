package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.util.ArrayList;

public class Queen implements Figure {

    ArrayList<ArrayList<Figure>> field;

    Color figureColor;

    ImageView fieldModel;

    int row;
    int column;

    public Queen(ImageView fieldModel, Color color, int row, int column, ArrayList<ArrayList<Figure>> field) {
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

        if (this.row == row) {
            for (int i = Math.min(this.column, column); i <= Math.max(this.column, column); ++i) {
                if (field.get(row).get(i) != this && field.get(row).get(i) != null) {
                    return false;
                }
            }
            return true;
        } else if (this.column == column) {
            for (int i = Math.min(this.row, row); i <= Math.max(this.row, row); ++i) {
                if (field.get(i).get(column) != this && field.get(i).get(column) != null) {
                    return false;
                }
            }
            return true;
        } else if (Math.abs(this.column - column) == Math.abs(this.row - row)) {
            if (row > this.row && column > this.column) {
                for (int i = this.row; i < row; ++i) {
                    if (field.get(i + 1).get(this.column + (i - this.row) + 1) != null) {
                        return false;
                    }
                }
                return true;
            }

            if (row > this.row && column < this.column) {
                for (int i = this.row; i < row; ++i) {
                    if (field.get(i + 1).get(this.column - (i - this.row) - 1) != null) {
                        return false;
                    }
                }
                return true;
            }

            if (row < this.row && column > this.column) {
                for (int i = 0; i < column - this.column; ++i) {
                    if (field.get(this.row - i - 1).get(this.column + i + 1) != null) {
                        return false;
                    }
                }
                return true;
            }

            if (row < this.row && column < this.column) {
                for (int i = row; i < this.row; ++i) {
                    if (field.get(i).get(column - row + i) != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void makeMove(int row, int column) {
        this.row = row;
        this.column = column;
    }

}
