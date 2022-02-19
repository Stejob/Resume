package com.example.myresume.utils;

import android.content.Context;

import com.example.myresume.R;
import com.example.myresume.models.ProjectDetailModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UniversalUtils {
    public static final int mainActHeaderImageUrl = R.drawable.nav_menu_header_bg_blue;
    public static final int mainActMyImageUrl = R.drawable.reza;
    public static final int HIGHLIGHTS = 0;
    public static final int PROFESSIONAL_DEC_EXPERIENCES = 1;
    public static final int PERSONAL_DETAIL = 2;

    public static final int [] SECTIONS = {HIGHLIGHTS, PROFESSIONAL_DEC_EXPERIENCES,
            PERSONAL_DETAIL, 3,
            4, 5};

    public static Map<String, List<ProjectDetailModel>> getProjectDetail(Context context){
        Map<String, List<ProjectDetailModel>> projectDetails = new LinkedHashMap<>();
/////////////
        List<ProjectDetailModel> cyrclesPayProjectList = new ArrayList<>();
        cyrclesPayProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_proceedings),
                context.getResources().getString(R.string.project_cyrcles_pay_proceedings))
        );
        cyrclesPayProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_descriptions),
                context.getResources().getString(R.string.project_cyrcles_pay_descriptions))
        );
        cyrclesPayProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_features),
                context.getResources().getString(R.string.project_cyrcles_pay_features))
        );
        projectDetails.put(context.getResources().getString(R.string.project_cyrcles_pay_header),cyrclesPayProjectList);
/////////////
        List<ProjectDetailModel> mwProjectList = new ArrayList<>();
        mwProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_proceedings),
                        context.getResources().getString(R.string.project_mw_proceedings))
        );
        mwProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_descriptions),
                        context.getResources().getString(R.string.project_mw_descriptions))
        );
        mwProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_features),
                        context.getResources().getString(R.string.project_mw_features))
        );
        projectDetails.put(context.getResources().getString(R.string.project_mw_header),mwProjectList);
/////////////
        List<ProjectDetailModel> anypalProjectList = new ArrayList<>();
        anypalProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_proceedings),
                        context.getResources().getString(R.string.project_anypal_proceedings))
        );
        anypalProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_descriptions),
                        context.getResources().getString(R.string.project_anypal_descriptions))
        );
        anypalProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_features),
                        context.getResources().getString(R.string.project_anypal_features))
        );
        projectDetails.put(context.getResources().getString(R.string.project_anypal_header),anypalProjectList);
////////////
        List<ProjectDetailModel> shanoProjectList = new ArrayList<>();
        shanoProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_proceedings),
                        context.getResources().getString(R.string.project_shano_proceedings))
        );
        shanoProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_descriptions),
                        context.getResources().getString(R.string.project_shano_descriptions))
        );
        shanoProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_features),
                        context.getResources().getString(R.string.project_shano_features))
        );
        projectDetails.put(context.getResources().getString(R.string.project_shano_header),shanoProjectList);
////////////
        List<ProjectDetailModel> sicProjectList = new ArrayList<>();
        sicProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_proceedings),
                        context.getResources().getString(R.string.project_sic_proceedings))
        );
        sicProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_descriptions),
                        context.getResources().getString(R.string.project_sic_descriptions))
        );
        sicProjectList.add(
                new ProjectDetailModel(context.getResources().getString(R.string.project_features),
                        context.getResources().getString(R.string.project_sic_features))
        );
        projectDetails.put(context.getResources().getString(R.string.project_sic_header),sicProjectList);
        return projectDetails;
    }

}
