package ticTacToe.controller;

import org.jetbrains.annotations.NotNull;
import ticTacToe.exception.*;
import ticTacToe.models.*;
import ticTacToe.service.botPlayingStrategy.BotPlayingStrategies;
import ticTacToe.service.botPlayingStrategy.BotPlayingStrategyFactory;
import ticTacToe.service.winningStrategy.WinningStrategies;
import ticTacToe.service.winningStrategy.WinningStrategyFactory;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private Game getNewGame(int dimension, List<Player> players, WinningStrategies winningStrategy, BotPlayingStrategies botPlayingStrategy) {
        try {
            return Game.builder()
                    .size(3)
                    .players(players)
                    .winningStrategy(WinningStrategyFactory.getWinningStrategy(winningStrategy, dimension))
                    .botPlayingStrategy(BotPlayingStrategyFactory.getBotPlayingStrategy(botPlayingStrategy))
                    .build();
        } catch (InvalidBotCountException | InvalidBoardSizeException | InvalidPlayerCountException |
                 DuplicatePlayerSymbolException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Could not start the game, something went wrong:");
            e.printStackTrace();
        }
        return null;
    }

    public Game CreateGame(int dimension, List<Player> players, WinningStrategies winningStrategy) {
        return getNewGame(dimension, players, winningStrategy, null);
    }

    public Game CreateGame(int dimension, List<Player> players, WinningStrategies winningStrategy, BotPlayingStrategies botPlayingStrategy) {
        return getNewGame(dimension, players, winningStrategy, botPlayingStrategy);
    }

    public void displayGame(@NotNull Game game) {
        game.getBoard().display();
    }

    public GameState getGameState(@NotNull Game game) {
        return game.getGameState();
    }

    public Player getGameWinner(@NotNull Game game) {
        return game.getWinner();
    }

    private Move executePlayerMove(Game game, Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.print(player.getName() + ": Enter the row for your move: ");
        int row = sc.nextInt();
        System.out.print(player.getName() + ": Enter the col for your move: ");
        int col = sc.nextInt();
        if (row < 0 || col < 0 || row >= game.getBoard().getBoardSize() || col >= game.getBoard().getBoardSize()) {
            System.out.println("Invalid cell. Try again.");
            return executePlayerMove(game, player);
        }
        Cell cell = game.getBoard().getCells().get(row).get(col);
        if (cell.getCellState() == CellState.FILLED) {
            System.out.println("Cell is not empty. Try again.");
            return executePlayerMove(game, player);
        }
        return player.makeMove(cell);
    }

    public Move makeMove(Game game, Player player) throws GameOverException {
        Move move = null;
        if (player.getType().equals(PlayerType.HUMAN)) {
            move = executePlayerMove(game, player);
        } else {
            move = game.getBotPlayingStrategy().makeMove(game.getBoard(), player);
        }
        // Update moves in the game
        game.getMoves().add(move);
        // Update board states`
        game.getBoardStates().add(new Board(game.getBoard()));
        return move;
    }

    public Player checkWinner(Game game, Move lastPlayedMove) {
        Player player = game.getWinningStrategy().checkWinner(lastPlayedMove);
        if (player != null) {
            game.setGameState(GameState.COMPLETED);
            game.setWinner(player);
        }
        return player;
    }
}
