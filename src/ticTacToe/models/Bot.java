package ticTacToe.models;

public class Bot extends Player {
    BotDifficultyLevel difficultyLevel;

    public Bot(int id, String name, char symbol, PlayerType type, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol, type);
        this.difficultyLevel = difficultyLevel;
    }
}
