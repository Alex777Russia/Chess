package com.example.chess.Models.Figures;

import com.example.chess.Models.Figure;

public class Rook implements Figure {

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
