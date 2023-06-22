package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MathTopicDetailActivity extends AppCompatActivity {
    private TextView mathTopicTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_topic_detail);

        mathTopicTextView = findViewById(R.id.topicNameTextView);

        String mathTopicName = getIntent().getStringExtra("mathTopicName");

        mathTopicTextView.setText(mathTopicName);
    }
}
