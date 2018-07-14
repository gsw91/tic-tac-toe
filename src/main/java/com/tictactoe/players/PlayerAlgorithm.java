package com.tictactoe.players;

import com.tictactoe.board.Board;
import com.tictactoe.figures.Figure;

import java.util.Scanner;

public class PlayerAlgorithm {

    public void insertFigure(Board board, Figure figure) {
        int row = chooseRow();
        int column = chooseColumn();
        setFigureIntoBoard(board, row, column, figure);
        System.out.println(board);
    }

    private void setFigureIntoBoard (Board board, int row, int column, Figure figure) {
        if (board.getRows().get(row).getRow().get(column).getFigure().toString().equals(" ")) {
            board.getRows().get(row).getRow().get(column).setFigure(figure);
        } else {
            System.out.println("This field is occupied, try one more time");
            System.out.println(board);
            insertFigure(board, figure);
        }
    }

    private int chooseColumn() {
        System.out.println("Choose column from 1 to 3");
        String column;
        int columnToInsert;
        String[] options = new String[3];
        options[0] = "1";
        options[1] = "2";
        options[2] = "3";
        column = insertOptionWithRestrictions(options);
        columnToInsert = Integer.parseInt(column) - 1;
        return columnToInsert;
    }

    private int chooseRow () {
        System.out.println("Choose row from 1 to 3");
        String row;
        int rowToInsert;
        String[] options = new String[3];
        options[0] = "1";
        options[1] = "2";
        options[2] = "3";
        row = insertOptionWithRestrictions(options);
        rowToInsert = Integer.parseInt(row) - 1;
        return rowToInsert;
    }

    public String insertOptionWithRestrictions (String[] restrictions) {
        boolean condition = false;
        String command = null;
        while (!condition) {
            command = insertOption();
            for(String restriction: restrictions) {
                if (command.equals(restriction)) {
                    condition=true;
                }
            }
            if (!condition) {
                System.out.println(insertCorrectKey());
            }
        }
        return command;
    }

    private String insertOption() {
        String option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.next();
        return option;
    }

    private String insertCorrectKey() {
        return "Insert correct key";
    }

}
