package com.vineyard.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.vineyard.adapter.BugPagerAdapter;
import com.vineyard.R;
import com.vineyard.helper.ParallaxPageTransformer;
import com.vineyard.models.BugModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator;


public class BugFragmentMildew extends Fragment {

    private TextView textDescription, textSings, textPreparation;
    private List<BugModel> bugModelList;
    private ViewPager viewPager;
    private int mLocationPosition;
    private CircleIndicator indicator;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bug_fragment, container, false);

        //.child("ru")
        Query query = FirebaseDatabase
                .getInstance()
                .getReference("bug")
                //.child("ru")
                .orderByChild("bug")
                .equalTo("мілдью");
        query.addListenerForSingleValueEvent(valueEventListener);

        textDescription = view.findViewById(R.id.textDescription);
        textSings = view.findViewById(R.id.textSings);
        textPreparation = view.findViewById(R.id.textPreparation);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewpager);
        indicator = view.findViewById(R.id.indicator);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ParallaxPageTransformer pageTransformer = new ParallaxPageTransformer();
        ParallaxPageTransformer.ParallaxTransformInformation transformInformation = new ParallaxPageTransformer
                .ParallaxTransformInformation(R.id.imageView, 2, 2);
        pageTransformer.addViewToParallax(transformInformation);
        viewPager.setPageTransformer(true, pageTransformer);

        viewPager.setCurrentItem(mLocationPosition, false);

        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Позвоните, когда начнется событие прокрутки, и перейдите на эту страницу
            }

            @Override
            public void onPageSelected(int position) {
                // называется, когда выбрана страница
                displayMetaInfo(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // называется, когда меняется статус Scoll
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void displayMetaInfo(int position) {

        textDescription.setText(bugModelList.get(0).getBugDescription());
        textSings.setText(bugModelList.get(0).getBugSings());
        textPreparation.setText(bugModelList.get(0).getBugPreparation());

        Animation slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.nothing);
        textDescription.startAnimation(slideDown);
        textSings.startAnimation(slideDown);
        textPreparation.startAnimation(slideDown);
    }

    private final ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            bugModelList = new ArrayList<>();
            if (dataSnapshot.exists()) {
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    BugModel bug = productSnapshot.getValue(BugModel.class);
                    bugModelList.add(bug);

                    // Сортую об’єкти за алфавітом
                    //Collections.sort(reproductionModelList, (o1, o2) -> o1.getReproductionTitle().compareTo(o2.getReproductionTitle()));

                    // Сортую об’єкти за "Id"
                    Collections.sort(bugModelList, new Comparator<BugModel>() {
                        @Override
                        public int compare(BugModel o1, BugModel o2) {
                            return Integer.compare(o1.getId(), o2.getId());
                        }
                    });
                }

                @SuppressLint("UseRequireInsteadOfGet") BugPagerAdapter bugPagerAdapter = new BugPagerAdapter(
                        Objects.requireNonNull(getActivity()), bugModelList);

                viewPager.setAdapter(bugPagerAdapter);

                indicator.setViewPager(viewPager);

                bugPagerAdapter.notifyDataSetChanged();

                displayMetaInfo(mLocationPosition);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getContext(), "Opsss.... Щось не так", Toast.LENGTH_SHORT).show();
        }
    };
}
