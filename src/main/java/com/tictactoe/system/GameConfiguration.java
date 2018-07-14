package com.tictactoe.system;

import com.tictactoe.board.Board;
import com.tictactoe.figures.Figure;
import com.tictactoe.players.ComputerAlgorithm;
import com.tictactoe.players.PlayerAlgorithm;

import java.util.Scanner;

public class GameConfiguration {

    private Scanner scanner = new Scanner(System.in);

    public void play () {
        System.out.println("Welcome in tic-tac-toe");
        Board board = new Board();
        confirmDecision(board);
    }

    private void confirmDecision (Board board) {
        Figure playerFigure;
        Figure computerFigure = null;
        String decision;
        PlayerAlgorithm playerAlgorithm = new PlayerAlgorithm();
        ComputerAlgorithm computerAlgorithm = new ComputerAlgorithm();
        CheckingFullBoard checkingFullBoard = new CheckingFullBoard();
        FigureSelection figureSelection;
        boolean condition = false;

        while (!condition) {

            int emptyFields = checkingFullBoard.checkBoard(board);
            figureSelection = FigureSelection.getInstance();
            if(emptyFields == 0) {
                board = endGame();
            }
            System.out.println("Main Menu \n" +
                    "Press: \n" +
                    "   p to play \n" +
                    "   x to quit \n");
            decision = scanner.next();

            switch (decision) {
                case "p":
                    int maxQtyRounds = 9;
                    boolean begin = false;
                    while (!begin) {
                        System.out.println("Who starts ? 1 - player, 2 - computer");
                        String whoStart = scanner.next();
                        switch (whoStart) {
                            case "1":
                                while(maxQtyRounds>0) {
                                    playerFigure = figureSelection.chooseHumanFigure(computerFigure);
                                    playerAlgorithm.insertFigure(board, playerFigure);
                                    maxQtyRounds--;
                                    if (maxQtyRounds == 0) {
                                        begin=true;
                                        break;
                                    }
                                    computerFigure = figureSelection.chooseComputerFigure();
                                    computerAlgorithm.setFigureIntoBoard(board, computerFigure);
                                    maxQtyRounds--;
                                }
                                break;
                            case "2":
                                while(maxQtyRounds>0) {
                                    computerFigure = figureSelection.chooseComputerFigure();
                                    computerAlgorithm.setFigureIntoBoard(board, computerFigure);
                                    maxQtyRounds--;
                                    if (maxQtyRounds == 0) {
                                        begin = true;
                                        break;
                                    }
                                    playerFigure = figureSelection.chooseHumanFigure(computerFigure);
                                    playerAlgorithm.insertFigure(board, playerFigure);
                                    maxQtyRounds--;
                                }
                                break;
                            default:
                                System.out.println("Insert correct option");
                        }
                    }
                    break;
                case "x":
                    condition = confirmExit();
                    break;
                default:
                    System.out.println("Insert correct option");
            }
        }
    }

    private Board endGame() {
        System.out.println("The game is over: \n" +
                "   press r to go main menu \n" +
                "   press x to exit");
        boolean shallWeFinish = false;
        while (!shallWeFinish) {
            String decision = scanner.next();
            switch (decision) {
                case "r":
                    return new Board();
                case "x":
                    confirmExit();
                    shallWeFinish = true;
                    break;
                default:
                    System.out.println("Insert correct option:  r / x");
            }
        }
        return new Board();
    }

    private boolean confirmExit() {
        String command;
        boolean condition = false;

        while (!condition) {
            System.out.println("Do you want to quit? yes/no");
            command = scanner.next();
            switch (command) {
                case "yes":
                    System.exit(0);
                    break;
                case "no":
                    condition = true;
                    break;
                default:
                    System.out.println("Insert correct option");
            }
        }
        return false;
    }

}
