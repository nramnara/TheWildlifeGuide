package com.example.thewildlifeguide;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;






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
public void getAnimalTraits() {
    Animal animal = new Animal( InstrumentationRegistry.getInstrumentation().getTargetContext(), "crow");

    assertEquals("Crow", animal.getName());

//        assertEquals("Vertebrate", animal.getVertInvert());
//        assertEquals("Bird", animal.getAnimalSpecies());
//        assertEquals("Both northwestern and American crows tend to forage in open areas but prefer wooded habitats for nesting and roosting.\n" +
//                "The northwestern crow nests mainly in coniferous trees; the American crow, in deciduous and coniferous trees and, occasionally, in low bushes.", animal.getAnimalHabitat());
//        assertEquals("Warm-blooded", animal.getBlooded());
//        assertEquals("LC - Least Concern", animal.getIUCNCategory());


//        assertEquals("Crow is a Warm-blooded Vertebrate of species." +
//                "Adult American crows are completely black birds.\n" +
//                "The feathers have a glossy and slightly iridescent look.\n" +
//                "Crows have strong legs and toes.\n" +
//                "The bill is also black with a slight hook on the end.. Some more information about its habitat: Both northwestern and American crows tend to forage in open areas but prefer wooded habitats for nesting and roosting.\n" +
//                "The northwestern crow nests mainly in coniferous trees; the American crow, in deciduous and coniferous trees and, occasionally, in low bushes.. " +
//                "Crows are known for their intelligence and adaptability, and for their loud, harsh 'caw'.. It is listed in IUCN's Red List as: " +
//                "LC - Least Concern. Some similar animals are: \" Eagle;\n" +
//                "Peacock;\n" +
//                "Penguin;\";", animal.printTraits());
    }
}
