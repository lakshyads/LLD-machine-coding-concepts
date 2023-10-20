package ticTacToe.service.winningStrategy;

public class WinningStrategyFactory {
    public static IWinningStrategy getWinningStrategy(WinningStrategies strategy, int dimension) {
        switch (strategy) {
            case CORNER_O1_WINNING_STRATEGY -> {
                return new CornerOrderOneWinningStrategy(dimension);
            }
            default -> {
                return new OrderOneWinningStrategy(dimension);
            }
        }
    }
}
