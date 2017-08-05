package com.example.dbraga.proyecto3.pojo;

import android.database.Cursor;
import android.os.Parcelable;

/**
 * Created by dbraga on 22/07/17.
 */

public class Mascota  {

    private int id;
    private String name;
    private int numeroLikes;
    private int imageRef;

    public Mascota() {
    }

    public Mascota(int id, String name, int numeroLikes, int imageRef) {
        this.id=id;
        this.name = name;
        this.numeroLikes = numeroLikes;
        this.imageRef = imageRef;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(int numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public int getImageRef() {
        return imageRef;
    }

    public void setImageRef(int imageRef) {
        this.imageRef = imageRef;
    }
}
