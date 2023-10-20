package ticTacToe.service.botPlayingStrategy;

import java.util.Objects;

public class BotPlayingStrategyFactory {
    public static IBotPlayingStrategy getBotPlayingStrategy(BotPlayingStrategies strategy) {
        // TODO - convert to switch case when the number of strategies grow
        if (Objects.requireNonNull(strategy) == BotPlayingStrategies.LINEAR_BOT_PLAYING_STRATEGY) {
            return new LinearBotPlayingStrategy();
        }
        return null;
    }
}
