package com.ixuea.courses.mymusic.component.Guide.Adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.component.Guide.ItemView.GuideItemView;

public class GuideViewHolder extends RecyclerView.ViewHolder {

    protected View itemView;
    public GuideViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void bindData(int data){
        ImageView imageV =  itemView.findViewById(R.id.guideImageView);
        imageV.setImageResource(data);
    }


}
