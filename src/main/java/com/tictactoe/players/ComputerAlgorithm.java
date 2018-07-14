package com.tictactoe.players;

import com.tictactoe.board.Board;
import com.tictactoe.figures.Figure;

import java.util.Random;

public class ComputerAlgorithm {

    public void setFigureIntoBoard (Board board, Figure figure) {
        Random random = new Random();
        boolean condition = false;
        while (!condition) {
            int column = random.nextInt(3);
            int row = random.nextInt(3);
            if (board.getRows().get(row).getRow().get(column).getFigure().toString().equals(" ")) {
                board.getRows().get(row).getRow().get(column).setFigure(figure);
                System.out.println(board);
                condition = true;
            }
        }
    }

}
