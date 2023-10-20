package ticTacToe;

import ticTacToe.controller.GameController;
import ticTacToe.exception.GameOverException;
import ticTacToe.models.*;
import ticTacToe.service.botPlayingStrategy.BotPlayingStrategies;
import ticTacToe.service.winningStrategy.WinningStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController controller = new GameController();
        List<Player> players = new ArrayList<>();

        // initialize game size
        System.out.print("Enter game board dimension: ");
        int size = sc.nextInt();
        System.out.println();
        // initialize bot
        System.out.print("Do you want a bot player (Y/N): ");
        boolean isBotPresent = sc.next().equalsIgnoreCase("Y");
        if (isBotPresent) {
            System.out.print("Enter bot name: ");
            String name = sc.next();
            System.out.println();
            System.out.print("Enter bot symbol: ");
            String symbol = sc.next();
            System.out.println();
//            System.out.print("Enter bot difficulty: ");
//            String symbol = sc.next();
//            System.out.println();
            players.add(new Bot(0, name, symbol.charAt(0), PlayerType.BOT, BotDifficultyLevel.EASY));
        }
        System.out.println();
        // initialize players
        int playerCount = isBotPresent ? 1 : 0;
        while (playerCount < size - 1) {
            System.out.print("Enter player " + playerCount + " name: ");
            String name = sc.next();
            System.out.println();
            System.out.print("Enter player " + playerCount + " symbol: ");
            String symbol = sc.next();
            System.out.println();
            players.add(new Player(0, name, symbol.charAt(0), PlayerType.HUMAN));
            playerCount++;
        }
        // initialize winning strategy
        // TODO
        // initialize bot playing strategy
        // TODO
        Collections.shuffle(players);
        Game game = controller.CreateGame(size, players, WinningStrategies.ORDER_ONE_WINNING_STRATEGY, BotPlayingStrategies.LINEAR_BOT_PLAYING_STRATEGY);
        int playerIndex = 0;
        controller.displayGame(game);
        int i = 0;
        while (game.getMoves().size() < size * size) {
            Player player = players.get(i);
            System.out.println(player.getName() + " turn: ");
            try {
                Move move = controller.makeMove(game, player);
                controller.displayGame(game);
                Player winner = controller.checkWinner(game, move);
                if (winner != null) {
                    System.out.println(winner.getName() + " won the game!");
                    break;
                }
                i++;
                i = i % (size - 1);
            } catch (GameOverException e) {
                break;
            }
        }
        if (game.getMoves().size() == size * size)
            System.out.println("Game is a draw!");

    }
}
