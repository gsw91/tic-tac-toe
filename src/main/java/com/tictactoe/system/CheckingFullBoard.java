package com.tictactoe.system;

import com.tictactoe.board.Board;

public class CheckingFullBoard {

    protected int checkBoard(Board board) {
        int freeFields = 0;
        for(int row=0; row<3; row++) {
            for(int column=0; column<3; column++) {
                if (board.getRows().get(row).getRow().get(column).getFigure().toString().equals(" ")) {
                    freeFields++;
                }
            }
        }
        if (freeFields == 0) {
            System.out.println("Game over");
            return freeFields;
        }
        return freeFields;
    }

}
