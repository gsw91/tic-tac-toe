package com.tictactoe.system;

import com.tictactoe.figures.Circle;
import com.tictactoe.figures.Cross;
import com.tictactoe.figures.Figure;
import com.tictactoe.players.PlayerAlgorithm;

public class FigureSelection {

    private Figure figure;
    private static FigureSelection figureSelection = null;

    protected static FigureSelection getInstance() {
        if (figureSelection == null) {
            figureSelection = new FigureSelection();
        }
        return figureSelection;
    }

    private FigureSelection() {
    }

    protected Figure chooseHumanFigure(Figure computerFigure) {
        Figure playerFigure = null;
        if(computerFigure == null) {
            figureSelection.chooseHumanFigure();
            playerFigure = figureSelection.getFigure();
        } else if (computerFigure.toString().equals("X")) {
            playerFigure = new Circle();
        } else if (computerFigure.toString().equals("O")) {
            playerFigure = new Cross();
        }
        return playerFigure;
    }

    protected Figure chooseComputerFigure() {
        Figure playerFigure;
        Figure computerFigure;
        figureSelection = FigureSelection.getInstance();

        if (figureSelection.getFigure() != null) {
            playerFigure = figureSelection.getFigure();
        } else {
            playerFigure = new Cross();
        }
        computerFigure = new Figure();

        if (playerFigure.toString().equals("X")) {
            computerFigure = new Circle();
        } else if (playerFigure.toString().equals("O")) {
            computerFigure = new Cross();

        }
        return computerFigure;
    }

    private void chooseHumanFigure() {
        FigureSelection figureToInsert = FigureSelection.getInstance();
        System.out.println("Choose your figure in game o / x");
        String[] options = new String[2];
        options[0] = "o";
        options[1] = "x";
        PlayerAlgorithm playerAlgorithm = new PlayerAlgorithm();
        String figure = playerAlgorithm.insertOptionWithRestrictions(options);

        switch (figure) {
            case "o":
                figureToInsert.setFigure(new Circle());
            case "x":
                figureToInsert.setFigure(new Cross());
            default:
                System.out.println("Insert correct figure");
        }
    }

    private Figure getFigure() {
        return figure;
    }

    private void setFigure(Figure figure) {
        this.figure = figure;
    }

}
