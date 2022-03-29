package com.example.thewildlifeguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchPage_recyclerAdapter extends RecyclerView.Adapter<SearchPage_recyclerAdapter.MyViewHolder> implements Filterable {

    private ArrayList<String> animalList;
    private ArrayList<String> animalListFull;
    private searchpage_RecyclerViewClickListener listener;

    public SearchPage_recyclerAdapter (ArrayList<String> animalList, searchpage_RecyclerViewClickListener listener) {
        this.animalList = animalList;
        this.animalListFull = new ArrayList<>(animalList);
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
        String animalName = animalList.get(position).toUpperCase();
        holder.animalnameTxt.setText(animalName);
        holder.animalnameTxt.setTextSize(12);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public interface searchpage_RecyclerViewClickListener {
        void onClick(View view,int position);
    }

    //--------------------------------------------

    @Override
    public Filter getFilter() {
        return animalFilter;
    }

    private Filter animalFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(animalListFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (String i: animalListFull) {
                    if (i.toLowerCase().contains(filterPattern)) {
                        filteredList.add(i);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            animalList.clear();
            animalList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
