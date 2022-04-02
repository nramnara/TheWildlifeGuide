package com.example.thewildlifeguide;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.thewildlifeguide", appContext.getPackageName());
    }


    @Test
public void getAnimalTraits_01() {
    Animal animal = new Animal( InstrumentationRegistry.getInstrumentation().getTargetContext(), "crow");

    assertEquals("Crow", animal.getName());

    assertEquals("Vertebrate", animal.getVertInvert());
    assertEquals("Bird", animal.getAnimalSpecies());
    System.out.println(animal.getAnimalHabitat());
    assertEquals("Both northwestern and American crows tend to forage in open areas but prefer wooded habitats for nesting and roosting. " +
            "The northwestern crow nests mainly in coniferous trees; the American crow, in deciduous and coniferous trees and, occasionally, in low bushes.", animal.getAnimalHabitat());
    assertEquals("Warm-blooded", animal.getBlooded());
    assertEquals("LC - Least Concern", animal.getIUCNCategory());
    }

    @Test
public void getAnimalTraits_02() {
        Animal animal = new Animal( InstrumentationRegistry.getInstrumentation().getTargetContext(), "lion");

        assertEquals("Lion", animal.getName());

        assertEquals("Vertebrate", animal.getVertInvert());
        assertEquals("Mammal", animal.getAnimalSpecies());
        assertEquals("Lions live in a variety of habitats but prefer grassland, savanna, dense scrub, and open woodland.", animal.getAnimalHabitat());
        assertEquals("Warm-blooded", animal.getBlooded());
        assertEquals("CR - Critically Endangered. " +
                "This means they are considered to be facing an extremely high risk of extinction.", animal.getIUCNCategory());
    }

    @Test
public void getAnimalTraits_03() {
        Animal animal = new Animal( InstrumentationRegistry.getInstrumentation().getTargetContext(), "reindeer");

        assertEquals("Reindeer", animal.getName());

        assertEquals("Vertebrate", animal.getVertInvert());
        assertEquals("VU - Vulnerable", animal.getIUCNCategory());
        assertEquals("Zebra;", animal.getSimilarAnimals());
        assertEquals("Reindeer are known around the world as the fictional sidekicks of Santa Claus.", animal.getKnownFor());

    }

    @Test
public void getAnimalList() {
        AnimalList list = new AnimalList(InstrumentationRegistry.getInstrumentation().getTargetContext());
        ArrayList<String> listOfAnimals = new ArrayList<>();

    AssetManager assetManager = InstrumentationRegistry.getInstrumentation().getTargetContext().getAssets();

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

    assertEquals(listOfAnimals, list.getListOfAnimals());

    }
}
