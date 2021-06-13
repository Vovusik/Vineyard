package com.vineyard.adapter;

import android.content.Context;

import com.vineyard.PreperationViewGroup;
import com.vineyard.R;
import com.vineyard.models.PreparationModel;

import java.util.Arrays;
import java.util.List;

public class PreparationAdapter extends PreparationAdapterFactory<
        String, PreperationViewGroup,
        String, PreperationViewGroup,
        PreparationModel,
        PreperationViewGroup,
        PreperationViewGroup,
        PreperationViewGroup> {
    List<PreparationModel> body;
    private Context context;

    public PreparationAdapter(Context context, List<PreparationModel> preparatyModelList) {
        super(context);
        this.context = context;
        this.body = preparatyModelList;
    }


    @Override
    protected PreperationViewGroup inflateFirstHeader() {
        return new PreperationViewGroup(context);
    }

    @Override
    protected PreperationViewGroup inflateHeader() {
        return new PreperationViewGroup(context);
    }

    @Override
    protected PreperationViewGroup inflateFirstBody() {
        return new PreperationViewGroup(context);
    }

    @Override
    protected PreperationViewGroup inflateBody() {
        return new PreperationViewGroup(context);
    }

    @Override
    protected PreperationViewGroup inflateSection() {
        return new PreperationViewGroup(context);
    }

    @Override
    protected List<Integer> getHeaderWidths() {
        Integer[] witdhs = {
                (int) context.getResources().getDimension(R.dimen._120dp),
                (int) context.getResources().getDimension(R.dimen._110dp),
                (int) context.getResources().getDimension(R.dimen._120dp),
                (int) context.getResources().getDimension(R.dimen._150dp),
                (int) context.getResources().getDimension(R.dimen._130dp),
                (int) context.getResources().getDimension(R.dimen._160dp),
        };

        return Arrays.asList(witdhs);
    }

    @Override
    protected int getHeaderHeight() {
        return (int) context.getResources().getDimension(R.dimen._55dp);
    }

    @Override
    protected int getSectionHeight() {
        return (int) context.getResources().getDimension(R.dimen._30dp);
    }

    @Override
    protected int getBodyHeight() {
        return (int) context.getResources().getDimension(R.dimen._45dp);
    }

    @Override
    protected boolean isSection(List<PreparationModel> items, int row) {
        return items.get(row).isSection();
    }
}
