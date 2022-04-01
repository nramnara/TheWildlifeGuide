package com.example.thewildlifeguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImagePage_Adapter extends RecyclerView.Adapter<ImagePage_Adapter.ViewHolder> {

    //initialize list of names and images,inflater and the listener
    List<String> animalNames;
    List<Drawable> images;
    LayoutInflater inflater;
    private RecyclerViewClickListener listener;


    //constructor
    public ImagePage_Adapter(Context ctx, List<String> animalNames, List<Drawable> images, RecyclerViewClickListener listener){
        this.animalNames = animalNames;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.listener = listener;
    }

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
