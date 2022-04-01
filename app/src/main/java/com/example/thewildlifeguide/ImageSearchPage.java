package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ImageSearchPage extends AppCompatActivity {

    //initialize image search buttons
    private Button textSearchButton;
    private Button settingsButton;

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


        //set value to text search button
        textSearchButton = (Button) findViewById(R.id.textsearchButton);

        settingsButton = (Button) findViewById(R.id.ImageSearchPageSettings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsPage();
            }
        });

        //set value to recyclerView
        recyclerView = findViewById(R.id.searchPage_recyclerView);

        //set the array to animalsList
        list = new AnimalList(this);
        animalList = list.getListOfAnimals();

        //what to do when text search button is clicked
        textSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTextSearch();
            }
        });
    }

    //take the user to the text search page
    public void openTextSearch(){
        Intent intent = new Intent(this,SearchPage.class);
        startActivity(intent);
    }
    public void openSettingsPage(){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }
}