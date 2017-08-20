package com.example.dbraga.proyecto3.pojo;

import android.database.Cursor;
import android.os.Parcelable;

/**
 * Created by dbraga on 22/07/17.
 */

public class Mascota  {

    private String id;
    private int idDB;
    private String name;
    private int numeroLikes;
    private int imageRef;
    private String urlImage;

    public Mascota() {
    }

    public Mascota( int idDb, String name, int numeroLikes, int imageRef) {
        this.idDB=idDb;
        this.name = name;
        this.numeroLikes = numeroLikes;
        this.imageRef = imageRef;

    }

    public Mascota(String id, String name, int numeroLikes, String urlImage) {
        this.id=id;
        this.name = name;
        this.numeroLikes = numeroLikes;
        this.urlImage=urlImage;

    }


    public int getIdDB() {
        return idDB;
    }

    public void setIdDB(int idDB) {
        this.idDB = idDB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
