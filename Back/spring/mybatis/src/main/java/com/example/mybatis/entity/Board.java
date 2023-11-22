package com.example.mybatis.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long boardId;
    private String content;
    private String title;
    private LocalDateTime createDate;
    private Integer read;
    private String name;

    private Long memberId;

    public Board(String content, String title, String name) {
        this.content = content;
        this.title = title;
        this.name = name;
    }
}
