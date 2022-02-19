package com.example.myresume.views.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.databinding.FragmentHighlightsBinding;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mfBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_highlights, container, false);
        View view = mfBinding.getRoot();
        return view;
    }
}