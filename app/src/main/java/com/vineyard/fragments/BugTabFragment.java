package com.vineyard.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.vineyard.adapter.BugTabAdapter;
import com.vineyard.R;

import java.util.Objects;


public class BugTabFragment extends Fragment {

    @SuppressLint("UseRequireInsteadOfGet")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.bug_tab_fragment, container, false);

        Objects.requireNonNull(getActivity()).setTitle(R.string.menu_bug);

        TabLayout tabLayout = root.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_name_mildew));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_name_oidium));

        final ViewPager viewPager = root.findViewById(R.id.vpTablayout);
        BugTabAdapter tabAdapter = new BugTabAdapter(getChildFragmentManager(), 2);

        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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

        return root;
    }















}