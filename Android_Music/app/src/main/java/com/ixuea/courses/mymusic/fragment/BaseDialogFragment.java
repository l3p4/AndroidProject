package com.ixuea.courses.mymusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.ixuea.courses.mymusic.activity.BaseCommonActivity;

public abstract class BaseDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutView(inflater, container,savedInstanceState);
        return  view;
    }

    protected abstract View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initData();
        initListeners();
    }


    public  void initViews(){

    }

    public  void initData(){

    }

    public  void initListeners(){

    }

    protected View findViewById(@IdRes int id){
        return getView().findViewById(id);
    }

    public BaseCommonActivity getHostActivity(){
        return (BaseCommonActivity) getHostActivity();
    }
}
