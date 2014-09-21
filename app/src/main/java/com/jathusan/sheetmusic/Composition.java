package com.jathusan.sheetmusic;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.ArrayList;

public class Composition {

    String title;
    String composer;
    String style;
    String difficulty;
    String key;
    String date;
    int imagesId;

    public int getImagesId() {
        return imagesId;
    }

    public void setImagesId(int imagesId) {
        this.imagesId = imagesId;
    }

    ArrayList<Bitmap> pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Bitmap> getPages() {
        return pages;
    }

    public void addPage(Bitmap page){
        pages.add(page);
    }

}
