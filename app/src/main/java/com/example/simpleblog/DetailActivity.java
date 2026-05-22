package com.example.simpleblog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView detailCategory = findViewById(R.id.detailCategory);
        TextView detailContent = findViewById(R.id.detailContent);
        Button backButton = findViewById(R.id.backButton);

        String title = getIntent().getStringExtra("title");
        String category = getIntent().getStringExtra("category");
        String content = getIntent().getStringExtra("content");
        boolean favorite = getIntent().getBooleanExtra("favorite", false);

        detailTitle.setText(title);
        detailCategory.setText(favorite ? "★ " + category : category);
        detailContent.setText(content);

        backButton.setOnClickListener(view -> finish());
    }
}
