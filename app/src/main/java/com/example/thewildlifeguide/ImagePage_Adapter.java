package com.example.thewildlifeguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ImagePage_Adapter extends RecyclerView.Adapter<ImagePage_Adapter.ViewHolder> implements Filterable {

    //initialize list of names and images,inflater and the listener
    List<String> animalNames;
    List<Drawable> images;
    LayoutInflater inflater;
    private RecyclerViewClickListener listener;
    private List<String> animalList;
    private ArrayList<String> animalListFull;

    //constructor
    public ImagePage_Adapter(Context ctx, List<String> animalNames, List<Drawable> images, RecyclerViewClickListener listener){
        this.animalNames = animalNames;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.listener = listener;
        this.animalList = animalNames;
        this.animalListFull = new ArrayList<>(animalNames);
    }

    @Override
    public Filter getFilter() {
        return animalFilter;
    }

    private Filter animalFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(animalListFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (String item: animalListFull) {
                    if (item.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            animalList.clear();
            animalList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    //set variables to the image and textview for each animal
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView animalName;
        ImageView animalPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            animalName = itemView.findViewById(R.id.textView2);
            animalPic = itemView.findViewById(R.id.imageView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    //set the grid layout
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    //assign values to the variables initialized in 'public class Viewholder...'
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.animalName.setText(animalNames.get(position));
        holder.animalPic.setImageDrawable(images.get(position));

    }

    @Override
    public int getItemCount() {
        return animalNames.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v,int position);
    }
}
