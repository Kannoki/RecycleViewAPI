package com.example.recycleviewapi;

public class Article {
    private String title;
    private String thumbnail;
    private String link;
    private String pub_day;
    private String description;

    public Article(String title, String thumbnail, String link, String pub_day, String description) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.link = link;
        this.pub_day = pub_day;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPub_day() {
        return pub_day;
    }

    public void setPub_day(String pub_day) {
        this.pub_day = pub_day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
