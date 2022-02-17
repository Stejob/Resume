package com.example.myresume.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.CareerFragment;
import com.example.myresume.views.fragments.HighlightsFragment;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {

    public FragmentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
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
