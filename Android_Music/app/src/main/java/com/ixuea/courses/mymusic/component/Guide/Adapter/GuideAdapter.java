package com.ixuea.courses.mymusic.component.Guide.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.component.Guide.ItemView.GuideItemView;

import java.util.ArrayList;

public class GuideAdapter extends RecyclerView.Adapter<GuideViewHolder> {
    private ArrayList<Integer> dataList;

    public GuideAdapter(ArrayList<Integer> dataList){
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public GuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =  inflater.inflate(R.layout.item_guide,parent,false);
        GuideViewHolder holder = new GuideViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GuideViewHolder holder, int position) {
        ImageView imageV =  holder.itemView.findViewById(R.id.guideImageView);
        imageV.setImageResource(dataList.get(position));


    }




    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
