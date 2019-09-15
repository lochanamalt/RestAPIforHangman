package com.lochana.restful.dto;

import com.lochana.restful.entity.Word;

import java.util.Set;

public class LevelDTO {
    private int id;

    private int levelNo;

    private Set<String> words;

    public LevelDTO(int id, int level) {
        this.id=id;
        setLevelNo(level);
    }
    public LevelDTO(int level) {
        setLevelNo(level);
    }

    public int getId() {
        return id;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public Set<String> getWords() {
        return words;
    }

    public void setWords(Set<String> words) {
        this.words = words;
    }
}
