package com.ixuea.courses.mymusic.component.Guide.ItemView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.ixuea.courses.mymusic.R;

public class GuideItemView extends View {
    public  @DrawableRes int data;
    public GuideItemView(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

//        ImageView imageV = findViewById(R.id.guideImageView);
//        imageV.setImageResource(data);
    }

}
