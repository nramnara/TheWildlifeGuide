package com.example.wildlifeguidenav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    Button toSettings_button;
    Button toTextSearch_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //change the view to the .xml file 'activity_main'

        toSettings_button = (Button) findViewById(R.id.settingsButton);

        toSettings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSettings(); //when the user clicks the button, it will run the method below
            }
        });

        toTextSearch_button = (Button) findViewById(R.id.searchButton);

        toTextSearch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTextSearchAnimals(); //when the user clicks the button, it will run the method below
            }
        });
    }

    public void goToSettings(){
        Intent intent = new Intent(this,Settings.class); //NewActivity is the .java file you want to go to
        startActivity(intent);
    }

    public void goToTextSearchAnimals(){
        Intent intent = new Intent(this,TextSearchAnimals.class);
        startActivity(intent);
    }
}