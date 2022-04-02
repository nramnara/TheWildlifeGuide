package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPage extends AppCompatActivity {

    private Button settingsButton;
    private Button backButton;
    private Animal currentAnimal;

    public static String InfoPage_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        /* Hides ActionBar at the top of the app */
        getSupportActionBar().hide();

        settingsButton = (Button) findViewById(R.id.infopageSettings_button);
        backButton = (Button) findViewById(R.id.infopageBack_button);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsPage();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchPage();
            }
        });

        populatePage();
    }

    public void populatePage() {
        ImageView animalImage = findViewById(R.id.animalImageView);

        TextView headerSpecies = findViewById(R.id.sectionHeader1);
        TextView headerHabitat = findViewById(R.id.sectionHeader2);
        TextView headerDiet = findViewById(R.id.sectionHeader3);
        TextView headerPhysicalChars = findViewById(R.id.sectionHeader4);
        TextView headerKnownFor = findViewById(R.id.sectionHeader5);
        TextView headerIUCNCategory = findViewById(R.id.sectionHeader6);
        TextView headerSimilarAnimals = findViewById(R.id.sectionHeader7);

        headerSpecies.setText("Species Group");
        headerHabitat.setText("Habitat");
        headerDiet.setText("Diet");
        headerPhysicalChars.setText("Physical Characteristics");
        headerKnownFor.setText("Known For");
        headerIUCNCategory.setText("IUCN Category");
        headerSimilarAnimals.setText("Similar Animals");

        TextView animalNameText = findViewById(R.id.animalnameTextView);
        TextView animalSpeciesText = findViewById(R.id.animalinfo1TextView);
        TextView animalBloodedText = findViewById(R.id.animalinfo2TextView);
        TextView animalVertInvertText = findViewById(R.id.animalinfo3TextView);
        TextView animalHabitatText = findViewById(R.id.animalinfo4TextView);
        TextView animalDietText = findViewById(R.id.animalinfo5TextView);
        TextView animalPhysCharsText = findViewById(R.id.animalinfo6TextView);
        TextView animalKnownForText = findViewById(R.id.animalinfo7TextView);
        TextView animalIUCNCategoryText = findViewById(R.id.animalinfo8TextView);
        TextView animalSimilarAnimalsText = findViewById(R.id.animalinfo9TextView);


        String path;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            path = extras.getString("animalName");
            currentAnimal = new Animal(this, path);
        }


        animalNameText.setText(currentAnimal.getName());
        animalVertInvertText.setText(currentAnimal.getVertInvert());
        animalSpeciesText.setText(currentAnimal.getAnimalSpecies());
        animalBloodedText.setText(currentAnimal.getBlooded());

        if(MainActivity.settingsVariables.getHabitat() == true) {
            animalHabitatText.setText(currentAnimal.getAnimalHabitat());
        } else {
            animalHabitatText.setVisibility(View.GONE);
        }

        if(MainActivity.settingsVariables.getDiet() == true) {
            animalDietText.setText(currentAnimal.getAnimalDiet());
        } else {
            animalDietText.setVisibility(View.GONE);
        }

        if(MainActivity.settingsVariables.getPhysChars() == true) {
            animalPhysCharsText.setText(currentAnimal.getPhysChars());
        } else {
            animalPhysCharsText.setVisibility(View.GONE);
        }

        if(MainActivity.settingsVariables.getKnownFor() == true) {
            animalKnownForText.setText(currentAnimal.getKnownFor());
        } else {
            animalKnownForText.setVisibility(View.GONE);
        }

        if(MainActivity.settingsVariables.getIUCN() == true) {
            animalIUCNCategoryText.setText(currentAnimal.getIUCNCategory());
        } else {
            animalIUCNCategoryText.setVisibility(View.GONE);
        }

        if(MainActivity.settingsVariables.getSimilarAnimals() == true) {
            animalSimilarAnimalsText.setText(currentAnimal.getSimilarAnimals());
        } else {
            animalSimilarAnimalsText.setVisibility(View.GONE);
        }


        animalImage.setImageDrawable(currentAnimal.getImage());
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this,SettingsPage.class);
        intent.putExtra("fromInfo",currentAnimal.getName());

        String prevPage;
        prevPage = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            prevPage = extras.getString("whereFrom");
        }

        //send what search page was used to display the current infoPage
        switch(prevPage) {
            case "imageSearch":
                intent.putExtra("searchType","imageSearch");
                break;
            case "textSearch":
                intent.putExtra("searchType","textSearch");
                break;
        }
        startActivity(intent);
    }

    public void openSearchPage(){
        String prevPage;
        prevPage = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            prevPage = extras.getString("whereFrom");
        }

        switch(prevPage){
            case "imageSearch":
                Intent intent = new Intent(this,ImageSearchPage.class);
                startActivity(intent);
                break;
            case "textSearch":
                Intent textSearch_intent = new Intent(this,SearchPage.class);
                startActivity(textSearch_intent);
        }
    }
}
