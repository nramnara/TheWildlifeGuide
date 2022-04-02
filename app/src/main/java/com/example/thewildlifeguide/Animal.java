package com.example.thewildlifeguide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Animal {

    private Context context;
    private String name = "";
    private String vertInvert = "";
    private String species = "";
    private String blooded = "";
    private String habitat = "";
    private String diet = "";
    private String physicalCharacteristics = "";
    private String knownFor = "";
    private String IUCN = "";
    private String similar = "";

    private Drawable image;


    /*
   Constructor. Calls parseText(String) method to move text from the document
   into the correct Strings.
    */
    public Animal(Context context, String path) {
        this.context = context;
        parseText(path);
        setImage();
    }

    public Animal AnimalTest(String path) {
        parseText(path);
        return this;
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

                } else if (text.equals("Vert Invert")) {
                    text = reader.readLine();
                    this.vertInvert = text;

                } else if (text.equals("Species")) {
                    text = reader.readLine();
                    this.species = text;

                } else if (text.equals("Blooded")) {
                    text = reader.readLine();
                    this.blooded = text;

                } else if (text.equals("Known For")) {
                    text = reader.readLine();
                    this.knownFor = text;

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

                } else if (text.equals("IUCN Category")) {
                    text = reader.readLine();
                    while (!text.equals("#####")) {
                        this.IUCN += text + " ";
                        text = reader.readLine();
                    }
                    this.IUCN = this.IUCN.substring(0, this.IUCN.length() - 1);

                } else if (text.equals("Similar Animals")) {
                    text = reader.readLine();
                    while (!text.equals("#####")) {
                        this.similar += text + " ";
                        text = reader.readLine();
                    }
                    this.similar = this.similar.substring(0, this.similar.length() - 1);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
     Stores the image of the animal in a Drawable, the image files are of type jpg and located in
     the .../src/res/drawable folder.
     The image is accessed by getting the resourceID of the image(using the name of the animal to
     find it), and using that resourceID to identify the drawable.
     */
    private void setImage() {

        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(this.name.toLowerCase(Locale.ROOT), "drawable",
                context.getPackageName());
        this.image = resources.getDrawable(resourceId);
    }


    //---------------------------------------------
    //Getter methods

    public String getName() {
        return this.name;
    }

    public String getVertInvert() {
        return this.vertInvert;
    }

    public String getAnimalSpecies() {
        return this.species;
    }

    public String getBlooded() { return this.blooded; }

    public String getAnimalHabitat() {
        return this.habitat;
    }

    public String getAnimalDiet() {
        return this.diet;
    }

    public String getPhysChars() {
        return this.physicalCharacteristics;
    }

    public String getKnownFor() {
        return this.knownFor;
    }

    public String getIUCNCategory() {
        return this.IUCN;
    }

    public String getSimilarAnimals() { return this.similar; }

    public Drawable getImage() {
        return this.image;
    }

    /*
    Prints the Animal to console.
     */
    public void printTraits() {
        System.out.println("Name: " + this.name);
        System.out.println("Vertebrate/Invertebrate: " + this.vertInvert);
        System.out.println("Species: " + this.species);
        System.out.println("Cold/Warm blooded: " + this.blooded);
        System.out.println("Habitat: " + this.habitat);
        System.out.println("Diet: " + this.diet);
        System.out.println("Physical Characteristics: " + this.physicalCharacteristics);
        System.out.println("Known For: " + this.knownFor);
        System.out.println("IUCN Red List Category: " + this.IUCN);
        System.out.println("Similar Animals: " + this.similar);
    }
}
