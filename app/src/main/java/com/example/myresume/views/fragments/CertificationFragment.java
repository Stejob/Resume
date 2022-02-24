package com.example.myresume.views.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myresume.R;
import com.example.myresume.adapters.ImageViewPagerAdapter;
import com.example.myresume.databinding.FragmentCertificationBinding;
import com.example.myresume.databinding.GlideBindingAdapter;
import com.example.myresume.interfaces.OnFragBtnClicks;
import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.dialogFragment.ImageViewerDialogFragment;

public class CertificationFragment extends Fragment implements OnFragBtnClicks {

    Context context;
    FragmentCertificationBinding mBinding;
    String [] imageUrls;
    String [] headers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getContext();
        imageUrls = new String[]{
                context.getResources().getString(R.string.six_sigma_degree_web_address_crtf_1),
                context.getResources().getString(R.string.iso_degree_web_address_crtf_2),
                context.getResources().getString(R.string.ims_degree_web_address_crtf_3),
                context.getResources().getString(R.string.primavera_degree_web_address_crtf_4)
        };
        headers = new String[]{
                context.getResources().getString(R.string.certification_1),
                context.getResources().getString(R.string.certification_2),
                context.getResources().getString(R.string.certification_3),
                context.getResources().getString(R.string.certification_4)
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_certification, container, false);
        View view = mBinding.getRoot();
        GlideBindingAdapter.setImageIcon(mBinding.icon, UniversalUtils.CERTIFICATIONS_IMAGE_URL);
        mBinding.setOnClick(this);
        GlideBindingAdapter.setImageResource(mBinding.imgCrtf1, getContext().getString(R.string.six_sigma_degree_web_address_crtf_1));
        GlideBindingAdapter.setImageResource(mBinding.imgCrtf2, getContext().getString(R.string.iso_degree_web_address_crtf_2));
        GlideBindingAdapter.setImageResource(mBinding.imgCrtf3, getContext().getString(R.string.ims_degree_web_address_crtf_3));
        GlideBindingAdapter.setImageResource(mBinding.imgCrtf4, getContext().getString(R.string.primavera_degree_web_address_crtf_4));
        return view;
    }

    @Override
    public void onClickListener(int id) {
        String tag = UniversalUtils.CERTIFICATION_TAG_1;
        switch (id){
            case R.id.img_crtf_1:
            case R.id.txt_crtf_1:
                tag = UniversalUtils.CERTIFICATION_TAG_1;
                break;
            case R.id.img_crtf_2:
            case R.id.txt_crtf_2:
                tag = UniversalUtils.CERTIFICATION_TAG_2;
                break;
            case R.id.img_crtf_3:
            case R.id.txt_crtf_3:
                tag = UniversalUtils.CERTIFICATION_TAG_3;
                break;
            case R.id.img_crtf_4:
            case R.id.txt_crtf_4:
                tag = UniversalUtils.CERTIFICATION_TAG_4;
                break;
        }
        new ImageViewerDialogFragment(context, imageUrls, headers)
            .show(getChildFragmentManager(), tag);
    }
}