package com.study.teamspkt.worldnews.Models;

/**
 * Created by Pon Long Bong on 9/16/2017.
 */

public class Post_Model {
    private String post_id;
    private String titile;
    private String description;
    private String content;
    private String category_id;
    private String date;
    private String cover;
    private String author;

    public Post_Model(String post_id, String titile, String description, String content, String category_id, String date,String cover,String author) {
        this.post_id = post_id;
        this.titile = titile;
        this.description = description;
        this.content = content;
        this.category_id = category_id;
        this.date = date;
        this.cover = cover;
        this.author = author;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
