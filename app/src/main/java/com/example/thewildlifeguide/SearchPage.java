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
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SearchPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //initialize the image search button
    private Button imageSearchButton;
    private Button settingsButton;

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
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> dropdownAdapter = ArrayAdapter.createFromResource(this,R.array.numbers,android.R.layout.simple_spinner_item);
        dropdownAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dropdownAdapter);

        spinner.setOnItemSelectedListener(this);
        //------------------------------------
        settingsButton = (Button) findViewById(R.id.SearchPageSettings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsPage();
            }
        });

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
                intent.putExtra("whereFrom","textSearch");
                intent.putExtra("animalName",animalList.get(position));
                startActivity(intent);
            }
        };
    }

    //take the user to the image search activity
    public void openImageSearch(){
        Intent intent = new Intent(this,ImageSearchPage.class);
        startActivity(intent);
    }
    public void openSettingsPage(){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Type here to search");
        
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //check which button is clicked using adapterView.getItemAtPosition
        //sort the list: animalList accordingly based on what option was selected above
        String filter = adapterView.getItemAtPosition(i).toString();

        //implement animalList sorting here, note that filter = itemname found in strings.xml, <item>itemname</item>
        if (filter.equals("Vertebrates"))
        {
            AnimalList temp_list;
            ArrayList<String> temp_animalList;

            temp_list = new AnimalList(this);
            temp_animalList = temp_list.getListOfAnimals();

            ArrayList<String> vertebrates = new ArrayList<>();

            for (int j = 0;j < temp_animalList.size();j++)
            {
                Animal currentAnimal = new Animal(this,temp_animalList.get(j));

                if (currentAnimal.getVertInvert().equals("Vertebrate"))
                {
                    vertebrates.add(currentAnimal.getName().toLowerCase());
                }
            }
            animalList = vertebrates;//BUG: it removes it, but doesn't update the view
            setSearchPageAdapter(); //after making changes to animalList, call this method after, so the view is changed
        }

        if (filter.equals("Mammals"))
        {
            AnimalList temp_list;
            ArrayList<String> temp_animalList;

            temp_list = new AnimalList(this);
            temp_animalList = temp_list.getListOfAnimals();

            ArrayList<String> mammals = new ArrayList<>();
            for (int j = 0;j < temp_animalList.size();j++)
            {
                Animal currentAnimal = new Animal(this,temp_animalList.get(j));

                if (currentAnimal.getAnimalSpecies().equals("Mammal"))
                {
                    mammals.add(currentAnimal.getName().toLowerCase());
                }
            }
            animalList = mammals;//BUG: it removes it, but doesn't update the view
            setSearchPageAdapter(); //after making changes to animalList, call this method after, so the view is changed

        }

        if (filter.equals("Cold-Blooded"))
        {
            AnimalList temp_list;
            ArrayList<String> temp_animalList;

            temp_list = new AnimalList(this);
            temp_animalList = temp_list.getListOfAnimals();

            ArrayList<String> coldBlooded = new ArrayList<>();

            for (int j = 0;j < temp_animalList.size();j++)
            {
                Animal currentAnimal = new Animal(this,temp_animalList.get(j));

                if (currentAnimal.getBlooded().equals("Cold-blooded"))
                {
                    coldBlooded.add(currentAnimal.getName().toLowerCase());
                }
            }
            animalList = coldBlooded;//BUG: it removes it, but doesn't update the view
            setSearchPageAdapter(); //after making changes to animalList, call this method after, so the view is changed

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
