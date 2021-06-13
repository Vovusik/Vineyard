package com.vineyard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.vineyard.R;
import com.vineyard.models.BugModel;

import java.util.List;

public class BugPagerAdapter extends PagerAdapter {

    private List<BugModel> bugModelList;
    private LayoutInflater layoutInflater;

    public BugPagerAdapter(Context context, List<BugModel> dataObjectList) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.bugModelList = dataObjectList;
    }

    @Override
    public int getCount() {
        return bugModelList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.bug_pager_list_items, container, false);

        ImageView displayImage = view.findViewById(R.id.imageView);
        //displayImage.setImageResource(this.dataObjectList.get(position).getBugImage());
        Glide
                .with(container)
                .load("https://" + bugModelList.get(position).getBugImage())
                .into(displayImage);


        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}