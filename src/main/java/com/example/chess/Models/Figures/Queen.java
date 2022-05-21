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
        if (this.row == row && this.column != column) {
            if (this.column - column > 0) {
                for (int i = column + 1; i < this.column; ++i) {
                    if (this.field.get(row).get(i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.column + 1; i < column; ++i) {
                    if (this.field.get(row).get(i) != null) {
                        return false;
                    }
                }
            }
            return true;
        } else if (this.column == column && this.row != row) {
            if (this.row - row > 0) {
                for (int i = row; i < this.row; ++i) {
                    if (this.field.get(i).get(row) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.row; i < row; ++i) {
                    if (this.field.get(i).get(row) != null) {
                        return false;
                    }
                }
            }
            return true;
        } else if (this.row - row == this.column - column && this.row - row > 0) {
           for (int i = 0; i < this.row - row - 1; ++i) {
               if (this.field.get(row + i).get(column + i) != null) {
                   return false;
               }
           }
           return true;
        } else if (this.row - row == this.column - column && this.row - row < 0) {
            for (int i = 0; i < row - this.row - 1; ++i) {
                if (this.field.get(this.row + i).get(this.column + i) != null) {
                    return false;
                }
            }
            return true;
        } else if (this.row - row == column - this.column && this.row - row > 0) {
            for (int i = 0; i < this.row - row - 1; ++i) {
                if (this.field.get(row + i).get(this.column + i) != null) {
                    return false;
                }
            }
            return true;
        } else if (this.row - row == column - this.column && this.row - row < 0) {
            for (int i = 0; i < row - this.row - 1; ++i) {
                if (this.field.get(this.row + i).get(column + i) != null) {
                    return false;
                }
            }
            return true;
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
