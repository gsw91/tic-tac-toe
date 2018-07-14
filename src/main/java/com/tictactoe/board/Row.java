package com.tictactoe.board;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<Field> row;

    protected Row() {
        Field field;
        row = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            field = new Field();
            row.add(field);
        }
    }

    public List<Field> getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "|_" + row.get(0) + "_|_" + row.get(1) + "_|_" + row.get(2) +"_|";
    }

}
