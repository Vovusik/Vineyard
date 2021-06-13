package com.vineyard.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.vineyard.R;
import com.vineyard.models.PreparationDialogModel;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private List<PreparationDialogModel> preparationDialogModelList;

    public SimpleAdapter(Context mcontext, List<PreparationDialogModel> laboratoryModelList) {
        this.context = mcontext;
        this.preparationDialogModelList = laboratoryModelList;
    }
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.preparation_dialog_row, null);
        return new ViewHolder(view);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        holder.shorter_dialog.setText(preparationDialogModelList.get(position).getShorter());
        holder.longer_dialog.setText(preparationDialogModelList.get(position).getLonger());

        if (position % 2 == 1) {
            holder.layout_content_view.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.windowBackground, null));
        } else {
            holder.layout_content_view.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.rowBackground, null));

        }
    }

    @Override
    public int getItemCount() {
        if (preparationDialogModelList.size() > 0)
            return preparationDialogModelList.size();
        else
            return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        MaterialTextView shorter_dialog, longer_dialog;
        LinearLayoutCompat layout_content_view;

        ViewHolder(View itemView) {

            super(itemView);
            shorter_dialog = itemView.findViewById(R.id.shorter_dialog);
            longer_dialog = itemView.findViewById(R.id.longer_dialog);

            layout_content_view = itemView.findViewById(R.id.preparation_layout_content_view);
        }
    }

}
