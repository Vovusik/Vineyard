package com.vineyard.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.vineyard.PreparationDialog;
import com.vineyard.PreparationHeader;
import com.vineyard.R;


public class PreparationFragment extends Fragment {

    private TableFixHeaders tableFixHeaders;
    private PreparationFixHeaders preparatyFixHeaders;

    public PreparationFragment() {
        // Обязательный пустой публичный конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.preparation_fragment,
                container, false);
        setHasOptionsMenu(true);

        requireActivity().setTitle(R.string.menu_preparation);



        tableFixHeaders = view.findViewById(R.id.tablefixheaders);
        preparatyFixHeaders = new PreparationFixHeaders(getContext());

        createTable();

        //FloatingActionButton mFab = view.findViewById(R.id.fab);
       // mFab.setOnClickListener(this);

        return view;
    }

    private void createTable() {
        tableFixHeaders.setAdapter(preparatyFixHeaders.getAdapter());
    }



    public static class PreparationFixHeaders {
        private final Context context;

        PreparationFixHeaders(Context context) {
            this.context = context;
        }

        BaseTableAdapter getAdapter() {
            return new PreparationHeader(context).getInstance();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // First clear current all the menu items
        menu.clear();

        // Add the new menu items
        inflater.inflate(R.menu.menu_preparation, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.button_inform) {
            PreparationDialog.show(getContext());
        }
        return (super.onOptionsItemSelected(item));
    }
}