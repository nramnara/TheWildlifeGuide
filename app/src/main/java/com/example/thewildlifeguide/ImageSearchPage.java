package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ImageSearchPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //initialize the recyclerView
    RecyclerView imageSearch;

    //initialize list containing the animal's names and their corresponding pics
    List<String> animalNames;
    List<Drawable> animalPics;

    //initialize adapter for imageSearch
    ImagePage_Adapter imagePageAdapter;

    //initialize listener for clicks
    private ImagePage_Adapter.RecyclerViewClickListener listener;

    //----------------------------------

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

        MainActivity.settingsVariables.page = "imageSearch";

        //-------------------------------------

        /* Hides the bar at the top of phone */
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Hides ActionBar at the top of the app */
        //getSupportActionBar().hide();

        //-------------------------------------

        Spinner spinner = findViewById(R.id.imageSearch_spinner);
        ArrayAdapter<CharSequence> dropdownAdapter = ArrayAdapter.createFromResource(this,R.array.numbers,android.R.layout.simple_spinner_item);
        dropdownAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dropdownAdapter);

        spinner.setOnItemSelectedListener(this);

        //--------------
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


        //----------------------------------

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

    private void setAdapter() {
        setOnclickListener();
        this.imagePageAdapter = new ImagePage_Adapter(this, animalNames, animalPics,listener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.VERTICAL,false);
        imageSearch.setLayoutManager(gridLayoutManager);
        imageSearch.setAdapter(imagePageAdapter);
    }

    private void setOnclickListener() {
        listener = new ImagePage_Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),InfoPage.class);
                intent.putExtra("animalName",animalNames.get(position));
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
    public void openSettingsPage(){
        Intent intent = new Intent(this,SettingsPage.class);
        MainActivity.settingsVariables.page = "imageSearch";
        startActivity(intent);
    }


    //-----------------------------
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
                imagePageAdapter.getFilter().filter(s);
                return false;
            }
        });

        return true;
    }










    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String filter = adapterView.getItemAtPosition(i).toString();

        if (filter.equals("All Animals"))
        {
            AnimalList temp_list = new AnimalList(this);
            ArrayList<String> temp_animalList = temp_list.getListOfAnimals();
            ArrayList<Drawable> allAnimals_pics = new ArrayList<>();
            ArrayList<String> allAnimals = new ArrayList<>();


            animalList = temp_animalList;//BUG: it removes it, but doesn't update the view

            for (int n = 0; n < animalList.size();n++)
            {
                Animal currentAnimal = new Animal(this, animalList.get(n));
                allAnimals_pics.add(currentAnimal.getImage());
            }

            animalPics = allAnimals_pics;
            animalNames = animalList;
            setAdapter(); //after making changes to animalList, call this method after, so the view is changed
        }


        if (filter.equals("Vertebrates"))
        {
            AnimalList temp_list;
            ArrayList<String> temp_animalList;

            temp_list = new AnimalList(this);
            temp_animalList = temp_list.getListOfAnimals();

            ArrayList<String> vertebrates = new ArrayList<>();
            ArrayList<Drawable> vertebrates_pics = new ArrayList<>();

            for (int j = 0;j < temp_animalList.size();j++)
            {
                Animal currentAnimal = new Animal(this,temp_animalList.get(j));

                if (currentAnimal.getVertInvert().equals("Vertebrate"))
                {
                    vertebrates.add(currentAnimal.getName().toLowerCase());
                    vertebrates_pics.add(currentAnimal.getImage());
                }
            }
            animalNames = vertebrates;//BUG: it removes it, but doesn't update the view
            animalPics = vertebrates_pics;

            setAdapter(); //after making changes to animalList, call this method after, so the view is changed
        }

        if (filter.equals("Mammals"))
        {
            AnimalList temp_list;
            ArrayList<String> temp_animalList;

            temp_list = new AnimalList(this);
            temp_animalList = temp_list.getListOfAnimals();

            ArrayList<String> mammals = new ArrayList<>();
            ArrayList<Drawable> mammalsPics = new ArrayList<>();

            for (int j = 0;j < temp_animalList.size();j++)
            {
                Animal currentAnimal = new Animal(this,temp_animalList.get(j));

                if (currentAnimal.getAnimalSpecies().equals("Mammal"))
                {
                    mammals.add(currentAnimal.getName().toLowerCase());
                    mammalsPics.add(currentAnimal.getImage());
                }
            }
            animalPics = mammalsPics;
            animalNames = mammals;//BUG: it removes it, but doesn't update the view
            setAdapter(); //after making changes to animalList, call this method after, so the view is changed

        }

        if (filter.equals("Cold-Blooded"))
        {
            AnimalList temp_list;
            ArrayList<String> temp_animalList;

            temp_list = new AnimalList(this);
            temp_animalList = temp_list.getListOfAnimals();

            ArrayList<String> coldBlooded = new ArrayList<>();
            ArrayList<Drawable> coldBlooded_pics = new ArrayList<>();


            for (int j = 0;j < temp_animalList.size();j++)
            {
                Animal currentAnimal = new Animal(this,temp_animalList.get(j));

                if (currentAnimal.getBlooded().equals("Cold-blooded"))
                {
                    coldBlooded.add(currentAnimal.getName().toLowerCase());
                    coldBlooded_pics.add(currentAnimal.getImage());
                }
            }
            animalPics = coldBlooded_pics;
            animalNames = coldBlooded;//BUG: it removes it, but doesn't update the view
            setAdapter(); //after making changes to animalList, call this method after, so the view is changed

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}