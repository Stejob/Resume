package com.example.myresume.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.myresume.R;
import com.example.myresume.databinding.ActivitySplashBinding;
import com.example.myresume.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
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
                if(!Utils.isInternetConnected(SplashActivity.this)){
                    Utils.showInternetDialog(SplashActivity.this);
                }
                startMainActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void startMainActivity() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SplashActivity.this.finish();
        }, 2000);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}