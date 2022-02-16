package com.example.myresume.databinding;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myresume.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class GlideBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void setImageResource (ImageView view, int resourceId){
        Context context = view.getContext();
/*        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);*/
        Glide.with(context)
                //.setDefaultRequestOptions(options)
                .load(resourceId)
                .into(view);
    }

    public static void setImageResource (CircleImageView view, int resourceId){
        Context context = view.getContext();
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(resourceId)
                .into(view);
    }
}
