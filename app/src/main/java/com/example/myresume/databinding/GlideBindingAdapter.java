package com.example.myresume.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.myresume.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class GlideBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void setImageResource (ImageView view, int resourceId){
        Context context = view.getContext();
/*        RequestOptions options = new RequestOptions()
                .centerInside()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);*/
        Glide.with(context)
                .load(resourceId)
                .into(view);
    }


    @BindingAdapter("imageCircleUrl")
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

    @BindingAdapter("iconUrl")
    public static void setImageIcon (ImageView view, int resourceId){
        Context context = view.getContext();
        RequestOptions options = new RequestOptions()
                .fitCenter()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(resourceId)
                .into(view);
    }

    public static void setImageResource (ImageView view, String resourceUrl){
        Context context = view.getContext();
        RequestOptions options = new RequestOptions()
                .centerInside()
                .placeholder(R.drawable.ic_adb_40)
                .error(R.mipmap.ic_launcher);
        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(resourceUrl)
                .skipMemoryCache(true)
                .into(view);
    }


}
