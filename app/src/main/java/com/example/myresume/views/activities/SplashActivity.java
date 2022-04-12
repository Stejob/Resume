package com.example.myresume.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.myresume.R;
import com.example.myresume.api.ApiConnection;
import com.example.myresume.databinding.ActivitySplashBinding;
import com.example.myresume.utils.JsonUtil;
import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding mBinding;
    private String appVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Animation logoAnim, txtLogoAnim;
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.splash_logo_anim);
        txtLogoAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);
        mBinding.logo.startAnimation(logoAnim);
        logoAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (mBinding.logo.getVisibility()!= View.VISIBLE)
                    mBinding.logo.setVisibility(View.VISIBLE);
                if (mBinding.txtLogo.getVisibility() != View.VISIBLE)
                    mBinding.txtLogo.setVisibility(View.VISIBLE);
                mBinding.txtLogo.startAnimation(txtLogoAnim);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(!Utils.isInternetConnected(SplashActivity.this))
                    showInternetDialog(getResources().getString(R.string.check_internet_connection));
                else {
                    if (!UniversalUtils.IS_IT_MY_VERSION)
                        checkAppVersion();
                    startMainActivity();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void checkAppVersion (){
        ApiConnection connection = new ApiConnection(this,
                getResources().getString(R.string.url_address) + UniversalUtils.VERSION_CONTROL_URL,
                new ApiConnection.Stuff() {
                    @Override
                    public String backgroundSetup() {
                        return JsonUtil.requestVersionControl(getResources().getString(R.string.url_approval),
                                appVersion);
                    }

                    @Override
                    public void onPreExe() {
                    }

                    @Override
                    public void onPostExe(String s) {
                    }
                });
        connection.execute();
    }

    public void startMainActivity() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SplashActivity.this.finish();
        }, 2000);

    }

    public void showInternetDialog (String massage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(massage)
                .setCancelable(false)
                .setPositiveButton(getResources().getString(R.string.ok),
                        (dialogInterface, i) -> {
                    if(!Utils.isInternetConnected(SplashActivity.this)){
                        Toast.makeText(this, getResources().getString(R.string.functional_problem), Toast.LENGTH_SHORT).show();
                    }
                    startMainActivity();
                })
                .show();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}