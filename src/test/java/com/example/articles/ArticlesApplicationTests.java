package com.example.articles;

import com.example.articles.Controller.ArticleController;
import com.example.articles.Model.Article;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ArticlesApplicationTests {

    @Autowired
    ArticleController articleController;

    @Test
    void contextLoads() {
    }

    //Post
    @Test
    public void APost() throws ParseException {
        String date_string = "26-09-1989";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);

        Article a = new Article();
        a.setTitle("XYZ");
        a.setContent("khbsdfjhbdsjfbd");
        a.setPublish(date);
        a.setMagazine_name("Xxx");
        a.setAuthor_name("AAA");
        a.setAuthor_surname("BBB");
        a.setTime_stamp(new Date());
        articleController.addArticle(a);
    }

    //Get all
    @Test
    public void GetAll(){
        List<Article> list = articleController.getAll();
        Truth.assertThat(list).isNotEmpty();
    }

    //Get when id Exist
    @Test
    public void GetByIdExist(){
        Article article = articleController.getById(1);
        Truth.assertThat(article).isNotNull();
    }

    //Get when id notExist
    @Test
    public void GetByIdNotExist(){
        Article article = articleController.getById(300);
        Truth.assertThat(article).isNull();
    }

    //Get when Exist
    @Test
    public void getTempIfExist(){
        List<Article> article = articleController.getTemp("XY");
        Truth.assertThat(article).isNotEmpty();
    }

    //Get when not Exist
    @Test
    public void getTempIfnotExist(){
        List<Article> article = articleController.getTemp("lll");
        Truth.assertThat(article).isEmpty();
    }

    @Test
    public void UpdateArticle() throws ParseException {
        String date_string = "26-09-2021";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);

        Article a = new Article();
        a.setTitle("XYZ");
        a.setContent("khbsdfjhbdsjfbd");
        a.setPublish(date);
        a.setMagazine_name("Xxx");
        a.setAuthor_name("CCC");
        a.setAuthor_surname("BBB");
        a.setTime_stamp(new Date());
        articleController.updateUser(1,a);

        String art = articleController.getById(1).getAuthor_name();

        Truth.assertThat(art).isEqualTo("CCC");
    }

    @Test
    public void DeleteArticle(){
        articleController.deleteUser(2);
        int articles = articleController.getAll().size();
        Truth.assertThat(articles).isEqualTo(1);
    }
}
