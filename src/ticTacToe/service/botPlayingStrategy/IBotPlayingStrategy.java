package ticTacToe.service.botPlayingStrategy;

import ticTacToe.exception.GameOverException;
import ticTacToe.models.Board;
import ticTacToe.models.Move;
import ticTacToe.models.Player;

public interface IBotPlayingStrategy {
    Move makeMove(Board board, Player bot) throws GameOverException;
}
