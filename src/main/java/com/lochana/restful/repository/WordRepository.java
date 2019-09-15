package com.lochana.restful.repository;

import com.lochana.restful.entity.Level;
import com.lochana.restful.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findWordsByLevel(Level level);

}
