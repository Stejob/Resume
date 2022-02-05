package com.example.myresume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView txtLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        Animation logoAnim, txtLogoAnim;
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.splash_logo_anim);
        txtLogoAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);
        logo.startAnimation(logoAnim);
        logoAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (logo.getVisibility()!= View.VISIBLE)
                    logo.setVisibility(View.VISIBLE);
                if (txtLogo.getVisibility() != View.VISIBLE)
                    txtLogo.setVisibility(View.VISIBLE);
                txtLogo.startAnimation(txtLogoAnim);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(() -> {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void init(){
        logo = findViewById(R.id.logo);
        txtLogo = findViewById(R.id.txt_logo);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}