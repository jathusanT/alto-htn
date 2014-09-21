package com.jathusan.sheetmusic;

import java.util.ArrayList;

public class Composer {

    String name;
    ArrayList<Composition> compositions;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addComposition(Composition composition){
        compositions.add(composition);
    }

    public ArrayList<Composition> getCompositions(){
        return compositions;
    }

}
