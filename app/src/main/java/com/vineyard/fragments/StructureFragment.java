package com.vineyard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.vineyard.R;
import com.vineyard.adapter.StructureTabAdapter;


import java.util.ArrayList;
import java.util.List;

public class StructureFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private List<String> titles;
    private TabLayoutMediator tabLayoutMediator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.structure_tab_fragment, container, false);

        getActivity().setTitle(R.string.menu_structure);

        tabLayout = root.findViewById(R.id.tabLayout);
        viewPager = root.findViewById(R.id.vpTablayout);

        titles = new ArrayList<>();
        titles.add("Будова");
        titles.add("Посадка");
        titles.add("Гюйо");
        titles.add("Будова");
        titles.add("Посадка");
        titles.add("Гюйо");

        StructureTabAdapter tabAdapter = new StructureTabAdapter(getActivity(), titles);
        viewPager.setAdapter(tabAdapter);

        tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        });
        tabLayoutMediator.attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return root;
    }

    @Override
    public void onDestroy() {
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
        super.onDestroy();
    }
}