package secondproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import secondproject.dto.ArticleForm;
import secondproject.entity.Article;
import secondproject.repository.ArticleRepository;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        // System.out.println(form.toString());
        log.info(form.toString());
        // 1. Dto를 Entity로 변환
        Article article = form.toEntity();
        // System.out.println(article.toString());
        log.info(article.toString());
        // 2. Repository에게 Entity를 DB로 저장하게함
        Article saved = articleRepository.save(article);
        // System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){ // url 에서 id를 변수로 가져옴
        log.info("id = " + id);
        // 1. id로 데이터를 가져옴

        // 2. 가져온 데이터를 모델에 등록
        // 3. 보여줄 페이지를 설정
        return "";
    }
}
// 11번 하는중
