package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsPage extends AppCompatActivity {

    //initialize Setting's buttons
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        //-------------------------------------

        /* Hides the bar at the top of phone */
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Hides ActionBar at the top of the app */
        getSupportActionBar().hide();

        //-------------------------------------


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
            intent.putExtra("animalName",prevAnimalName.toLowerCase(Locale.ROOT)); //lowercase the animal name, since the file name is in all lowercase
            startActivity(intent);                                                       //ex. "Cat" -> "cat" since the name for the cats .txt file for cat is in all lowercase
        }

        //if the above is not the case, then the user must have came from the homepage, send the user back to the home page
        else
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
