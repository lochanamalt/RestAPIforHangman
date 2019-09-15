package com.lochana.restful.service;

import com.lochana.restful.dto.LevelDTO;
import com.lochana.restful.entity.Level;
import com.lochana.restful.entity.Word;
import com.lochana.restful.repository.LevelRepository;
import com.lochana.restful.repository.WordRepository;
import com.lochana.restful.strategy.LevelSelectingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class GameService {
    @Autowired
    LevelRepository levelrepo;

    @Autowired
    WordRepository worddrepo;

    LevelSelectingStrategy levelSelectingStrategy;

    public LevelDTO getNextLevelAndWordList(int level) {
        List<Level> nextLevel = levelrepo.findLevelByLevelNoAfterOrderByLevelNoAsc(level);
        if(nextLevel.isEmpty()){
            return null;
        }
        Set<Word> wordSet = nextLevel.get(0).getWords();
        List<Word> wordList = new ArrayList<>(wordSet);
        Set<String> stringWordSet = new HashSet<>();

        for (Word word:wordList) {
            stringWordSet.add(word.getWord());
        }
        LevelDTO levelDTO = new LevelDTO(nextLevel.get(0).getId(),nextLevel.get(0).getLevelNo());
        levelDTO.setWords(stringWordSet);
        return levelDTO;
    }

}
