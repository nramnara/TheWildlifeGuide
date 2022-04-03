package com.example.thewildlifeguide;

public class SettingsVariables {

    public boolean habitat = true;
    public boolean diet = true;
    public boolean physicalChars = true;
    public boolean knownFor = true;
    public boolean IUCN = true;
    public boolean similarAnimals = true;
    public boolean darkMode = false;
    public String page = "Home";

    public boolean getHabitat() {
        return this.habitat;
    }

    public boolean getDiet() {
        return this.diet;
    }

    public boolean getPhysChars() {
        return this.physicalChars;
    }

    public boolean getKnownFor() {
        return this.knownFor;
    }

    public boolean getIUCN() {
        return this.IUCN;
    }

    public boolean getSimilarAnimals() {
        return this.similarAnimals;
    }

    public boolean getDarkMode() {
        return this.darkMode;
    }

    public String getPage() {
        return this.page;
    }
}
