package ticTacToe.service.winningStrategy;

import ticTacToe.models.Cell;
import ticTacToe.models.Move;
import ticTacToe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements IWinningStrategy {
    protected final int dimension;
    private final List<HashMap<Character, Integer>> rowMaps;
    private final List<HashMap<Character, Integer>> colMaps;
    private final HashMap<Character, Integer> topLeftMap;
    private final HashMap<Character, Integer> topRightMap;

    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        // row & col maps
        rowMaps = new ArrayList<>();
        colMaps = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            rowMaps.add(new HashMap<>());
            colMaps.add(new HashMap<>());
        }
        // top left diagonal map
        topLeftMap = new HashMap<>();
        // top right diagonal map
        topRightMap = new HashMap<>();
    }

    protected boolean isTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    protected boolean isTopRightDiagonal(int row, int col) {
        return row + col == dimension - 1;
    }

    @Override
    public Player checkWinner(Move lastMove) {
        Cell cell = lastMove.cell();
        int row = cell.getRow();
        int col = cell.getCol();
        Player player = cell.getPlayer();
        char symbol = player.getSymbol();
        if (checkRowWin(row, symbol)) return player;
        if (checkColWin(col, symbol)) return player;
        if (isTopLeftDiagonal(row, col) && checkTopLeftDiagonalWin(symbol)) return player;
        if (isTopRightDiagonal(row, col) && checkTopRightDiagonalWin(symbol)) return player;
        return null;
    }

    protected boolean checkRowWin(int row, char symbol) {
        HashMap<Character, Integer> rowMap = rowMaps.get(row);
        int count = rowMap.getOrDefault(symbol, 0) + 1;
        rowMap.put(symbol, count);
        return count == dimension;
    }

    protected boolean checkColWin(int col, char symbol) {
        HashMap<Character, Integer> colMap = colMaps.get(col);
        int count = colMap.getOrDefault(symbol, 0) + 1;
        colMap.put(symbol, count);
        return count == dimension;
    }

    protected boolean checkTopLeftDiagonalWin(char symbol) {
        int count = topLeftMap.getOrDefault(symbol, 0) + 1;
        topLeftMap.put(symbol, count);
        return count == dimension;
    }

    protected boolean checkTopRightDiagonalWin(char symbol) {
        int count = topRightMap.getOrDefault(symbol, 0) + 1;
        topRightMap.put(symbol, count);
        return count == dimension;
    }
}
