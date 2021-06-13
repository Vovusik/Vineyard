package com.vineyard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vineyard.R;
import com.vineyard.models.ReproductionModel;

import java.util.List;

public class ReproductionPagerAdapters extends RecyclerView.Adapter<ReproductionPagerAdapters.SliderViewHolder> {

    private List<ReproductionModel> sliderItems;

    public ReproductionPagerAdapters(Context context, List<ReproductionModel> sliderItems) {
        this.sliderItems = sliderItems;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reproduction_slide_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_slider);
        }

        void setImage(ReproductionModel sliderItem) {
            Glide
                    .with(itemView.getContext())
                    .load(sliderItem.getReproductionImage())
                    .fitCenter()
                    .into(imageView);
        }
    }
}
