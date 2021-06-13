package com.vineyard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.vineyard.R;
import com.vineyard.adapter.LibraryPagerAdapters;
import com.vineyard.helper.PagerTransformer;
import com.vineyard.models.LibraryModel;

import java.util.List;

public class LibraryFragment extends Fragment  {

    private List<LibraryModel> libraryModelList;
    private ViewPager2 viewPager2;
    private TextView titleLibrary, authorLibrary;
    private LinearLayout fragmentContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.library_fragment,
                container, false);

//        Toolbar toolbar = view.findViewById(R.id.toolbar);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setSupportActionBar(toolbar);
//        activity.getSupportActionBar().setTitle(R.string.menu_library);

        getActivity().setTitle(R.string.menu_library);

        viewPager2 = view.findViewById(R.id.viewPagerLibrary);
        titleLibrary = view.findViewById(R.id.titleLibrary);
        authorLibrary = view.findViewById(R.id.authorLibrary);
        fragmentContainer = view.findViewById(R.id.container);

        libraryModelList = LibraryModel.getLibrary();
        LibraryPagerAdapters kitchenPagerAdapter = new LibraryPagerAdapters(getContext(), libraryModelList);
        viewPager2.setAdapter(kitchenPagerAdapter);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setPageTransformer(new PagerTransformer());
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                displayMetaInfo(position);
            }
        });

        return view;
    }

    private void displayMetaInfo(int position) {
        titleLibrary.setText(libraryModelList.get(position).getTitle());
        authorLibrary.setText(libraryModelList.get(position).getAuthor());

    }
}
