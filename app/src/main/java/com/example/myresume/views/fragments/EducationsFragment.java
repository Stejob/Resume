package com.example.myresume.views.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.databinding.FragmentEducationsBinding;
import com.example.myresume.databinding.GlideBindingAdapter;
import com.example.myresume.interfaces.OnFragBtnClicks;
import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.dialogFragment.ImageViewerDialogFragment;


public class EducationsFragment extends Fragment implements OnFragBtnClicks {

    FragmentEducationsBinding mBinding;
    String [] imageUrls;
    String [] header;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageUrls = new String[]{getContext().getResources().getString(R.string.android_newer_degree_web_address),
                getContext().getResources().getString(R.string.android_older_degree_web_address),
                getContext().getResources().getString(R.string.uni_degree_web_address)};
        header = new String[]{
                getContext().getResources().getString(R.string.education_android_title_1),
                getContext().getResources().getString(R.string.education_android_title_2),
                getContext().getResources().getString(R.string.education_industrial_engineering_title_1)
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_educations, container, false);
        View view = mBinding.getRoot();
        GlideBindingAdapter.setImageIcon(mBinding.icon, UniversalUtils.EDUCATIONS_IMAGE_URL);
        mBinding.setClick(this);
        return view;
    }

    public void openWebAddress(String address){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(browserIntent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClickListener(int id) {
        switch (id){
            case R.id.ll_education_android_header:
                if(mBinding.llEducationAndroidBody.getVisibility() != View.GONE){
                    mBinding.llEducationAndroidBody.setVisibility(View.GONE);
                    mBinding.imgAndroidDown.setImageResource(R.drawable.ic_keyboard_arrow_down_24);
                }else {
                    mBinding.llEducationAndroidBody.setVisibility(View.VISIBLE);
                    mBinding.imgAndroidDown.setImageResource(R.drawable.ic_keyboard_arrow_up_24);
                }
                break;
            case R.id.ll_education_engineering_header:
                if(mBinding.llEducationEngineeringBody.getVisibility() != View.GONE){
                    mBinding.llEducationEngineeringBody.setVisibility(View.GONE);
                    mBinding.imgEducationEngineeringDown.setImageResource(R.drawable.ic_keyboard_arrow_down_24);
                }else {
                    mBinding.llEducationEngineeringBody.setVisibility(View.VISIBLE);
                    mBinding.imgEducationEngineeringDown.setImageResource(R.drawable.ic_keyboard_arrow_up_24);
                }
                break;
            case R.id.btn_go_to_school_1:
            case R.id.txt_school_1:
            case R.id.btn_go_to_school_2:
            case R.id.txt_school_2:
                openWebAddress(getContext().getResources().getString(R.string.simi));
                break;
            case R.id.btn_show_android_1_degree:
            case R.id.txt_android_degree_1:
                new ImageViewerDialogFragment(getContext(), imageUrls, header)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
            case R.id.btn_show_android_2_degree:
            case R.id.txt_android_degree_2:
                new ImageViewerDialogFragment(getContext(), imageUrls, header)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_2);
                break;
            case R.id.btn_go_to_uni_1:
            case R.id.txt_uni_1:
            case R.id.btn_go_to_uni_2:
            case R.id.txt_uni_2:
                openWebAddress(getContext().getResources().getString(R.string.uni));
                break;
            case R.id.btn_show_engineering_1_degree:
            case R.id.txt_engineering_degree_1:
                new ImageViewerDialogFragment(getContext(), imageUrls, header)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_3);
                break;
        }

    }
}