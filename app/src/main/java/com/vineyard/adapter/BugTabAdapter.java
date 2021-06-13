package com.vineyard.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.vineyard.fragments.BugFragmentMildew;
import com.vineyard.fragments.BugFragmentOidium;


public class BugTabAdapter extends FragmentPagerAdapter {

    private int allPagers;

    public BugTabAdapter(FragmentManager fm, int allPagers) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.allPagers = allPagers;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BugFragmentMildew();
            case 1:
                return new BugFragmentOidium();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return allPagers;
    }

}
