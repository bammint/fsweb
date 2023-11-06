package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅된다
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test // 해당 메서드가 테스트를 위한 코드라는 것을 선언하는 어노테이션
    void index() {  // 성공과 실패의 경우를 한가지 테스트에서 실행
        // 예상 시나리오
        Article a = new Article(1L,"가가가가","1111");
        Article b = new Article(2L,"나나나나","2222");
        Article c = new Article(3L,"다다다다","3333");

        List<Article> expected = new ArrayList<>(Arrays.asList(a,b,c));
        // 실제 결과
        List<Article> articles = articleService.index();
        // 비교(예상 시나리오와 실제 결과가 같은지 비교한다)
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show() {
    }

    @Test
    void create() {
    }
}