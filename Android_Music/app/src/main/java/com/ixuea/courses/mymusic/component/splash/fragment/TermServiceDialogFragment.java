package com.ixuea.courses.mymusic.component.splash.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ixuea.courses.mymusic.R;

import com.ixuea.courses.mymusic.Util.ScreenUtil;
import com.ixuea.courses.mymusic.Util.SuperProcessUtil;
import com.ixuea.courses.mymusic.databinding.FragmentDialogTermServiceBinding;
import com.ixuea.courses.mymusic.fragment.BaseDialogFragment;
import com.ixuea.courses.mymusic.fragment.BaseViewModelDialogFragment;

public class TermServiceDialogFragment extends BaseViewModelDialogFragment<FragmentDialogTermServiceBinding> {

    private  View.OnClickListener listener;

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(com.ixuea.courses.mymusic.R.layout.fragment_dialog_term_service, container, false);
        return binding.getRoot();
    }

    public static TermServiceDialogFragment newInstance(){
        Bundle args = new Bundle();
        TermServiceDialogFragment frag = new TermServiceDialogFragment();
        frag.setArguments(args);
        return frag;
    }


    public static TermServiceDialogFragment showInstance(FragmentManager manager, View.OnClickListener listener){
        TermServiceDialogFragment fragment = newInstance();
        fragment.listener = listener;
        fragment.show(manager,"TermServiceDialogFragment");
        return  fragment;
    }

    @Override
    public void initListeners() {
        super.initListeners();

        Button agreeBtn = binding.serviceAgreeBtn;;

        agreeBtn.setOnClickListener(listener);

        Button disagreeBtn = binding.serviceDisagreeBtn;
        disagreeBtn.setOnClickListener(listener);
    }

    @Override
    public void onResume() {
        super.onResume();

//        WindowManager.LayoutParams parms = getDialog().getWindow().getAttributes();
//        parms.width = (int)(ScreenUtil.getScreenWith(getContext()) * 0.9);
//        parms.height =  WindowManager.LayoutParams.WRAP_CONTENT;
//        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) parms));

        //修改宽度，默认比AlertDialog.Builder显示对话框宽度窄，看着不好看
        //参考：https://stackoverflow.com/questions/12478520/how-to-set-dialogfragments-width-and-height
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();

        params.width = (int) (ScreenUtil.getScreenWith(getContext()) * 0.9);
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

    }
}
