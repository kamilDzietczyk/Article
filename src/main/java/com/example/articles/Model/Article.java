package com.example.articles.Model;


import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_article;
    private String title;
    private String content;
    private Date publish;
    private String magazine_name;
    private String author_name;
    private String author_surname;
    private Date timestamp;

    public Article() {
    }

    public Article(String title, String content, Date publish, String magazine_name, String author_name, String author_surname, Date timestamp) {
        this.title = title;
        this.content = content;
        this.publish = publish;
        this.magazine_name = magazine_name;
        this.author_name = author_name;
        this.author_surname = author_surname;
        this.timestamp = timestamp;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }

    public String getMagazine_name() {
        return magazine_name;
    }

    public void setMagazine_name(String magazine_name) {
        this.magazine_name = magazine_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_surname() {
        return author_surname;
    }

    public void setAuthor_surname(String author_surname) {
        this.author_surname = author_surname;
    }

    public Date getTime_stamp() {
        return timestamp;
    }

    public void setTime_stamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
