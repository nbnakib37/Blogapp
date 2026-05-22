package com.example.simpleblog;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class BlogIntentService extends IntentService {
    public BlogIntentService() {
        super("BlogIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String message = intent.getStringExtra("message");
            Log.d("SimpleBlog", "IntentService running: " + message);
        }
    }
}
