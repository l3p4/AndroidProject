package com.ixuea.courses.mymusic.component.splash.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.Util.DefaultPreferenceUtil;
import com.ixuea.courses.mymusic.Util.SuperProcessUtil;
import com.ixuea.courses.mymusic.activity.BaseCommonActivity;
import com.ixuea.courses.mymusic.activity.BaseLogicActivity;
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;
import com.ixuea.courses.mymusic.component.Guide.Activity.GuideActivity;
import com.ixuea.courses.mymusic.component.splash.fragment.TermServiceDialogFragment;
import com.ixuea.courses.mymusic.Util.SuperDarkUtil;
import com.ixuea.courses.mymusic.Util.SuperDateUtil;
import com.ixuea.courses.mymusic.databinding.ActivitySplashBinding;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
//声明当前页面有动态获取权限
@RuntimePermissions
public class SplashActivity extends BaseViewModelActivity<ActivitySplashBinding> implements View.OnClickListener {

    private TextView textV;
    private TermServiceDialogFragment serviceAgreement;


    @Override
    protected void initViews() {
        super.initViews();

        QMUIStatusBarHelper.translucent(this);
        if(SuperDarkUtil.isDark(this)){
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        }else {
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }
        //状态栏文字黑色

        textV = binding.copyRight;
    }

    @Override
    protected void initListeners() {
        super.initListeners();
    }

    private  void showTermsServiceAgreementDialog(){
//        TermServiceDialogFragment.show();
        serviceAgreement =  TermServiceDialogFragment.showInstance(getSupportFragmentManager(),this);


    }

    @Override
    protected void initDatum() {
        super.initDatum();

        int year = SuperDateUtil.currentYear();
        Log.d("TAG","year:" + year);
//        textV.setText(getResources().getString(R.string.copyRight,year));
        DefaultPreferenceUtil util = DefaultPreferenceUtil.getInstance(getHostActivity());

        showTermsServiceAgreementDialog();

        return;

//        if (util.getAcceptTermsServiceAgreement()){
//            Log.d("Tag","TermsAndServiceAgree");
//            //检查权限
//            checkPermission();
//        }else {
//            Log.d("Tag","TermsAndServiceDisagree");
//            showTermsServiceAgreementDialog();
//        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.service_agree_btn){
            Log.d("Tag","clickAgree");
            serviceAgreement.dismiss();
            DefaultPreferenceUtil.getInstance(getHostActivity()).setAcceptTermsServiceAgreement();
            //检查权限
//            checkPermission();
            prepareNext();
        } else if (view.getId() == R.id.service_disagree_btn) {
            Log.d("Tag","clickDisgree");
            SuperProcessUtil.killApp();
        }
    }
    /**
     * 检查是否有需要的权限
     * <p>
     * <p>
     * 只有部分权限才需要动态授权
     * 例如：网络权限就不需要动态授权，但相机就需要动态授权
     * <p>
     * <p>
     * Google推荐在用到权限的时候才请求用户
     * 但真实项目中，如果在每个用到的位置请求权限可能比较麻烦
     * 例如：项目中有多个位置都用到了相机
     * <p>
     * <p>
     * 所以说大部分项目，像淘宝，京东等软件
     * 是在启动页请求项目所有需要的权限
     * <p>
     * <p>
     * 但如果大家的项目中有足够的时间
     * 肯定还是推荐在用到的时候再请求权限
     */
    private void checkPermission() {
        //让动态框架检查是否授权了f

        //如果不使用框架就使用系统提供的API检查
        //它内部也是使用系统API检查
        //只是使用框架就更简单了
//        SplashActivityPermissionsDispatcher.onPermissionGrantedWithPermissionCheck(this);
    }

    /**
     * 权限授权了就会调用该方法
     * 请求相机权限目的是扫描二维码，拍照
     */

    @NeedsPermission({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void onPermissionGranted() {
        //如果有权限就进入下一步
        prepareNext();
        
    }

    private void prepareNext() {
        int a = 10;
        int b = 9;
        float result = (float) (b/a);
        float result1 = (float) (b*1.0/a);
//        String value = String.format("valueXXX:%f",b/a);
//        String value1 = String.format("valueXXX:%f",b/a);
//        Log.d("1", value + value1);

//        Log.d("2", value1);
        startActivityThenFinshed(GuideActivity.class);

    }

    /**
     * 显示权限授权对话框
     * 目的是提示用户
     */
    @OnShowRationale({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showRequestPermission(PermissionRequest request) {
        new AlertDialog.Builder(getHostActivity())
                .setMessage(R.string.permission_hint)
                .setPositiveButton(R.string.allow, (dialog, which) -> request.proceed())
                .setNegativeButton(R.string.deny, (dialog, which) -> request.cancel()).show();
    }

    /**
     * 拒绝了权限调用
     */
    @OnPermissionDenied({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showDenied() {
        //退出应用
        finish();
    }

    /**
     * 再次获取权限的提示
     */
    @OnNeverAskAgain({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showNeverAsk() {
        //继续请求权限
        checkPermission();
    }


    /**
     * 授权后回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将授权结果传递到框架
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    //    @Override
//    
//    
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        //将授权结果传递到框架
//        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
//    }

}
