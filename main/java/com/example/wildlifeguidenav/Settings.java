package com.example.wildlifeguidenav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    Button toHomePage_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new); //set the view to the .xml file 'activity_new'

        toHomePage_button = (Button) findViewById(R.id.homepageButton);

        toHomePage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHomepage(); //when uesr clicks button, run the method below
            }
        });
    }

    public void goToHomepage() {
        Intent intent = new Intent(this,Homepage.class); //MainActivity is the java file you want to go to
        startActivity(intent);
    }
}