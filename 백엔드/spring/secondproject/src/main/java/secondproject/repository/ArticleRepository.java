package secondproject.repository;

import org.springframework.data.repository.CrudRepository;
import secondproject.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
