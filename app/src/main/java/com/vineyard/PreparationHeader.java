package com.vineyard;

import android.content.Context;
import android.widget.Toast;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.vineyard.adapter.PreparationAdapter;
import com.vineyard.models.PreparationModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PreparationHeader {

    private Context context;
    List<PreparationModel> preparationModels = new ArrayList<>();
    DatabaseReference databaseReference;
    private PreparationAdapter adapter;

    public PreparationHeader(Context context) {
        this.context = context;
    }

    public BaseTableAdapter getInstance() {

        preparationModels = PreparationModel.getPreparaty();

//        databaseReference = FirebaseDatabase.getInstance().getReference().child("preparationMain");
//        databaseReference.addListenerForSingleValueEvent(valueEventListener);
//        databaseReference.keepSynced(true);

        adapter = new PreparationAdapter(context, preparationModels);
        adapter.setFirstHeader((String) context.getResources().getText(R.string.nazva_preparatu));
        adapter.setHeader(getHeader());
        adapter.setFirstBody(preparationModels);
        adapter.setBody(preparationModels);
        // adapter.setSection(preparatyModelList);

        return adapter;
    }

    private List<String> getHeader() {

        final String[] headers = {
                (String) context.getResources().getText(R.string.spektr_dii),
                (String) context.getResources().getText(R.string.virobnyk),
                (String) context.getResources().getText(R.string.kratnist_zastosuvannya),
                (String) context.getResources().getText(R.string.stroky_do_spogivannya),
                (String) context.getResources().getText(R.string.diucha_rechovina),
        };

        return Arrays.asList(headers);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            preparationModels = new ArrayList<>();
            if (dataSnapshot.exists()) {
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    PreparationModel preparation = productSnapshot.getValue(PreparationModel.class);
                    preparationModels.add(preparation);

                    // Сортую об’єкти за алфавітом
                    Collections.sort(preparationModels, new Comparator<PreparationModel>() {
                        @Override
                        public int compare(PreparationModel o1, PreparationModel o2) {
                            return o1.getPreparation().compareTo(o2.getPreparation());
                        }
                    });
                }

                adapter = new PreparationAdapter(context, preparationModels);
//                adapter.setFirstHeader((String) context.getResources().getText(R.string.nazva_preparatu));
//                adapter.setHeader(getHeader());
//                adapter.setFirstBody(preparatyModelList);
//                adapter.setBody(preparatyModelList);
//                adapter.setSection(preparatyModelList);

                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(context, "Opsss.... Щось не так", Toast.LENGTH_SHORT).show();
        }
    };

}
