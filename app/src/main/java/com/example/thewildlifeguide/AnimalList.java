package com.example.thewildlifeguide;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.util.ArrayList;


public class AnimalList {

    private Context context;
    private ArrayList<String> listOfAnimals = new ArrayList<>();

    /*
    Constructor. Calls createAnimalList(String) to list all animals.
     */
    public AnimalList(Context context) {
        this.context = context;
        createAnimalList();
    }

    /*
    Reads the asset folder and makes an ArrayList<String> of all animals
     */
    private void createAnimalList() {
        AssetManager assetManager = this.context.getAssets();

        try {
            String[] files = assetManager.list("");

            for (int i = 0; i < files.length; i++) {
                if (!files[i].equals("images") && !files[i].equals("webkit")) {
                    listOfAnimals.add(files[i].substring(0, files[i].length() - 4));
                }
            }

        } catch (IOException e){
            System.out.println(e);
        }
    }

    /*
    getter for listOfAnimals
     */
    public ArrayList<String> getListOfAnimals() {
        return this.listOfAnimals;
    }
}
