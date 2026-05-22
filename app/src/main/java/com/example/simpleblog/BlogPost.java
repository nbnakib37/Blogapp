package com.example.simpleblog;

public class BlogPost {
    private String title;
    private String category;
    private String content;
    private boolean favorite;

    public BlogPost(String title, String category, String content, boolean favorite) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
