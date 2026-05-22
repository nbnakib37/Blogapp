package com.example.simpleblog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PostCreatedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("title");
        Toast.makeText(context, "Broadcast: New post added - " + title, Toast.LENGTH_SHORT).show();
    }
}
