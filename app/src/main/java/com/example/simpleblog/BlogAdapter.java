package com.example.simpleblog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class BlogAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<BlogPost> posts;

    public BlogAdapter(Context context, ArrayList<BlogPost> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_blog, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.postImage);
        TextView titleText = convertView.findViewById(R.id.titleText);
        TextView categoryText = convertView.findViewById(R.id.categoryText);
        TextView previewText = convertView.findViewById(R.id.previewText);

        BlogPost post = posts.get(position);
        titleText.setText(post.getTitle());

        String category = post.getCategory();
        if (post.isFavorite()) {
            category = "★ " + category;
        }
        categoryText.setText(category);
        previewText.setText(post.getContent());
        imageView.setImageResource(R.drawable.avatar_circle);

        return convertView;
    }
}
