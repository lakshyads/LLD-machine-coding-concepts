package ticTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int boardSize;
    private final List<List<Cell>> cells;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new ArrayList<>();
        // Initialize cells in the board
        for (int i = 0; i < boardSize; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < boardSize; j++) {
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }
    }

    public void display() {
        for (var row :
                cells) {
            for (Cell cell :
                    row) {
                cell.display();
            }
            System.out.println();
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }
}
