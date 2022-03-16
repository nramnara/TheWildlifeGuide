package com.example.eecs1022project_thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // initialize the homepage's buttons
    private Button searchButton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set value to searchButton
        searchButton = (Button) findViewById(R.id.homepageSearch_button);

        //set value to settingsButton
        settingsButton = (Button) findViewById(R.id.homepageSettings_button);

        //what to do when the searchButton is clicked
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchPage();
            }
        });

        //what to do when the searchButton is clicked
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsPage();
            }
        });
    }

    //take the user to the SearchPage activity
    public void openSearchPage(){
        Intent intent = new Intent(this,SearchPage.class);
        startActivity(intent);
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }
}