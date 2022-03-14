package com.example.wildlifeguidenav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TextSearchAnimals extends AppCompatActivity {

    Button toPhotoSearch_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        toPhotoSearch_button = (Button) findViewById(R.id.photoSearchButton);

        toPhotoSearch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPhotoSearchAnimals();
            }
        });
    }

    public void goToPhotoSearchAnimals()
    {
        Intent intent = new Intent(this,PhotoSearchAnimals.class);
        startActivity(intent);
    }
}
