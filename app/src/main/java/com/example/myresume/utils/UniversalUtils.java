package com.example.myresume.utils;

import android.content.Context;

import com.example.myresume.R;
import com.example.myresume.models.ProjectDetailModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UniversalUtils {
    public static final int MAIN_ACT_HEADER_IMAGE_URL = R.drawable.nav_menu_header_bg_blue;
    public static final int MAIN_ACT_MY_IMAGE_URL = R.drawable.reza;
    public static final int HIGHLIGHTS_IMAGE_URL = R.drawable.ic_person_pin_40;
    public static final int PROFESSIONAL_DEV_EXP_IMAGE_URL = R.drawable.icons8_android_os_96_white;
    public static final int PERSONAL_DETAIL_IMAGE_URL = R.drawable.icons8_checked_identification_documents_100_white;
    public static final int EDUCATIONS_IMAGE_URL = R.drawable.icons8_education_64_white;
    public static final int OTHER_EXP_SKILLS_IMAGE_URL = R.drawable.icons8_world_256_white;
    public static final int CERTIFICATIONS_IMAGE_URL = R.drawable.icons8_certificate_64_white;


    public static final int HIGHLIGHTS = 0;
    public static final int PROFESSIONAL_DEV_EXPERIENCES = 1;
    public static final int EDUCATIONS = 2;
    public static final int OTHER_EXP_SKILLS = 3;
    public static final int CERTIFICATIONS = 4;
    public static final int PERSONAL_DETAIL = 5;

    public static final int [] SECTIONS = {HIGHLIGHTS, PROFESSIONAL_DEV_EXPERIENCES,
            EDUCATIONS, OTHER_EXP_SKILLS,
            CERTIFICATIONS, PERSONAL_DETAIL};

    public static final String OTHER_TAG= "-1";
    public static final String CERTIFICATION_TAG_1= "0";
    public static final String CERTIFICATION_TAG_2= "1";
    public static final String CERTIFICATION_TAG_3= "2";
    public static final String CERTIFICATION_TAG_4= "3";

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
