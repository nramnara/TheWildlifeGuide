package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    // initialize the homepage's buttons
    private Button searchButton;
    private Button settingsButton;
    public static SettingsVariables settingsVariables;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();

        settingsVariables = new SettingsVariables();

        //-------------------------------------

        /* Hides ActionBar at the top of the app */
        getSupportActionBar().hide();
        //-------------------------------------

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


    public void setTheme(View v) {
        v.setBackgroundResource(R.color.black);
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

    public View getView() {
        return findViewById(android.R.id.content).getRootView();
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }
}