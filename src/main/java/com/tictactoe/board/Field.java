package com.tictactoe.board;

import com.tictactoe.figures.Figure;

public class Field {

    private Figure figure;

    public Field() {
        figure = new Figure();
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return figure.toString();
    }
}
