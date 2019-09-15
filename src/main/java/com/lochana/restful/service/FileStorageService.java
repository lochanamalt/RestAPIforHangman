package com.lochana.restful.service;

import com.lochana.restful.entity.Level;
import com.lochana.restful.entity.Word;
import com.lochana.restful.repository.LevelRepository;
import com.lochana.restful.repository.WordRepository;
import com.lochana.restful.strategy.LevelSelectingStrategy;
import com.lochana.restful.strategy.LevelSelectingStrategyContext;
import com.lochana.restful.strategy.wordLengthWiseLevelSelectingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {

    @Autowired
    WordRepository wordrepo;

    @Autowired
    LevelRepository levelrepo;


    public boolean storeFile(MultipartFile file) {
        byte[] bytes = new byte[0];
        boolean flag =false;
        if (!file.isEmpty()) {
            try {
                bytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String word_list = new String(bytes);

        String[] words = word_list.split("\n");

        int level =0;

        LevelSelectingStrategyContext levelSelectingStrategyContext = new LevelSelectingStrategyContext();
        levelSelectingStrategyContext.setCompressionStrategy(new wordLengthWiseLevelSelectingStrategy());

        for(int i=0;i< words.length;i++){
            String word= words[i].trim();
            level = levelSelectingStrategyContext.selectLevel(word);

            Word new_word = new Word(word);
            Level lvl = levelrepo.findByLevelNo(level);
            if(lvl==null){
                Level new_level= new Level(level);
                Level savedLevel = levelrepo.save(new_level);
                new_word.setLevel(savedLevel);
            }else{
                new_word.setLevel(lvl);
            }

            wordrepo.save(new_word);

            if(i==words.length-1) flag=true;
        }

        return flag;
    }
}
