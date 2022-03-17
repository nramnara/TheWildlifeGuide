package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoPage extends AppCompatActivity {

    private Button settingsButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

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
        TextView animalnameTxt = findViewById(R.id.animalnameTextView);
        TextView animalinfo1Txt = findViewById(R.id.animalinfo1TextView);
        TextView animalinfo2Txt = findViewById(R.id.animalinfo2TextView);
        TextView animalinfo3Txt = findViewById(R.id.animalinfo3TextView);

        String animalName = "Username not set";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            animalName = extras.getString("animalName");
        }

        animalnameTxt.setText(animalName);
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