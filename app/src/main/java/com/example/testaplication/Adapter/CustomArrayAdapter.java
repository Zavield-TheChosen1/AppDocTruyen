package com.example.testaplication.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
public class CustomArrayAdapter extends ArrayAdapter<String> {

    private List<String> chapters;
    private int readingChapterIndex = -1; // Index của chương bạn đang đọc

    public CustomArrayAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.chapters = objects;
    }

    public void setReadingChapterIndex(int index) {
        this.readingChapterIndex = index;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        if (position == readingChapterIndex) {
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.BLACK);
        }

        return view;
    }
}
