package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchPage extends AppCompatActivity {

    //initialize the image search button
    private Button imageSearchButton;

    //initialize animal list
    private AnimalList list;
    private ArrayList<String> animalList;

    //initialize the search page recycler view and listener
    private RecyclerView recyclerView;

    private SearchPage_recyclerAdapter adapter;

    //initialize the search page's recyclerView's click listener
    private SearchPage_recyclerAdapter.searchpage_RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        //-------------------------------------

        /* Hides the bar at the top of phone */
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Hides ActionBar at the top of the app */
        //getSupportActionBar().hide();
        //getActionBar().setDisplayShowTitleEnabled(false);
        //getActionBar().setTitle("All Animals");

        getSupportActionBar().setTitle("ALL ANIMALS");
        //-------------------------------------


        //set value to imageSearchButton
        imageSearchButton = (Button) findViewById(R.id.searchpageImageSearch_button);

        //set value to recyclerView
        recyclerView = findViewById(R.id.searchPage_recyclerView);

        //set the array to animalsList
        list = new AnimalList(this);
        animalList = list.getListOfAnimals();

        //what to do when the imageSearchButton is clicked
        imageSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageSearch();
            }
        });

        setSearchPageAdapter();
    }

    private void setSearchPageAdapter() {
        setOnClickListener();

        //SearchPage_recyclerAdapter adapter = new SearchPage_recyclerAdapter(this.animalList,listener);
        adapter = new SearchPage_recyclerAdapter(this.animalList,listener);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new SearchPage_recyclerAdapter.searchpage_RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(),InfoPage.class);
                intent.putExtra("animalName",animalList.get(position));
                intent.putExtra("whereFrom","textSearch");
                startActivity(intent);
            }
        };
    }

    //take the user to the image search activity
    public void openImageSearch(){
        Intent intent = new Intent(this,ImageSearchPage.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return true;
    }
}