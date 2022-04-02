package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        //Hides ActionBar at the top of the app
        getSupportActionBar().hide();

        setBackButton();

        setDarkModeSwitch();
        setHabitatSwitch();
        setDietSwitch();
        setSwitchPhysicalChars();
        setSwitchKnownFor();
        setSwitchIUCN();
        setSwitchSimilarAnimals();
    }


    /*check if caught intent is from animals page
      make a new throw intent that goes to the info page
      if not (then its from the homepage)
      make a new throw intent that goes to the homepage
      take the user to the homepage (MainActivity) activity */
    public void openHomePage(){
        //initialize what the previous animalName is
        String prevAnimalName;
        prevAnimalName = "";

        //check if an intent is thrown in here (is only possible if user comes from InfoPage), if so set the prev animal name to the string assigned to the key
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            prevAnimalName = extras.getString("fromInfo");
        }

        //check if prevAnimalName was assigned anything, if so then the previous page must be an animal info page, send the user back to that specific animal page
        if (prevAnimalName.length() > 0){
            Intent intent = new Intent(this,InfoPage.class);
            intent.putExtra("animalName",prevAnimalName.toLowerCase()); //lowercase the animal name, since the file name is in all lowercase
            startActivity(intent);                                                       //ex. "Cat" -> "cat" since the name for the cats .txt file for cat is in all lowercase
        }

        //if the above is not the case, then the user must have came from the homepage, send the user back to the home page
        else
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }


    public void setBackButton() {

        //set value to backButton
        Button backButton = (Button) findViewById(R.id.settingsBack_button);

        //what to do when the backButton is clicked
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
    }


    public void setDarkModeSwitch() {
        Switch switchDarkMode = findViewById(R.id.darkMode);
        switchDarkMode.setText("Dark Mode");

        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }


    public void setHabitatSwitch() {
        Switch switchHabitat = findViewById(R.id.textSwitch1);
        switchHabitat.setText("Habitat");

        if (MainActivity.settingsVariables.habitat == false) {
            switchHabitat.setChecked(false);
        } else {
            switchHabitat.setChecked(true);
        }

        switchHabitat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchHabitat.isChecked()) {
                    MainActivity.settingsVariables.habitat = true;
                } else {
                    MainActivity.settingsVariables.habitat = false;
                }
            }
        });
    }


    public void setDietSwitch() {
        Switch switchDiet = findViewById(R.id.textSwitch2);
        switchDiet.setText("Diet");

        if (MainActivity.settingsVariables.diet == false) {
            switchDiet.setChecked(false);
        } else {
            switchDiet.setChecked(true);
        }

        switchDiet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchDiet.isChecked()) {
                    MainActivity.settingsVariables.diet = true;
                } else {
                    MainActivity.settingsVariables.diet = false;
                }
            }
        });
    }


    public void setSwitchPhysicalChars() {
        Switch switchPhysicalChars = findViewById(R.id.textSwitch3);
        switchPhysicalChars.setText("Physical Characteristics");

        if (MainActivity.settingsVariables.physicalChars == false) {
            switchPhysicalChars.setChecked(false);
        } else {
            switchPhysicalChars.setChecked(true);
        }

        switchPhysicalChars.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchPhysicalChars.isChecked()) {
                    MainActivity.settingsVariables.physicalChars = true;
                } else {
                    MainActivity.settingsVariables.physicalChars = false;
                }
            }
        });
    }


    public void setSwitchKnownFor() {
        Switch switchKnownFor = findViewById(R.id.textSwitch4);
        switchKnownFor.setText("Known For");

        if (MainActivity.settingsVariables.knownFor == false) {
            switchKnownFor.setChecked(false);
        } else {
            switchKnownFor.setChecked(true);
        }

        switchKnownFor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchKnownFor.isChecked()) {
                    MainActivity.settingsVariables.knownFor = true;
                } else {
                    MainActivity.settingsVariables.knownFor = false;
                }
            }
        });
    }


    public void setSwitchIUCN() {
        Switch switchIUCN = findViewById(R.id.textSwitch5);
        switchIUCN.setText("IUCN");

        if (MainActivity.settingsVariables.IUCN == false) {
            switchIUCN.setChecked(false);
        } else {
            switchIUCN.setChecked(true);
        }

        switchIUCN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchIUCN.isChecked()) {
                    MainActivity.settingsVariables.IUCN = true;
                } else {
                    MainActivity.settingsVariables.IUCN = false;
                }
            }
        });
    }


    public void setSwitchSimilarAnimals() {
        Switch switchSimilarAnimals = findViewById(R.id.textSwitch5);
        switchSimilarAnimals.setText("Similar Animals");

        if (MainActivity.settingsVariables.similarAnimals == false) {
            switchSimilarAnimals.setChecked(false);
        } else {
            switchSimilarAnimals.setChecked(true);
        }

        switchSimilarAnimals.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchSimilarAnimals.isChecked()) {
                    MainActivity.settingsVariables.similarAnimals = true;
                } else {
                    MainActivity.settingsVariables.similarAnimals = false;
                }
            }
        });
    }
}
