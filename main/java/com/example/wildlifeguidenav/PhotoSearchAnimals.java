package com.example.wildlifeguidenav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PhotoSearchAnimals extends AppCompatActivity {

    Button toTextSearch_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);

        toTextSearch_button = (Button) findViewById(R.id.textSearchButton);

        toTextSearch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTextSearchAnimals();
            }
        });
    }

    public void goToTextSearchAnimals()
    {
        Intent intent = new Intent(this,TextSearchAnimals.class);
        startActivity(intent);
    }


}