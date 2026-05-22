package com.example.simpleblog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.app.Activity;

public class AddPostActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        EditText titleInput = findViewById(R.id.titleInput);
        EditText categoryInput = findViewById(R.id.categoryInput);
        EditText contentInput = findViewById(R.id.contentInput);
        Switch favoriteSwitch = findViewById(R.id.favoriteSwitch);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(view -> {
            String title = titleInput.getText().toString().trim();
            String category = categoryInput.getText().toString().trim();
            String content = contentInput.getText().toString().trim();
            boolean favorite = favoriteSwitch.isChecked();

            if (title.isEmpty() || category.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            BlogPost newPost = new BlogPost(title, category, content, favorite);
            BlogRepository.addPost(newPost);

            Intent broadcastIntent = new Intent(this, PostCreatedReceiver.class);
            broadcastIntent.setAction("com.example.simpleblog.POST_CREATED");
            broadcastIntent.putExtra("title", title);
            sendBroadcast(broadcastIntent);

            Intent serviceIntent = new Intent(this, BlogIntentService.class);
            serviceIntent.putExtra("message", "New post created: " + title);
            startService(serviceIntent);

            Toast.makeText(this, "Post saved", Toast.LENGTH_SHORT).show();
            finish();
        });

        cancelButton.setOnClickListener(view -> finish());
    }
}
