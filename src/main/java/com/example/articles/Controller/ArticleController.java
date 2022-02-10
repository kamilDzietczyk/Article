package com.example.articles.Controller;

import com.example.articles.Model.Article;
import com.example.articles.Repository.ArticleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("api/Article")
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/GetAll")
    public List<Article> getAll(){
        return articleRepository.findAll(Sort.by(Sort.Direction.DESC,"publish"));
    }

    @GetMapping("/GetById/{id}")
    public Article getById(@PathVariable(value = "id") int id){
        Optional<Article> art = articleRepository.findById(id);
        return art.isEmpty()?null:art.get();
    }

    @GetMapping("/GetAll/{temp}")
    public List<Article> getTemp(@PathVariable(value = "temp")String t){
        return articleRepository.findByTitleContainsOrContentContains(t,t);
    }

    @PostMapping("/AddArticle")
    public String addArticle(@RequestBody Article a){
        articleRepository.save(a);
        return "User is added";
    }

    @PutMapping("/UpdateArticle/{id}")
    public ResponseEntity<Article> updateUser(
            @PathVariable(value = "id") int id, @RequestBody Article a) {
        Optional<Article> art = articleRepository.findById(id);
        if(art.isPresent()){
            Article _art = art.get();
            _art.setTitle(a.getTitle());
            _art.setContent(a.getContent());
            _art.setPublish(a.getPublish());
            _art.setMagazine_name(a.getMagazine_name());
            _art.setAuthor_name(a.getAuthor_name());
            _art.setAuthor_surname(a.getAuthor_surname());
            _art.setTime_stamp(a.getTime_stamp());
            return new ResponseEntity<>(articleRepository.save(_art), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/DeleteArticle/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable(value = "id") int Id) {
        try {
            articleRepository.deleteById(Id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
