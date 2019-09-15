package com.lochana.restful;

import com.lochana.restful.dto.LevelDTO;
import com.lochana.restful.entity.Level;
import com.lochana.restful.entity.Word;
import com.lochana.restful.repository.LevelRepository;
import com.lochana.restful.service.FileStorageService;
import com.lochana.restful.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class RestfulController {

    private static final Logger logger = LoggerFactory.getLogger(RestfulController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private GameService gameService;


    @RequestMapping("/game")
    public String index() {
        return "Welcome to Hangman..!";
    }

    @PostMapping("/upload")
    public boolean uploadFile(@RequestParam("file") MultipartFile file) {
        return fileStorageService.storeFile(file);
    }

    @GetMapping("/nextLevel/{level}")
    public LevelDTO getNextLevel(@PathVariable String level){
        return gameService.getNextLevelAndWordList(Integer.parseInt(level));
    }

}
