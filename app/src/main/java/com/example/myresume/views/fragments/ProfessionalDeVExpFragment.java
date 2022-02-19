package com.example.myresume.views.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.myresume.R;
import com.example.myresume.adapters.ExpandableListAdapter;
import com.example.myresume.databinding.FragmentProDevExpBinding;
import com.example.myresume.models.ProjectDetailModel;
import com.example.myresume.utils.UniversalUtils;

import java.util.List;
import java.util.Map;

public class ProfessionalDeVExpFragment extends Fragment {

    FragmentProDevExpBinding mfBinding;

    public ProfessionalDeVExpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mfBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_pro_dev_exp, container, false);
        View view = mfBinding.getRoot();
        Map<String, List<ProjectDetailModel>> projectDetail = UniversalUtils.getProjectDetail(getContext());
        ExpandableListAdapter adapter = new ExpandableListAdapter(getContext(), projectDetail);
        mfBinding.expandableListView.setAdapter(adapter);

        mfBinding.expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(getContext(),"test",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mfBinding.expandableListView.setOnGroupExpandListener(groupPosition ->
                Toast.makeText(getContext(),"Car Brand with position " + groupPosition + " Was Expanded.",Toast.LENGTH_SHORT).show());

        mfBinding.expandableListView.setOnGroupCollapseListener(groupPosition ->
                Toast.makeText(getContext(),"Car Brand with position " + groupPosition + " Was Collapsed.",Toast.LENGTH_SHORT).show());
        return view;
    }
}