package com.example.myresume.views.fragments.dialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.myresume.R;
import com.example.myresume.adapters.ImageViewPagerAdapter;
import com.example.myresume.databinding.FragmentImageViewerDialogBinding;
import com.example.myresume.utils.UniversalUtils;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class ImageViewerDialogFragment extends DialogFragment {

    Context context;
    FragmentImageViewerDialogBinding mBinding;
    private String [] imageUrls;
    private String [] headers;

    public ImageViewerDialogFragment() {

    }

    public ImageViewerDialogFragment(Context context, String [] imageUrls, String [] headers) {
        this.context = context;
        this.imageUrls = imageUrls;
        this.headers = headers;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_viewer_dialog, container, false);
        View view = mBinding.getRoot();
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(getContext(), imageUrls, headers);
        mBinding.dialogFragmentViewPager.setAdapter(adapter);
        mBinding.dialogFragmentViewPager.setCurrentItem(Integer.parseInt(Objects.requireNonNull(getTag())), false);
        if (getTag() != UniversalUtils.OTHER_TAG)
            new TabLayoutMediator(mBinding.intoTabLayout, mBinding.dialogFragmentViewPager, (tab, position) -> {}).attach();
        return view;
    }
}
