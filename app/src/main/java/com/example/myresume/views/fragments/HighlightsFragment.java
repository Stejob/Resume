package com.example.myresume.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.databinding.FragmentHighlightsBinding;
import com.example.myresume.utils.UniversalUtils;


public class HighlightsFragment extends Fragment {

    FragmentHighlightsBinding mfBinding;


    public HighlightsFragment() {
        // Required empty public constructor
    }

    public static HighlightsFragment newInstance(String param1, String param2) {
        HighlightsFragment fragment = new HighlightsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mfBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_highlights, container, false);
        View view = mfBinding.getRoot();
        mfBinding.txtCareer.setText(
                requireContext().getResources().getString(R.string.career_objective, checkExpYears()));
        return view;
    }

    private String checkExpYears() {
        double yearsOfExpLong =  ((System.currentTimeMillis() / 1000.0 - UniversalUtils.START_DATE_TIMESTAMP) /
                60.0 /
                60.0 /
                24.0 /
                365.0);
        String yearsOfExp = "";
        if (yearsOfExpLong - (int) yearsOfExpLong > 0.80000) {
            yearsOfExp = String.valueOf((int) yearsOfExpLong + 1);
        } else {
            yearsOfExp = "more than " + (int) yearsOfExpLong;
        }
        return yearsOfExp;
    }
}