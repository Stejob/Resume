package com.example.myresume.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.myresume.R;
import com.example.myresume.adapters.FragmentViewPagerAdapter;
import com.example.myresume.databinding.ActivityMainBinding;
import com.example.myresume.interfaces.OnMainActButtonClicks;

public class MainActivity extends AppCompatActivity implements OnMainActButtonClicks {

    ActivityMainBinding mBinding;
    FragmentViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewPagerAdapter = new FragmentViewPagerAdapter(this);
        mBinding.viewPager.setAdapter(viewPagerAdapter);

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
    public void onMainActBtnClicked(int id) {

    }
}