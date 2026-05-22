package com.example.simpleblog;

import java.util.ArrayList;

public class BlogRepository {
    private static ArrayList<BlogPost> posts = new ArrayList<>();

    public static ArrayList<BlogPost> getPosts() {
        if (posts.isEmpty()) {
            addSamplePosts();
        }
        return posts;
    }

    public static void addPost(BlogPost post) {
        posts.add(0, post);
    }

    private static void addSamplePosts() {
        posts.add(new BlogPost(
                "My First Android App",
                "Study",
                "Today I started learning Android Studio. I created activities, used buttons, and displayed posts in a ListView.",
                true));

        posts.add(new BlogPost(
                "A Productive Student Day",
                "Life",
                "A simple routine can make study easier: plan the task, code slowly, test the app, and write a short learning diary.",
                false));

        posts.add(new BlogPost(
                "Why I Like Simple Apps",
                "Opinion",
                "Simple apps are easier to understand. They help beginners learn the basic structure before moving to advanced features.",
                false));
    }
}
