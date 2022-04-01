package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

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

    //initialize Setting's buttons
    private Button backButton;
    private UiModeManager uiModeManager;
    //private Context context = this.getApplicationContext();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        /*
        //Hides the bar at the top of phone
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        */

        //Hides ActionBar at the top of the app
        getSupportActionBar().hide();

        //setSwitches();

        /*
        //-------------------------------------
        uiModeManager = (UiModeManager) getSystemService(UI_MODE_SERVICE);

        Switch darkMode = findViewById(R.id.darkMode);

        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(darkMode.isChecked()) {
                    System.out.println("Yes");
                    View v = findViewById(android.R.id.content).getRootView();
                    v.setBackgroundResource(R.color.black);

                } else {
                    uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
                    System.out.println("No");
                    View v = findViewById(android.R.id.content).getRootView();
                    v.setBackgroundResource(R.color.white);
                }

            }
        });
        //-------------------------------------
*/
        /*
        Switch switchHabitat = findViewById(R.id.textSwitch1);
        TextView textHabitat = (TextView) findViewById(R.id.animalinfo4TextView);
        switchHabitat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchHabitat.isChecked()) {
                    System.out.println("Yes");
                    System.out.println(textHabitat.getText());
                } else {
                    System.out.println("No");
                }
            }
        });
        */






        //set value to backButton
        backButton = (Button) findViewById(R.id.settingsBack_button);

        //what to do when the backButton is clicked
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
    }





    // take the user to the homepage (MainActivity) activity
    public void openHomePage(){
        //check if catched intent is from animals page
        //make a new throw intent that goes to the info page
        // if not (then its from the homepage)
        //make a new throw intent that goes to the homepage

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

    public void setSwitches() {
        Switch switchHabitat = findViewById(R.id.textSwitch1);
        Switch switchDiet = findViewById(R.id.textSwitch2);
        Switch switchPhysicalChars = findViewById(R.id.textSwitch3);
        Switch switchKnownFor = findViewById(R.id.textSwitch4);
        Switch switchIUCN = findViewById(R.id.textSwitch5);


        switchHabitat.setText("Habitat");
        switchDiet.setText("Diet");
        switchPhysicalChars.setText("Physical Characteristics");
        switchKnownFor.setText("Known For");
        switchIUCN.setText("IUCN Category");


        TextView headerDiet = findViewById(R.id.sectionHeader3);
        TextView headerPhysicalChars = findViewById(R.id.sectionHeader4);
        TextView headerKnownFor = findViewById(R.id.sectionHeader5);
        TextView headerIUCNCategory = findViewById(R.id.sectionHeader6);

        Context context = this;


    }
}
