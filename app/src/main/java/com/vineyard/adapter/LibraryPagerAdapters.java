package com.vineyard.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vineyard.activity.PdfViewActivity;
import com.vineyard.R;
import com.vineyard.models.LibraryModel;

import java.util.List;

public class LibraryPagerAdapters extends RecyclerView.Adapter<LibraryPagerAdapters.SliderViewHolder> {

    private List<LibraryModel> sliderItems;
    private Context context;

    public LibraryPagerAdapters(Context context, List<LibraryModel> sliderItems) {
        this.context = context;
        this.sliderItems = sliderItems;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.library_slide_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageSlider);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   openPdfView(sliderItems.get(getLayoutPosition()).getId());
                }
            });
        }

        void setImage(LibraryModel sliderItem) {
            Glide
                    .with(itemView.getContext())
                    .load(sliderItem.getImage())
                    .fitCenter()
                    .into(imageView);
        }
    }

    private void openPdfView(int position) {
        Intent intent = new Intent(context, PdfViewActivity.class);
        intent.putExtra("File URL", sliderItems.get(position - 1).getLink());
        intent.putExtra ("File Name", sliderItems.get(position - 1) + "finalfinal.pdf");
        context.startActivity(intent);
    }
}
