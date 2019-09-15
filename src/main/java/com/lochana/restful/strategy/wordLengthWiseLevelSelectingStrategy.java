package com.lochana.restful.strategy;

public class wordLengthWiseLevelSelectingStrategy implements LevelSelectingStrategy {
    @Override
    public int selectLevel(String word) {
        if(word.length() < 4){
            return 0;
        }
        return word.length()-3;
    }
}
