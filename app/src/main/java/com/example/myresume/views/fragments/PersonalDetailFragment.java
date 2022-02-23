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
import com.example.myresume.databinding.FragmentPersonalDetailBinding;
import com.example.myresume.interfaces.OnFragBtnClicks;

import java.util.Locale;

public class PersonalDetailFragment extends Fragment implements OnFragBtnClicks {

    FragmentPersonalDetailBinding mBinding;
    public PersonalDetailFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_detail, container, false);
        View view = mBinding.getRoot();
        mBinding.setOnClick(this);
        return view;
    }


    public void callMe() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.phone_number)));
        startActivity(intent);
    }

    public void emailMe() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getResources().getString(R.string.email)});
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.email_response_subject));
        intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.email_response_body));
        startActivity(Intent.createChooser(intent, ""));
    }

    public void locateMe() {
        String uri = String.format(Locale.US, "geo:%f,%f", 3.1945992936520997, 101.73609188181749);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void openWebAddress(String address){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(browserIntent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClickListener(int id) {
        switch (id){
            case R.id.txt_email:
            case R.id.btn_go_to_email:
                emailMe();
                break;
            case R.id.txt_phone:
            case R.id.btn_go_to_phone:
                callMe();
                break;
            case R.id.txt_location:
            case R.id.btn_go_to_location:
                locateMe();
                break;
            case R.id.txt_github:
            case R.id.btn_go_to_github:
                openWebAddress(getResources().getString(R.string.github_address));
                break;
            case R.id.txt_stackoverflow:
            case R.id.btn_go_to_stackoverflow:
                openWebAddress(getResources().getString(R.string.stack_overflow_address));
                break;
            case R.id.txt_facebook:
            case R.id.btn_go_to_facebook:
                openWebAddress(getResources().getString(R.string.facebook_address));
                break;
            case R.id.txt_linked_in:
            case R.id.btn_go_to_linked_in:
                openWebAddress(getResources().getString(R.string.linkedin_address));
                break;
        }
    }
}