package com.example.huy.intentfilepermission;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<String> mImages;
    private Context context;
    LayoutInflater layoutInflater;

    public ImageAdapter(Context context, List<String> imageDatas) {
        this.mImages = imageDatas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(mImages.get(i))
                .into(viewHolder.image_item);
    }

    @Override
    public int getItemCount() {
        return mImages!=null ? mImages.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
        }
    }
}
