package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ImageSearchPage extends AppCompatActivity {

    //initialize the recyclerView
    RecyclerView imageSearch;

    //initialize list containing the animal's names and their corresponding pics
    List<String> animalNames;
    List<Drawable> animalPics;


    //initialize adapter for imageSearch
    ImagePage_Adapter imagePageAdapter;


    //initialize listener for clicks
    private ImagePage_Adapter.RecyclerViewClickListener listener;

    //initialize image search buttons
    private Button textSearchButton;

    //initialize animal list
    private AnimalList list;
    private ArrayList<String> animalList;

    //initialize the search page recycler view and listener
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search_page);

        //-------------------------------------

        /* Hides the bar at the top of phone */
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Hides ActionBar at the top of the app */
        getSupportActionBar().hide();

        //-------------------------------------


        //set the array to animalsList
        list = new AnimalList(this);
        animalList = list.getListOfAnimals();

        imageSearch = findViewById(R.id.imageSearch_recyclerView);

        //populate the animal's names and pics lists
        animalNames = new ArrayList<>();
        animalPics = new ArrayList<>();

        animalNames.addAll(animalList);

        for (int i = 0; i < animalList.size();i++)
        {
            Animal currentAnimal = new Animal (this, animalList.get(i));
            animalPics.add(currentAnimal.getImage());
        }

        //when page is called,set the adapter using setAdapter()
        setAdapter();


        //set value to text search button
        textSearchButton = (Button) findViewById(R.id.textsearchButton);

        //set value to recyclerView
        recyclerView = findViewById(R.id.searchPage_recyclerView);


        //what to do when text search button is clicked
        textSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTextSearch();
            }
        });


    }

    private void setAdapter() {
        setOnclickListener();
        ImagePage_Adapter imagePageAdapter = new ImagePage_Adapter(this, animalNames, animalPics,listener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.VERTICAL,false);
        imageSearch.setLayoutManager(gridLayoutManager);
        imageSearch.setAdapter(imagePageAdapter);
    }

    private void setOnclickListener() {
        listener = new ImagePage_Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),InfoPage.class);
                intent.putExtra("animalName",animalList.get(position));
                intent.putExtra("whereFrom","imageSearch");
                startActivity(intent);
            }
        };
    }

    //take the user to the text search page
    public void openTextSearch(){
        Intent intent = new Intent(this,SearchPage.class);
        startActivity(intent);
    }
}