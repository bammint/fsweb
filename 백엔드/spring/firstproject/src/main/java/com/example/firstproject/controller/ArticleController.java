package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j // 로깅을 위한 롬복 어노테이션
public class ArticleController {
     private final ArticleRepository articleRepository;
//    @Autowired
//    public ArticleController(ArticleRepository articleRepository) {
//        this.articleRepository = articleRepository;
//    }

    // 필드 주입 , 간단함
    // 테스트 어려움
    // 결합도가 높아서 유지보수 어려움
//    @Autowired
//    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
//        System.out.println(form.toString());
        log.info(form.toString());
        // 1. dto를 Entity 변화
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info(article.toString());
        // 2. Repository에게 Entity를 DB로 저장하게 함
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(saved.toString());
        // redirect: 생성 후, 브라우저가 해당 URL로 재요청
        return "redirect:/articles/" + saved.getId();

        // get,set
//        System.out.println(form.toString());
//        Article article = new Article();
//        article.setContent(form.getContent());
//        article.setTitle(form.getTitle());
//        System.out.println(article.toString());
//        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
//
//        return "";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든 Article을 가져온다
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 뷰로 전달
        model.addAttribute("articleList",articleEntityList);
        log.info("리스트의 총갯수는?. Articles {}", articleEntityList.size());
        // 3. 뷰페이지를 설정
         return "articles/index";
    }
    @GetMapping("/articles/{id}")   // 해당 url 요청처리
    public String show(@PathVariable Long id, Model model){  // URL에서 id를 변수로 가져옴
        log.info("id = " + id);

        // 1. id로 이용해서 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article",articleEntity);
        // 보여줄 페이지를 설정
        return "articles/show";
    }
}
