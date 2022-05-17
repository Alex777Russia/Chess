package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;

public class King implements Figure {

    Color figureColor;

    int row;
    int column;

    public King(Color color, int row, int column) {
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
