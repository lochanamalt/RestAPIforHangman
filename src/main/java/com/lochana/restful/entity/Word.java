package com.lochana.restful.entity;

import javax.persistence.*;

@Entity
@Table(name="word_list")
public class Word {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column
    private String word;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    public Word() {
    }
    public Word(String word) {
        this.setWord(word);
    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
