package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterH extends RecyclerView.Adapter<RecyclerViewAdapterH.ViewHolder> {

    private List<ImageClass> imageClassList = new ArrayList<>();

    public RecyclerViewAdapterH(List<ImageClass> imageClassList) {
        this.imageClassList = imageClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_row, parent, false);
        return new ViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView2.setImageResource(imageClassList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return imageClassList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView2 = itemView.findViewById(R.id.imageView2);

        }
    }
}
