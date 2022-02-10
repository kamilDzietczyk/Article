package com.example.articles.Repository;

import com.example.articles.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    @RestResource()
    List<Article> findByTitleContainsOrContentContains(@Param("tit") String t,@Param("tit") String t1);
}
