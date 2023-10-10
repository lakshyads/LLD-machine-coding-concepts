package ticTacToe.models;

import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    Player currentPlayer;
    List<Move> moves;
    List<Board> boardStates;
    Player winner;
    GameStatus status;
//    WinningStrategy wins;
}
