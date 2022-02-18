package com.example.myresume.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.CareerFragment;
import com.example.myresume.views.fragments.HighlightsFragment;

import java.util.List;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {
    public Fragment careerFragment;
    public Fragment highlightsFragment;
    int counterBind;
    int counterDetached;

    public FragmentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        //careerFragment = new CareerFragment();
        //highlightsFragment = new HighlightsFragment();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
            case 2:
            case 4:
                return new CareerFragment();
            case 1:
            case 3:
            case 5:
                return new HighlightsFragment();
        }
        return new CareerFragment();
    }

    @Override
    public int getItemCount() {
        return UniversalUtils.SECTIONS.length;
    }
}
