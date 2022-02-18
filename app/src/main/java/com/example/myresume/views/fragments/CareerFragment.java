package com.example.myresume.views.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.databinding.FragmentCareerBinding;
import com.example.myresume.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CareerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CareerFragment extends Fragment {

    FragmentCareerBinding mfBinding;


    public CareerFragment() {
        // Required empty public constructor
    }

    public static CareerFragment newInstance(String param1, String param2) {
        CareerFragment fragment = new CareerFragment();
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
        mfBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_career, container, false);
        View view = mfBinding.getRoot();
        return view;
    }
}