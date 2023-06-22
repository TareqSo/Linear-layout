package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MathTopicAdapter.OnItemClickListener {
    private MathTopicAdapter mathTopicAdapter;
    private List<MathTopic> mathTopics;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String selectedMathTopic = sharedPreferences.getString("selectedMathTopic", "");

        mathTopics = new ArrayList<>();
        mathTopics.add(new MathTopic("gard 1", R.drawable.ic_action_name));
        mathTopics.add(new MathTopic("gard 2", R.drawable.ic_action_name));
        mathTopics.add(new MathTopic("gard 3", R.drawable.ic_action_name));
        mathTopics.add(new MathTopic("gard 4", R.drawable.ic_action_name));
        mathTopics.add(new MathTopic("gard 5", R.drawable.ic_action_name));
        mathTopics.add(new MathTopic("gard 6", R.drawable.ic_action_name));
        mathTopics.add(new MathTopic("gard 7", R.drawable.ic_action_name));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mathTopicAdapter = new MathTopicAdapter(mathTopics, this);
        recyclerView.setAdapter(mathTopicAdapter);


        mathTopicAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position, MathTopicAdapter.MathTopicViewHolder holder) {
        MathTopic mathTopic = mathTopics.get(position);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("selectedMathTopic", mathTopic.getTopicName());
        editor.apply();

        Intent intent = new Intent(holder.itemView.getContext(), MathTopicDetailActivity.class);
        intent.putExtra("mathTopicName", mathTopic.getTopicName());
        holder.itemView.getContext().startActivity(intent);
    }





}
