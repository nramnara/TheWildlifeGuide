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