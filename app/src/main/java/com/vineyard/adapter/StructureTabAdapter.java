package com.vineyard.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.vineyard.fragments.StructureDemoFragment;

import java.util.List;

/**
 * @author ch
 * @date 2020/1/13 18:10
 * @desc
 */
public class StructureTabAdapter extends FragmentStateAdapter {
    private List<String> titles;

    public StructureTabAdapter(@NonNull FragmentActivity fragmentActivity, List<String> titles) {
        super(fragmentActivity);
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new StructureDemoFragment();
            case 1:
                return new StructureDemoFragment();
            case 2:
                return new StructureDemoFragment();

            case 3:
                return new StructureDemoFragment();
            case 4:
                return new StructureDemoFragment();
            case 5:
                return new StructureDemoFragment();
        }
        return new StructureDemoFragment();

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}
