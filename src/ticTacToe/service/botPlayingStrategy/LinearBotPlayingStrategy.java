package ticTacToe.service.botPlayingStrategy;

import ticTacToe.exception.GameOverException;
import ticTacToe.models.*;

import java.util.List;

public class LinearBotPlayingStrategy implements IBotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player bot) throws GameOverException {
        List<List<Cell>> cells = board.getCells();
        for (var row : cells
        ) {
            for (Cell cell : row
            ) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return bot.makeMove(cell);
                }
            }
        }
        throw new GameOverException("No empty cell found.");
    }
}
