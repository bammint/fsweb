package com.example.firstproject.service;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
//@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;


    public List<Article> index(){
        return  articleRepository.findAll();
    }

//단건조회
    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }


    public Article create(ArticleForm dto) {
       Article article = dto.toEntity();
       if(article.getId() != null){
           return null;
       } //기존데이터 수정 방지
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        //1. dto -> entity
      Article article = dto.toEntity();
       log.info("id: {}, article: {}", id, article.toString());
      //2. 타겟을 조회
     Article target  = articleRepository.findById(id).orElse(null);
     //3. 잘못된 요청처리
     if(target == null || id != article.getId()){
         //400 , 잘못된 요청 응답
         log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
        return null;
     }
     //4. 업데이트
     // article 폼에서 작성한 데이터(수정)
     // target 원본데이터(DB에서 꺼내온 데이터)
     target.patch(article);
     Article updated = articleRepository.save(target);
     return updated;
    }



    public Article delete(Long id) {
        //대상찾기
        Article target  = articleRepository.findById(id).orElse(null);
        //잘못된 요청 처리
        if(target == null){
            return null;
        }
        //데이터 삭제 및 반환
        articleRepository.delete(target);
        return  target;
    }



    public List<Article> createArticle(List<ArticleForm> dtos) {
//       List<Article> articleList = new ArrayList<>();
//       for(int i = 0; i < dtos.size(); i++){
//          ArticleForm dto = dtos.get(i);
//          Article entity =  dto.toEntity();
//          articleList.add(entity);
//       }
        List<Article> articleList = dtos.stream()
                .map(dto ->dto.toEntity())
                .collect(Collectors.toList());
        //1. dtos 리스트에서  스트림생성 - 스트림을 사용하여 데이터를 순회하고 변환
        //2. .map(dto ->dto.toEntity())
        // map 연산을 사용하여 dto.toEntity()를 호출하여
        //ArticleForm 객체를 Article 엔티티로 변환 -> Article 객체를 생성
         // 3.articleList에 변환된 Article 객체를 담아서 최종 결과를 생성
       //for(int i = 0; i < articleList.size();i++){
       //   Article article = articleList.get(i);
       //   articleRepository.save(article);
     //  }
       articleList.stream()
               .forEach(article -> articleRepository.save(article));
       //1.    articleList.stream() 스트림은로 생성
        //2. articleList 에서 article을 꺼내와서 articleRepository 저장

       //강제예외를 발생
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결재실패 !!")
        );
       return articleList;
    }

}
