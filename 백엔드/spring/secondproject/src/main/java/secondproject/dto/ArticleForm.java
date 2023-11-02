package secondproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import secondproject.entity.Article;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;

    // 롬복으로 대체 가능
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity(){
        return new Article(null,title,content);
    }
}
