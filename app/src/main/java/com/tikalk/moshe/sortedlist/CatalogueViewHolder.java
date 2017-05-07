package com.tikalk.moshe.sortedlist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Product catalogue view holder.
 *
 * @author Moshe Waisberg
 */
public class CatalogueViewHolder extends RecyclerView.ViewHolder {

    @Nullable
    final ImageView imageView;

    public CatalogueViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    public void bind(Product product) {
        itemView.setTag(product);

        Context context = imageView.getContext();
        Glide.with(context)
                .load(product.getImageUrl())
                .asBitmap()
                .dontAnimate()
                .into(imageView);
    }
}
