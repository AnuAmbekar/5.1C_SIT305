package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private List<NewsClass> newsClassList = new ArrayList<>();
    private Context context;

    private ItemClickListener clickListener;

    public RecyclerViewAdapter(List<NewsClass> newsClassList, ItemClickListener clickListener) {
        this.newsClassList = newsClassList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titleText.setText(newsClassList.get(position).getTitle());
        holder.newsText.setText(newsClassList.get(position).getNewsText());
        holder.imageView.setImageResource(newsClassList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickListener.onItemClick(newsClassList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsClassList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, newsText;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            newsText = itemView.findViewById(R.id.newsText);
            imageView = itemView.findViewById(R.id.imageView);

        }

    }
    public interface ItemClickListener {
        public void onItemClick(NewsClass newsClass);
    }
}
