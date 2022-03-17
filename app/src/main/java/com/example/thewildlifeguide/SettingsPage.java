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
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}