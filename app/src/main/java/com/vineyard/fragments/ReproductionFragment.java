package com.vineyard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vineyard.R;
import com.vineyard.adapter.ReproductionPagerAdapters;
import com.vineyard.helper.FadeOutTransformation;
import com.vineyard.models.ReproductionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;


public class ReproductionFragment extends Fragment {

    private List<ReproductionModel> reproductionModelList;
    private TextView titleReproduction, descriptionReproduction;
    private ViewPager2 viewPager;
    private CircleIndicator3 indicator;
    private int mLocationPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reproduction_fragment,
                container, false);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("reproduction");
        databaseReference.addListenerForSingleValueEvent(valueEventListener);
        databaseReference.keepSynced(true);

        getActivity().setTitle(R.string.menu_reproduction);

        viewPager = view.findViewById(R.id.view_pager_reproduction);
        titleReproduction = view.findViewById(R.id.title_reproduction);
        descriptionReproduction = view.findViewById(R.id.description_reproduction);
        indicator = view.findViewById(R.id.indicator);

        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setPageTransformer(new FadeOutTransformation());
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                displayMetaInfo(position);
            }
        });

        return view;
    }

    private void displayMetaInfo(int position) {
        titleReproduction.setText(reproductionModelList.get(position).getReproductionTitle());
        descriptionReproduction.setText(reproductionModelList.get(position).getReproductionDescription());

        Animation slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        descriptionReproduction.startAnimation(slideDown);
        titleReproduction.startAnimation(slideDown);
    }

    private final ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            reproductionModelList = new ArrayList<>();
            if (dataSnapshot.exists()) {
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    ReproductionModel library = productSnapshot.getValue(ReproductionModel.class);
                    reproductionModelList.add(library);

                    // Сортую об’єкти за алфавітом
                    //Collections.sort(reproductionModelList, (o1, o2) -> o1.getReproductionTitle().compareTo(o2.getReproductionTitle()));

                    // Сортую об’єкти за "Id"
                    Collections.sort(reproductionModelList, new Comparator<ReproductionModel>() {
                        @Override
                        public int compare(ReproductionModel o1, ReproductionModel o2) {
                            return Integer.compare(o1.getId(), o2.getId());
                        }
                    });
                }

                ReproductionPagerAdapters reproductionPagerAdapter = new ReproductionPagerAdapters(
                        getContext(), reproductionModelList);
                viewPager.setAdapter(reproductionPagerAdapter);
                indicator.setViewPager(viewPager);

                reproductionPagerAdapter.notifyDataSetChanged();

                displayMetaInfo(mLocationPosition);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getContext(), "Opsss.... Щось не так", Toast.LENGTH_SHORT).show();
        }
    };
}
