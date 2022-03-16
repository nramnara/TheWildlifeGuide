package com.example.eecs1022project_thewildlifeguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchPage_recyclerAdapter extends RecyclerView.Adapter<SearchPage_recyclerAdapter.MyViewHolder>{

    private ArrayList<animal> animalsList;
    private searchpage_RecyclerViewClickListener listener;

    public SearchPage_recyclerAdapter (ArrayList<animal> animalsList, searchpage_RecyclerViewClickListener listener) {
        this.animalsList = animalsList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView animalnameTxt;

        public MyViewHolder(final View view){
            super(view);
            animalnameTxt = view.findViewById(R.id.animalName);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public SearchPage_recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_animals,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchPage_recyclerAdapter.MyViewHolder holder, int position) {
        String animalName = animalsList.get(position).getAnimalName();
        holder.animalnameTxt.setText(animalName);
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public interface searchpage_RecyclerViewClickListener {
        void onClick(View view,int position);
    }
}
