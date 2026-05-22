package com.example.simpleblog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<BlogPost> posts;
    private BlogAdapter adapter;
    private TextView postCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addPostButton = findViewById(R.id.addPostButton);
        ListView blogListView = findViewById(R.id.blogListView);
        postCountText = findViewById(R.id.postCountText);

        posts = BlogRepository.getPosts();
        adapter = new BlogAdapter(this, posts);
        blogListView.setAdapter(adapter);

        updatePostCount();

        addPostButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddPostActivity.class);
            startActivity(intent);
        });

        blogListView.setOnItemClickListener((parent, view, position, id) -> {
            BlogPost selectedPost = posts.get(position);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("title", selectedPost.getTitle());
            intent.putExtra("category", selectedPost.getCategory());
            intent.putExtra("content", selectedPost.getContent());
            intent.putExtra("favorite", selectedPost.isFavorite());
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            updatePostCount();
        }
    }

    private void updatePostCount() {
        postCountText.setText("Posts: " + posts.size() + "   Tap a post to read more");
    }
}
