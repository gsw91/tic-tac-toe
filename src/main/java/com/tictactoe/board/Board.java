package com.tictactoe.board;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Row> rows;

    public Board() {
        Row row;
        rows = new ArrayList<>();
        for(int i=0; i<3; i++) {
            row = new Row();
            rows.add(row);
        }
    }

    public List<Row> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return rows.get(0) + " \n" + rows.get(1) + " \n" + rows.get(2) + " \n";
    }

}
