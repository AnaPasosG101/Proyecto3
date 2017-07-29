package com.example.dbraga.proyecto3.pojo;

import android.os.Parcelable;

/**
 * Created by dbraga on 22/07/17.
 */

public class Mascota  {
    private String name;
    private int numeroLikes;
    private int imageRef;

    public Mascota() {
    }

    public Mascota(String name, int numeroLikes, int imageRef) {
        this.name = name;
        this.numeroLikes = numeroLikes;
        this.imageRef = imageRef;
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
