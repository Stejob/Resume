package com.example.myresume.views.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.databinding.FragmentOtherExpSkillsBinding;
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
        mBinding.setClick(this);
        return view;
    }

    @Override
    public void onClickListener(int id) {
        new ImageViewerDialogFragment(getContext(), imageUrls, headers)
                .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
    }
}