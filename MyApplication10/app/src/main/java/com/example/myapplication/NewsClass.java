package com.example.myapplication;

public class NewsClass {
    private String title, newsText;
    private int image;

    public NewsClass(String title, String newsText, int image) {
        this.title = title;
        this.newsText = newsText;
        this.image = image;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNewsText() {return newsText;}
    public String getTitle() {return title;}
    public int getImage() {return image;}
}
