package com.android.a98recyclerviewanimation.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.a98recyclerviewanimation.R;

import java.util.ArrayList;
import java.util.List;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    List<Integer> dataSource;

    public SimpleRecyclerAdapter() {
        dataSource = new ArrayList<>();
        for (int i=0;i<=10;i++){
            dataSource.add(i);
        }
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item,parent,false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.textView.setText(String.valueOf(dataSource.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
