package com.lochana.restful.strategy;

public class LevelSelectingStrategyContext {
    private LevelSelectingStrategy strategy;

    public void setCompressionStrategy(LevelSelectingStrategy strategy) {
        this.strategy = strategy;
    }

    //use the strategy
    public int selectLevel(String word) {
        return strategy.selectLevel(word);
    }
}