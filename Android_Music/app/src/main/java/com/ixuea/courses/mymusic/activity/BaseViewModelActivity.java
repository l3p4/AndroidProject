package com.ixuea.courses.mymusic.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.ixuea.courses.mymusic.Util.ReflectUtil;

public class BaseViewModelActivity<VB extends ViewBinding> extends BaseLogicActivity{
    protected VB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = ReflectUtil.newViewBinding(getLayoutInflater(), this.getClass());
         setContentView(binding.getRoot());

    }
}
