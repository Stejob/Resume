package com.example.myresume.views.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.databinding.FragmentOtherExpSkillsBinding;
import com.example.myresume.databinding.GlideBindingAdapter;
import com.example.myresume.interfaces.OnFragBtnClicks;
import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.dialogFragment.ImageViewerDialogFragment;

public class OtherExpSkillsFragment extends Fragment implements OnFragBtnClicks {

    FragmentOtherExpSkillsBinding mBinding;
    String [] imageUrls;
    String [] headers;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        imageUrls = new String[]{
                getContext().getResources().getString(R.string.dashboard_web_address_work_sample_1),
                getContext().getResources().getString(R.string.table_web_address_work_sample_2),
                getContext().getResources().getString(R.string.report_web_address_work_sample_3)
        };
        headers = new String[]{
                getContext().getResources().getString(R.string.dashboard_web_address_header_1),
                getContext().getResources().getString(R.string.table_web_address_header_2),
                getContext().getResources().getString(R.string.report_web_address_header_3)
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_other_exp_skills, container, false);
        View view = mBinding.getRoot();
        GlideBindingAdapter.setImageIcon(mBinding.icon, UniversalUtils.OTHER_EXP_SKILLS_IMAGE_URL);
        mBinding.setClick(this);
        return view;
    }

    @Override
    public void onClickListener(int id) {
        switch (id){
            case R.id.btn_show_other_skill_excel:
            case R.id.txt_other_skill_excel:
                new ImageViewerDialogFragment(getContext(), imageUrls, headers)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
            case R.id.ll_other_experiences_header:
                if(mBinding.llOtherExperiences.getVisibility() != View.GONE){
                    mBinding.llOtherExperiences.setVisibility(View.GONE);
                    mBinding.imgOtherExperienceDown.setImageResource(R.drawable.ic_keyboard_arrow_down_24);
                }else {
                    mBinding.llOtherExperiences.setVisibility(View.VISIBLE);
                    mBinding.imgOtherExperienceDown.setImageResource(R.drawable.ic_keyboard_arrow_up_24);
                }
                break;
            case R.id.ll_other_skills_header:
                if(mBinding.llOtherSkills.getVisibility() != View.GONE){
                    mBinding.llOtherSkills.setVisibility(View.GONE);
                    mBinding.imgOtherSkillsDown.setImageResource(R.drawable.ic_keyboard_arrow_down_24);
                }else {
                    mBinding.llOtherSkills.setVisibility(View.VISIBLE);
                    mBinding.imgOtherSkillsDown.setImageResource(R.drawable.ic_keyboard_arrow_up_24);
                }
                break;
            case R.id.ll_language_skills_header:
                if(mBinding.llLanguageSkills.getVisibility() != View.GONE){
                    mBinding.llLanguageSkills.setVisibility(View.GONE);
                    mBinding.imgLanguageSkillsDown.setImageResource(R.drawable.ic_keyboard_arrow_down_24);
                }else {
                    mBinding.llLanguageSkills.setVisibility(View.VISIBLE);
                    mBinding.imgLanguageSkillsDown.setImageResource(R.drawable.ic_keyboard_arrow_up_24);
                }
                break;
            case R.id.ll_teaching_experiences_header:
                if(mBinding.llTeachingExperiences.getVisibility() != View.GONE){
                    mBinding.llTeachingExperiences.setVisibility(View.GONE);
                    mBinding.imgTeachingExperienceDown.setImageResource(R.drawable.ic_keyboard_arrow_down_24);
                }else {
                    mBinding.llTeachingExperiences.setVisibility(View.VISIBLE);
                    mBinding.imgTeachingExperienceDown.setImageResource(R.drawable.ic_keyboard_arrow_up_24);
                }
                break;
        }

    }
}