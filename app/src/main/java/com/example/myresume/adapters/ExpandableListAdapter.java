package com.example.myresume.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myresume.R;
import com.example.myresume.databinding.LayoutProjectsBinding;
import com.example.myresume.databinding.LayoutProjectsDetailBinding;
import com.example.myresume.generated.callback.OnClickListener;
import com.example.myresume.models.ProjectDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private Map<String, List<ProjectDetailModel>> projectDetail;
    private List<String> projects;

    private LayoutProjectsBinding mlBinding;
    private LayoutProjectsDetailBinding mldBinding;

    public ExpandableListAdapter(Context context, Map<String, List<ProjectDetailModel>> projectDetail) {
        this.context = context;
        this.projectDetail = projectDetail;
        projects = new ArrayList<>(projectDetail.keySet());
    }

    @Override
    public int getGroupCount() {
        return projects.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return Objects.requireNonNull(projectDetail.get(projects.get(i))).size();
    }

    @Override
    public Object getGroup(int i) {
        return projects.get(i);
    }

    @Override
    public ProjectDetailModel getChild(int i, int i1) {
        return projectDetail.get(projects.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
/*        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mlBinding = DataBindingUtil.inflate(inflater, R.layout.layout_projects, viewGroup, false);
            view = mlBinding.getRoot();
        }
        mlBinding.txtProjectName.setText((String) getGroup(i));
        mlBinding.txtProjectName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return false;
            }
        });*/

        final ViewHolder viewHolder;

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_projects, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtHeader.setText(getGroup(i).toString());
        viewHolder.btnImage.setFocusable(false);
        viewHolder.btnDownload.setFocusable(false);
        //viewHolder.btnImage.setOnClickListener(new OnClickListener());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
/*        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mldBinding = DataBindingUtil.inflate(inflater, R.layout.layout_projects_detail, viewGroup, false);
            view = mldBinding.getRoot();
        }
        mldBinding.txtProjectDetailHeader.getChild(i, i1).getDetailHeader()
        mldBinding.txtProjectDetail.setText(getChild(i, i1).getDetail());
        return view;*/

        final ChildViewHolder childViewHolder;

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.layout_projects_detail, viewGroup, false);
            childViewHolder = new ChildViewHolder(view);
            view.setTag(childViewHolder);
        }else{
            childViewHolder = (ChildViewHolder) view.getTag();
        }
        childViewHolder.txtProjectDetailHeader.setText(getChild(i, i1).getDetailHeader());
        childViewHolder.txtProjectDetail.setText(getChild(i, i1).getDetail());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtHeader;
        public ImageButton btnDownload, btnImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHeader = itemView.findViewById(R.id.txt_project_name);
            btnDownload = itemView.findViewById(R.id.btn_download);
            btnImage = itemView.findViewById(R.id.btn_show_image);
        }
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder{
        public TextView txtProjectDetailHeader, txtProjectDetail;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProjectDetailHeader = itemView.findViewById(R.id.txt_project_detail_header);
            txtProjectDetail = itemView.findViewById(R.id.txt_project_detail);
        }
    }
}
