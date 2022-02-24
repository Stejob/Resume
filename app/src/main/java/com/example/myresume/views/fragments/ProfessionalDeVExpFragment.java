package com.example.myresume.views.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myresume.R;
import com.example.myresume.adapters.ExpandableListAdapter;
import com.example.myresume.databinding.FragmentProDevExpBinding;
import com.example.myresume.databinding.GlideBindingAdapter;
import com.example.myresume.models.ProjectDetailModel;
import com.example.myresume.utils.UniversalUtils;
import com.example.myresume.views.fragments.dialogFragment.ImageViewerDialogFragment;

import java.util.List;
import java.util.Map;

public class ProfessionalDeVExpFragment extends Fragment {

    FragmentProDevExpBinding mfBinding;
    ProfessionalDeVExpFragment self;
    private String [] imageUrlsCircles;
    private String [] headersCircles;
    private String [] imageUrlsMw;
    private String [] headersMw;
    private String [] imageUrlsAnypal;
    private String [] headersAnypal;
    private String [] imageUrlsShano;
    private String [] headersShano;
    private String [] imageUrlsSic;
    private String [] headersSic;

    public ProfessionalDeVExpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        self = ProfessionalDeVExpFragment.this;
        defineArrays();
        mfBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_pro_dev_exp, container, false);
        View view = mfBinding.getRoot();
        GlideBindingAdapter.setImageIcon(mfBinding.icon, UniversalUtils.PROFESSIONAL_DEV_EXP_IMAGE_URL);
        Map<String, List<ProjectDetailModel>> projectDetail = UniversalUtils.getProjectDetail(requireContext());
        ExpandableListAdapter adapter = new ExpandableListAdapter(getContext(), projectDetail, self);
        mfBinding.expandableListView.setAdapter(adapter);

        return view;
    }

    private void defineArrays (){
        imageUrlsCircles = new String[]{
                getContext().getResources().getString(R.string.circles_web_address_work_sample_1),
                getContext().getResources().getString(R.string.circles_web_address_work_sample_2),
                getContext().getResources().getString(R.string.circles_web_address_work_sample_3)
        };
        headersCircles = new String[]{
                getContext().getResources().getString(R.string.project_cyrcles_pay_header),
                getContext().getResources().getString(R.string.project_cyrcles_pay_header),
                getContext().getResources().getString(R.string.project_cyrcles_pay_header)
        };

        imageUrlsMw = new String[]{
                getContext().getResources().getString(R.string.mw_web_address_work_sample_1),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_2),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_3),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_4),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_5),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_6),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_7),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_8),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_9),
                getContext().getResources().getString(R.string.mw_web_address_work_sample_10)
        };
        headersMw = new String[]{
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header),
                getContext().getResources().getString(R.string.project_mw_header)
        };

        imageUrlsAnypal = new String[]{
                getContext().getResources().getString(R.string.anypal_web_address_work_sample_1),
                getContext().getResources().getString(R.string.anypal_web_address_work_sample_2),
                getContext().getResources().getString(R.string.anypal_web_address_work_sample_3),
                getContext().getResources().getString(R.string.anypal_web_address_work_sample_4)
        };
        headersAnypal = new String[]{
                getContext().getResources().getString(R.string.project_anypal_header),
                getContext().getResources().getString(R.string.project_anypal_header),
                getContext().getResources().getString(R.string.project_anypal_header),
                getContext().getResources().getString(R.string.project_anypal_header)
        };

        imageUrlsShano = new String[]{
                getContext().getResources().getString(R.string.shano_web_address_work_sample_1),
                getContext().getResources().getString(R.string.shano_web_address_work_sample_2),
                getContext().getResources().getString(R.string.shano_web_address_work_sample_3),
                getContext().getResources().getString(R.string.shano_web_address_work_sample_4)
        };
        headersShano = new String[]{
                getContext().getResources().getString(R.string.project_shano_header),
                getContext().getResources().getString(R.string.project_shano_header),
                getContext().getResources().getString(R.string.project_shano_header),
                getContext().getResources().getString(R.string.project_shano_header)
        };

        imageUrlsSic = new String[]{
                getContext().getResources().getString(R.string.sic_web_address_work_sample_1),
                getContext().getResources().getString(R.string.sic_web_address_work_sample_2),
                getContext().getResources().getString(R.string.sic_web_address_work_sample_3)
        };
        headersSic = new String[]{
                getContext().getResources().getString(R.string.project_sic_header),
                getContext().getResources().getString(R.string.project_sic_header),
                getContext().getResources().getString(R.string.project_sic_header)
        };
    }

    public void openWebAddress(String address){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(browserIntent);
    }

    private void showMwAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(requireContext().getResources().getString(R.string.mw_openning_quastion))
                .setPositiveButton(requireContext().getResources().getString(R.string.txt_download_main_app), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        openWebAddress(requireContext().getResources().getString(R.string.mw_main_download_link));
                    }
                })
                .setNegativeButton(requireContext().getResources().getString(R.string.txt_download_guest_app), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        openWebAddress(requireContext().getResources().getString(R.string.mw_guest_download_link));
                    }
                })
                .setNeutralButton(requireContext().getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    private void showExcuses(String projectName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(String.format("%s %s",projectName, requireContext().getResources().getString(R.string.excuse)))
                .setPositiveButton(requireContext().getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    public void onClickImage (int position){
        switch (position){
            case 0:
                new ImageViewerDialogFragment(getContext(), imageUrlsCircles, headersCircles)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
            case 1:
                new ImageViewerDialogFragment(getContext(), imageUrlsMw, headersMw)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
            case 2:
                new ImageViewerDialogFragment(getContext(), imageUrlsAnypal, headersAnypal)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
            case 3:
                new ImageViewerDialogFragment(getContext(), imageUrlsShano, headersShano)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
            case 4:
                new ImageViewerDialogFragment(getContext(), imageUrlsSic, headersSic)
                        .show(getChildFragmentManager(), UniversalUtils.CERTIFICATION_TAG_1);
                break;
        }
    }

    public void onClickDownload(int position) {
        switch (position){
            case 0:
                showExcuses("Circles Pay");
                break;
            case 1:
                showMwAlertDialog ();
                break;
            case 2:
                showExcuses("Anypal");
                break;
            case 3:
                openWebAddress(requireContext().getResources().getString(R.string.shano_download_link));
                break;
            case 4:
                openWebAddress(requireContext().getResources().getString(R.string.sic_download_link));
                break;
        }
    }


}