package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoPage extends AppCompatActivity {

    private Button settingsButton;
    private Button backButton;
    private Animal currentAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        //-------------------------------------

        /* Hides the bar at the top of phone */
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Hides ActionBar at the top of the app */
        getSupportActionBar().hide();

        //-------------------------------------


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
        TextView animalNameText = findViewById(R.id.animalnameTextView);
        TextView animalSpeciesText = findViewById(R.id.animalinfo1TextView);
        TextView animalHabitatText = findViewById(R.id.animalinfo2TextView);
        TextView animalDietText = findViewById(R.id.animalinfo3TextView);
        TextView animalPhysCharsText = findViewById(R.id.animalinfo4TextView);

        String path = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            path = extras.getString("animalName");
            currentAnimal = new Animal(this, path);
        }

        animalNameText.setText(currentAnimal.getName());
        animalSpeciesText.setText(currentAnimal.getAnimalSpecies());
        animalHabitatText.setText(currentAnimal.getAnimalHabitat());
        animalDietText.setText(currentAnimal.getAnimalDiet());
        animalPhysCharsText.setText(currentAnimal.getPhysChars());
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }

    public void openSearchPage(){
        Intent intent = new Intent(this,SearchPage.class);
        startActivity(intent);
    }
}