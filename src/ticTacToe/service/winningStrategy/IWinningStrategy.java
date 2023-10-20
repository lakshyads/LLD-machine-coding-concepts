package ticTacToe.service.winningStrategy;

import ticTacToe.models.Move;
import ticTacToe.models.Player;

public interface IWinningStrategy {
    Player checkWinner(Move lastMove);
}
