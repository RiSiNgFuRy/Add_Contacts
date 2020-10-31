package com.project_work.fragmentswithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> people;
    ItemSelected activity;
    interface ItemSelected
    {
        void onItemClicked(int index);
    }
    public PersonAdapter(Context context, ArrayList<Person> list)
    {
        people=list;
        activity=(ItemSelected) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView phn_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phn_id=itemView.findViewById(R.id.phn_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position){
        holder.itemView.setTag(people.get(position));
        holder.phn_id.setText(people.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
