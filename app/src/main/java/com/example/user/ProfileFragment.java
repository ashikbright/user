package com.example.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    RecyclerView recyclerView;
   // DatabaseReference database;
    adapter myadapter;
    ArrayList<datamodel> dataholder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));

        FirebaseRecyclerOptions<datamodel> options=new FirebaseRecyclerOptions.Builder<datamodel>().setQuery(FirebaseDatabase.getInstance().getReference().child("users"),datamodel.class).build();

        //database=FirebaseDatabase.getInstance().getReference("users");
      //  recyclerView.setHasFixedSize(true);


       // dataholder=new ArrayList<>();
        myadapter=new adapter(options);
        recyclerView.setAdapter(myadapter);
       /* database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    datamodel dmodel=dataSnapshot.getValue(datamodel.class);
                    dataholder.add(dmodel);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        datamodel ob1=new datamodel(R.drawable.name,"Name","abcd",R.drawable.edit);
        dataholder.add(ob1);
        datamodel ob2=new datamodel(R.drawable.phone,"Mobile Number","9876543210",R.drawable.edit);
        dataholder.add(ob2);
        datamodel ob3=new datamodel(R.drawable.email,"Email","example@subdomain.domain",R.drawable.edit);
        dataholder.add(ob3);
        datamodel ob4=new datamodel(R.drawable.share,"Refer a Friend","",R.drawable.empty);
        dataholder.add(ob4);
        datamodel ob5=new datamodel(R.drawable.rate,"Rate Us","",R.drawable.empty);
        dataholder.add(ob5);
       //
        // recyclerView.setAdapter(new adapter(this, dataholder));*/

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        myadapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        myadapter.stopListening();
    }
}