package com.example.myresume.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myresume.R;
import com.example.myresume.databinding.GlideBindingAdapter;
import com.example.myresume.utils.ZoomInZoomOut;

public class ImageViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String [] imageUrls;
    private String [] headers;

    public ImageViewPagerAdapter (Context context, String [] imageUrls, String [] headers){
        this.context = context;
        this.imageUrls = imageUrls;
        this.headers = headers;
    }
/*  @Override
    public int getCount() {return imageUrls.length;}
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {return view == object;}
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        GlideBindingAdapter.setImageResource(imageView, imageUrls [position]);
        container.addView(imageView);
        return imageView;}
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {container.removeView((View) object);}*/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_view_pager, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        //new ZoomInZoomOut(viewHolder.image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        GlideBindingAdapter.setImageResource(viewHolder.image, imageUrls [position]);
        viewHolder.txtHeader.setText(headers [position]);
    }

    @Override
    public int getItemCount() {
        return imageUrls.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtHeader;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_image_view_pager_body);
            txtHeader = itemView.findViewById(R.id.txt_image_view_pager_header);
        }
    }
}
