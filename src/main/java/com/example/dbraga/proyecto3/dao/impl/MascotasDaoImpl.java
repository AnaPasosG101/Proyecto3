package com.example.dbraga.proyecto3.dao.impl;

import android.content.ContentValues;
import android.content.Context;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.dao.IMascotasDao;
import com.example.dbraga.proyecto3.database.DatabaseContract;
import com.example.dbraga.proyecto3.database.DatabaseHelper;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbraga on 31/07/17.
 */

public class MascotasDaoImpl implements IMascotasDao {

    private Context context;

    public MascotasDaoImpl(Context context) {
        this.context = context;
    }

    @Override
    public List<Mascota> getAllMascotas() {
        DatabaseHelper db = new DatabaseHelper(context);

        return db.getAllMascotas();
    }

    @Override
    public List<Mascota> getFavoritesMascotas() {
        DatabaseHelper db = new DatabaseHelper(context);

        return db.getFavoritesMascotas();
    }

    @Override
    public void ratingMascota(Mascota mascota) {
        DatabaseHelper db = new DatabaseHelper(context);
        String []arg ={String.valueOf(mascota.getId())};
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.DatabaseConstants.MASCOTAS_LIKES_SPAN,mascota.getNumeroLikes()+1);

        db.ratingMascota(cv,arg);

    }


}
