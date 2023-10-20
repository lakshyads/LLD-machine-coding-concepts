package ticTacToe.models;

public class Player {
    private final int id;
    private final String name;
    private final char symbol;
    private final PlayerType type;

    public Player(int id, String name, char symbol, PlayerType type) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public Move makeMove(Cell cell) {
        cell.setPlayer(this);
        cell.setCellStatus(CellState.FILLED);
        return new Move(cell);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getType() {
        return type;
    }
}
