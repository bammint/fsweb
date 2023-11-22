package com.example.mybatis.mapper;

import com.example.mybatis.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    int boardCount();
    List<Board> findAll();
}
