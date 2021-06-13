package com.vineyard;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vineyard.adapter.SimpleAdapter;
import com.vineyard.models.PreparationDialogModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PreparationDialog extends BottomSheetDialog {

    DatabaseReference databaseReference;
    private static List<PreparationDialogModel> preparationDialogModels = new ArrayList<>();

    private RecyclerView recyclerView;
    SimpleAdapter adapter;

    private PreparationDialog(@NonNull Context context) {
        super(context);

        BottomSheetDialog dialog = new BottomSheetDialog(context, R.style.SheetDialog);

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.preparation_dialog, null);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("preparation");
        databaseReference.addListenerForSingleValueEvent(valueEventListener);
        databaseReference.keepSynced(true);

        //preparationDialogModels = PreparationDialogModel.getPreparatyDialog();

        recyclerView = view.findViewById(R.id.preparation_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new SimpleAdapter(getContext(), preparationDialogModels);
        recyclerView.setAdapter(adapter);
       // recyclerView.setAdapter(new SimpleAdapter(preparationDialogModels));

//        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
//                DividerItemDecoration.VERTICAL));

        TextView textView = view.findViewById(R.id.preparation_dismiss);
        textView.setOnClickListener(v -> dialog.dismiss());

        dialog.setContentView(view);
        dialog.show();


    }


    public static void show(Context context) {
        new PreparationDialog(context);
    }


//
//        @Override
//        public int getItemCount() {
//            if (preparationDialogModelList.size() > 0)
//                return preparationDialogModelList.size();
//            else
//                return 0;
//        }
//    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            preparationDialogModels = new ArrayList<>();
            if (dataSnapshot.exists()) {
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    PreparationDialogModel preparation = productSnapshot.getValue(PreparationDialogModel.class);
                    preparationDialogModels.add(preparation);

                    // Сортую об’єкти за алфавітом
                    Collections.sort(preparationDialogModels, new Comparator< PreparationDialogModel>() {
                        @Override
                        public int compare( PreparationDialogModel o1,  PreparationDialogModel o2) {
                            return o1.getShorter().compareTo(o2.getShorter());
                        }
                    });
                }
                adapter = new SimpleAdapter(getContext(), preparationDialogModels);
                recyclerView.setAdapter(adapter);

                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getContext(), "Opsss.... Щось не так", Toast.LENGTH_SHORT).show();
        }
    };
}
