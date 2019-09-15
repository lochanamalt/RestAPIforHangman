package com.lochana.restful.repository;

import com.lochana.restful.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level, Integer> {
    Level findByLevelNo(int length);
    List<Level> findLevelByLevelNoAfterOrderByLevelNoAsc(int level);
}
