package ticTacToe.models;

import ticTacToe.exception.DuplicatePlayerSymbolException;
import ticTacToe.exception.InvalidBoardSizeException;
import ticTacToe.exception.InvalidBotCountException;
import ticTacToe.exception.InvalidPlayerCountException;
import ticTacToe.service.botPlayingStrategy.IBotPlayingStrategy;
import ticTacToe.service.winningStrategy.IWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final List<Move> moves;
    private final List<Board> boardStates;
    private final IWinningStrategy winningStrategy;
    private GameState gameState;
    private Player currentPlayer;
    private Player winner;

    private IBotPlayingStrategy botPlayingStrategy;

    private Game(Board board, List<Player> players, IWinningStrategy winningStrategy) {
        this.board = board;
        this.players = players;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
    }

    private Game(Board board, List<Player> players, IWinningStrategy winningStrategy, IBotPlayingStrategy botPlayingStrategy) {
        this(board, players, winningStrategy);
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public IWinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public IBotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public static class Builder {
        private int boardSize;
        private List<Player> players;
        private IWinningStrategy winningStrategy;

        private IBotPlayingStrategy botPlayingStrategy;

        public Builder size(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder winningStrategy(IWinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder botPlayingStrategy(IBotPlayingStrategy botPlayingStrategy) {
            this.botPlayingStrategy = botPlayingStrategy;
            return this;
        }

        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for (Player player : players) {
                if (player.getType().equals(PlayerType.BOT)) botCount++;
            }
            if (botCount > 1)
                throw new InvalidBotCountException("Bot count cannot be more than 1, currently: " + botCount);
        }

        private void validatePlayerCount() throws InvalidPlayerCountException {
            if (players.size() != boardSize - 1)
                throw new InvalidPlayerCountException("Number of players should be boardSize - 1, currently: " + players.size());
        }

        private void validateBoardSize() throws InvalidBoardSizeException {
            if (boardSize < 3 || boardSize > 10)
                throw new InvalidBoardSizeException("Board size should be >= 3 and <= 10, currently: " + boardSize);
        }

        private void validateDuplicatePlayerSymbols() throws DuplicatePlayerSymbolException {
            HashSet<Character> symbolSet = new HashSet<>();
            for (Player player : players) {
                symbolSet.add(player.getSymbol());
            }
            if (symbolSet.size() != players.size())
                throw new DuplicatePlayerSymbolException("Each player should have unique symbol");
        }

        private void validateGame() throws InvalidBoardSizeException, InvalidPlayerCountException, InvalidBotCountException, DuplicatePlayerSymbolException {
            validateBoardSize();
            validatePlayerCount();
            validateBotCount();
            validateDuplicatePlayerSymbols();
        }

        public Game build() throws InvalidBotCountException, InvalidPlayerCountException, InvalidBoardSizeException, DuplicatePlayerSymbolException {
            validateGame();
            return new Game(new Board(boardSize), players, winningStrategy, botPlayingStrategy);
        }

    }
}
