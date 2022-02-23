package com.example.myresume.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.CertificationFragment;
import com.example.myresume.views.fragments.EducationsFragment;
import com.example.myresume.views.fragments.HighlightsFragment;
import com.example.myresume.views.fragments.OtherExpSkillsFragment;
import com.example.myresume.views.fragments.PersonalDetailFragment;
import com.example.myresume.views.fragments.ProfessionalDeVExpFragment;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {

    public FragmentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HighlightsFragment();
            case 1:
                return new ProfessionalDeVExpFragment();
            case 2:
                return new EducationsFragment();
            case 3:
                return new OtherExpSkillsFragment();
            case 4:
                return new CertificationFragment();
            case 5:
                return new PersonalDetailFragment();
        }
        return new HighlightsFragment();
    }

    @Override
    public int getItemCount() {
        return UniversalUtils.SECTIONS.length;
    }
}
