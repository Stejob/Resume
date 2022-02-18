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

    ActivityMainBinding mBinding;
    FragmentViewPagerAdapter viewPagerAdapter;
    View previousBtn;
    Fragment previousFrag;
    ImageButton [] imageButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewPagerAdapter = new FragmentViewPagerAdapter(this);
        mBinding.viewPager.setAdapter(viewPagerAdapter);
        mBinding.setOnBtnClicked(this);
        imageButtons = new ImageButton[]{mBinding.btnCareerHighlights, mBinding.btnProfessionalExperiences,
                        mBinding.btn3, mBinding.btn4, mBinding.btn5, mBinding.btn6};
        mBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (previousBtn != null /*&& previousFrag != null*/) {
                    previousBtn.setSelected(false);

                    //previousBtn.setElevation(getResources().getDimension(R.dimen.cardview_default_elevation));
                }
                previousBtn = imageButtons [position];
                imageButtons[position].setSelected(true);
                //imageButtons[position].setElevation(0f);
               // viewPagerAdapter.careerFragment.startAnim();
                //super.onPageScrollStateChanged(position);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mBinding.btn3.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.splash_logo_anim));
            }

        });
    }

    public void callMe(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.phone_number)));
        startActivity(intent);
    }

    public void emailMe(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getResources().getString(R.string.email)});
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.email_response_subject));
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.email_response_body));
        startActivity(Intent.createChooser(intent, ""));
    }

    public void locateMe(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.location_on_map)));
        startActivity(intent);
    }


    @Override
    public void onMainActBtnClicked(int position) {
        mBinding.viewPager.setCurrentItem(position, true);
    }

}