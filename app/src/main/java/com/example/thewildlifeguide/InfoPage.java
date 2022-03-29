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

        headerSpecies.setText("Species Group");
        headerHabitat.setText("Habitat");
        headerDiet.setText("Diet");
        headerPhysicalChars.setText("Physical Characteristics");
        headerKnownFor.setText("Known For");
        headerIUCNCategory.setText("IUCN Category");

        TextView animalNameText = findViewById(R.id.animalnameTextView);
        TextView animalSpeciesText = findViewById(R.id.animalinfo1TextView);
        TextView animalBloodedText = findViewById(R.id.animalinfo2TextView);
        TextView animalVertInvertText = findViewById(R.id.animalinfo3TextView);
        TextView animalHabitatText = findViewById(R.id.animalinfo4TextView);
        TextView animalDietText = findViewById(R.id.animalinfo5TextView);
        TextView animalPhysCharsText = findViewById(R.id.animalinfo6TextView);
        TextView animalKnownForText = findViewById(R.id.animalinfo7TextView);
        TextView animalIUCNCategoryText = findViewById(R.id.animalinfo8TextView);


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
        animalHabitatText.setText(currentAnimal.getAnimalHabitat());
        animalDietText.setText(currentAnimal.getAnimalDiet());
        animalPhysCharsText.setText(currentAnimal.getPhysChars());
        animalKnownForText.setText(currentAnimal.getKnownFor());
        animalIUCNCategoryText.setText(currentAnimal.getIUCNCategory());

        animalImage.setImageDrawable(currentAnimal.getImage());

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
