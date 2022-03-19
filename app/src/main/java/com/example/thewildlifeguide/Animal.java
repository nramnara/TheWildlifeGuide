package com.example.thewildlifeguide;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Animal {

    private Context context;
    private String name = "";
    private String species = "";
    private String habitat = "";
    private String diet = "";
    private String physicalCharacteristics = "";


    /*
    Constructor. Calls parseText(String) method to move text from the document
    into the correct Strings.
     */
    public Animal(Context context, String path) {
        this.context = context;
        parseText(path);
    }

    /*
     Parses the text file using a BufferedReader, and stores each section in a String.
     */
    private void parseText(String path) {
        File animal = new File(path + ".txt");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.context.getAssets().open(String.valueOf(animal))));
            String text = "";

            while (!text.equals("$$$$$END$$$$$")) {
                text = reader.readLine();

                if (text.equals("Name")) {
                    text = reader.readLine();
                    this.name = text;

                } else if (text.equals("Species")) {
                    text = reader.readLine();
                    this.species = text;

                } else if (text.equals("Physical Characteristics")) {
                    text = reader.readLine();
                    while (!text.equals("#####")) {
                        this.physicalCharacteristics += text + " ";
                        text = reader.readLine();
                    }
                    this.physicalCharacteristics = this.physicalCharacteristics.substring(0,
                            this.physicalCharacteristics.length() - 1);

                } else if (text.equals("Habitat")) {
                    text = reader.readLine();
                    while (!text.equals("#####")) {
                        this.habitat += text + " ";
                        text = reader.readLine();
                    }
                    this.habitat = this.habitat.substring(0, this.habitat.length() - 1);

                } else if (text.equals("Diet")) {
                    text = reader.readLine();
                    while (!text.equals("#####")) {
                        this.diet += text + " ";
                        text = reader.readLine();
                    }
                    this.diet = this.diet.substring(0, this.diet.length() - 1);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }


    //---------------------------------------------
    //Getter methods

    public String getAnimalSpecies() {
        return this.species;
    }

    public String getAnimalHabitat() {
        return this.habitat;
    }

    public String getAnimalDiet() {
        return this.diet;
    }

    public String getPhysChars() {
        return this.physicalCharacteristics;
    }

    public String getName() {
        return this.name;
    }


    /*
    Prints the Animal to console.
     */
    public void printTraits() {
        System.out.println("Name: " + this.name);
        System.out.println("Species: " + this.species);
        System.out.println("Physical Characteristics: " + this.physicalCharacteristics);
        System.out.println("Habitat: " + this.habitat);
        System.out.println("Diet: " + this.diet);
    }
}
