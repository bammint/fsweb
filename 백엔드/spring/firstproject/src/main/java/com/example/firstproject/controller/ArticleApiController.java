package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArticleApiController {
    //    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

//    @Autowired
//    public ArticleApiController(ArticleService articleService) {
//        this.articleService = articleService;
//    } => @equiredArgsConstructor 가 대체
    // @Autowired
    // private ArticleService articleService; => 필드 주입 방식



    // Get
    // 게시글 페이지(메인 페이지)
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    // 게시글 상세 페이지(단건 조회)
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    // post(게시글 추가)
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // @RequestBody -> Json 데이터 받기

    // Patch(update- 게시글 수정)
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,@RequestBody ArticleForm dto){
        // 수정할 id -> id
        // form에서 수정한 데이터
        Article updated = articleService.update(id,dto);
        return (updated != null)?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // ResponseEntity<Article>
    // Article을 담아서 ResponseEntity로 리턴 값을 보내야 한다
    // 응답 코드를 반환 할 수 있다
    // ResponseEntity에 Article이 담겨서 Json으로 반환
    // 상태코드 200 json에 내용이 같이 반환

    // delete
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // ResponseEntity.status(HttpStatus.NO_CONTENT) - 204 no_content
    // 요청이 성공적으로 처리 되었음을 알린다 또한 응답 본문에는 데이터가 반환되지 않는다

    // 트렌젝션 -> 예외 발생 -> 롤백
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        // Article을 리스트(묶음 단위 전송), ResponseEntity로 감싸서 받음
        List<Article> createList = articleService.createArticle(dtos);

        return (createList != null)?
                ResponseEntity.status(HttpStatus.OK).body(createList):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
//controller -> repository
//        controller -> service -> repository
//        전에는
//        controller 에서 repository (di)를 해주었음
//        controller 에서 service (di)를 해주고
//        service에서는 repository가 필요하므로 (di)
//        controller
//        controller => view(뷰)와 연결
//
//        RestController
//        Json(데이터)을 반환하는 RestAPI Controller이다
//        RestController
//        get,post(생성),patch(update),delete

//ResponseEntity란, HttpEntity를 상속받는, 결과 데이터와 HTTP 상태 코드를 직접 제어할 수 있는 클래스이다.
//
//        ResponseEntity에는 사용자의 HttpRequest에 대한 응답 데이터가 포함된다.
//
//        에러 코드와 같은 HTTP상태 코드를 전송하고 싶은 데이터와 함께
//        전송할 수 있기 때문에 좀 더 세밀한 제어가 필요한 경우 사용한다고 합니다.

//    반환 타입에서 사용할 수 있다.
//        ex)
//public ResponseEntity<Article> save(){
//
//        }
//라는 메서드가 있을 때, Article이라는 데이터를 담아서 해당 데이터에 대한 오류 코드와 데이터를 반환할 수 있다
//
//        API 개발 시 올바른 상태코드를 응답하는 것은 매우 중요하다
//        -> 클라이언트가 어느 부분에서 잘못 입력을 했는지 알려줄 수 있기 때문에
//        반환값을 상태 코드 값으로 만들면 좋다
//
//        상태 코드를 반환하기 위해서는 ResponseEntity를 사용하여 반환한다

//@Transactional
//- 모두 성공되어야 하는 일련의 과정을 뜻한다
//        - 데이터베이스의 상태를 변경시키기 위해 수행하는 작업 단위
//
//@Transactional은 수행되는 동작들을 순서대로 동작하다 실패하게 되면 초기 단계로 돌아가는 것이다
//        순서대로 동작을 하다 예외 처리가 나거나 실패하게 된다면, 다시 초기단계로 돌아가는 것은
//        Rollback이라고 한다