package com.example.thewildlifeguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImageSearchPage extends AppCompatActivity {

    //initialize image search buttons
    private Button textSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search_page);

        //set value to text search button
        textSearchButton = (Button) findViewById(R.id.textsearchButton);

        //what to do when text search button is clicked
        textSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTextSearch();
            }
        });
    }

    //take the user to the text search page
    public void openTextSearch(){
        Intent intent = new Intent(this,SearchPage.class);
        startActivity(intent);
    }
}