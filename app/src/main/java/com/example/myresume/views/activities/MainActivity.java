package com.example.myresume.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myresume.R;
import com.example.myresume.adapters.FragmentViewPagerAdapter;
import com.example.myresume.databinding.ActivityMainBinding;
import com.example.myresume.interfaces.OnMainActButtonClicks;
import com.example.myresume.utils.UniversalUtils;

public class MainActivity extends AppCompatActivity
        implements OnMainActButtonClicks
        {

            // TODO: check for different screen sizes

    ActivityMainBinding mBinding;
    FragmentViewPagerAdapter viewPagerAdapter;
    View previousBtn;
    ImageButton [] imageButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewPagerAdapter = new FragmentViewPagerAdapter(this);
        mBinding.viewPager.setAdapter(viewPagerAdapter);
        mBinding.setOnBtnClicked(this);
        imageButtons = new ImageButton[]{mBinding.btn1, mBinding.btn2,
                        mBinding.btn3, mBinding.btn4, mBinding.btn5, mBinding.btn6};
        mBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (previousBtn != null) {
                    previousBtn.setSelected(false);
                }
                previousBtn = imageButtons [position];
                imageButtons[position].setSelected(true);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                imageButtons[position].startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.splash_logo_anim));
            }
        });
    }

    @Override
    public void onMainActBtnClicked(int position) {
        mBinding.viewPager.setCurrentItem(position, true);
    }

}