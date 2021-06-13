package com.vineyard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.vineyard.R;
import com.vineyard.adapter.StructureRecyclerAdapter;
import com.vineyard.models.StructureModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ch
 * @date 2020/1/11 11:08
 * @desc
 */
public class StructureDemoFragment extends Fragment {


    private TextView tvDemo;
    private String title;
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private List<StructureModel> modelList;
    private StructureRecyclerAdapter adapter;
    private Query query;

    public StructureDemoFragment(String title) {
        this.title = title;
    }

    public StructureDemoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grapes_fragment, container, false);


        int numColumns = getResources().getInteger(R.integer.search_results_columns);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), numColumns);


        //LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // 1. Увесь список об’єктів
       // databaseReference = FirebaseDatabase.getInstance().getReference().child("grapes/uk");

        query = FirebaseDatabase
                .getInstance()
                .getReference("formation")
                //.child("ru")
                .orderByChild("structure")
                .equalTo("гюйо");

        query.addListenerForSingleValueEvent(valueEventListener);

        // databaseReference = FirebaseDatabase.getInstance().getReference().child("grapes").child("ru");
//        databaseReference.addListenerForSingleValueEvent(valueEventListener);
  //      databaseReference.keepSynced(true);

        return view;
    }

    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            modelList = new ArrayList<>();
            if (dataSnapshot.exists()) {
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    StructureModel grapes = productSnapshot.getValue(StructureModel.class);
                    modelList.add(grapes);

                    // Сортую об’єкти за "Id"
                    Collections.sort(modelList, new Comparator<StructureModel>() {
                        @Override
                        public int compare(StructureModel o1, StructureModel o2) {
                            return Integer.compare(o1.getId(), o2.getId());
                        }
                    });
                }

                if (getActivity() != null) {
                    adapter = new StructureRecyclerAdapter(getActivity(), modelList);
                    recyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();
                }
//                adapter = new RecyclerAdapter(getContext(), modelList);
//                recyclerView.setAdapter(adapter);
//
                //          adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getContext(), "Opsss.... Щось не так", Toast.LENGTH_SHORT).show();
        }
    };
}
