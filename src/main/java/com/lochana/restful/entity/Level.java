package com.lochana.restful.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int levelNo;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private Set<Word> words;

    public Level() {
    }

    public Level(int level) {
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

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }
}
