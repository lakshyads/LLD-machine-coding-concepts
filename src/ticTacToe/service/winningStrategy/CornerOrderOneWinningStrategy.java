package ticTacToe.service.winningStrategy;

import ticTacToe.models.Move;
import ticTacToe.models.Player;

import java.util.HashMap;

public class CornerOrderOneWinningStrategy extends OrderOneWinningStrategy {
    private final HashMap<Character, Integer> cornerMap;

    public CornerOrderOneWinningStrategy(int dimension) {
        super(dimension);
        this.cornerMap = new HashMap<>();
    }

    protected boolean isCornerMove(int row, int col) {
        if (row == 0 || row == dimension - 1)
            return col == 0 || col == dimension - 1;
        return false;
    }

    protected boolean checkCornerWin(char symbol) {
        int count = cornerMap.getOrDefault(symbol, 0) + 1;
        cornerMap.put(symbol, count);
        return count == dimension;
    }

    @Override
    public Player checkWinner(Move lastMove) {

        if (
                isCornerMove(lastMove.cell().getRow(), lastMove.cell().getCol())
                        && checkCornerWin(lastMove.cell().getPlayer().getSymbol())
        )
            return lastMove.cell().getPlayer();
        return super.checkWinner(lastMove);
    }
}
