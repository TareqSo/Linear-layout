package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MathTopicAdapter extends RecyclerView.Adapter<MathTopicAdapter.MathTopicViewHolder> {
    private List<MathTopic> mathTopics;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, MathTopicViewHolder holder);
    }



    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public MathTopicAdapter(List<MathTopic> mathTopics, OnItemClickListener onItemClickListener) {
        this.mathTopics = mathTopics;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MathTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_math_topic, parent, false);
        return new MathTopicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MathTopicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MathTopic mathTopic = mathTopics.get(position);

        holder.topicNameTextView.setText(mathTopic.getTopicName());

        holder.topicIconImageView.setImageResource(mathTopic.getTopicIcon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position, holder);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mathTopics.size();
    }

    static class MathTopicViewHolder extends RecyclerView.ViewHolder {
        private TextView topicNameTextView;
        private ImageView topicIconImageView;

        public MathTopicViewHolder(View itemView) {
            super(itemView);
            topicNameTextView = itemView.findViewById(R.id.topicNameTextView);
            topicIconImageView = itemView.findViewById(R.id.topicIconImageView);
        }
    }
}
