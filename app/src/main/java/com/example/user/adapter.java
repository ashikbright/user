package com.example.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class adapter extends FirebaseRecyclerAdapter<datamodel,adapter.myviewholder> {

    public adapter(@NonNull FirebaseRecyclerOptions<datamodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull datamodel model) {
        holder.img.setImageResource(model.getImage());
        holder.header.setText(model.getHeader());
        holder.nm.setText(model.getNm());
        holder.edit.setImageResource(model.getEdit());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return  new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img,edit;
        TextView header,nm;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img1);
            header=itemView.findViewById(R.id.t1);
            nm=itemView.findViewById(R.id.t2);
            edit=itemView.findViewById(R.id.editt);
        }
    }


}
