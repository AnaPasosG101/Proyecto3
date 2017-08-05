package com.example.dbraga.proyecto3.dao;

import com.example.dbraga.proyecto3.database.DatabaseHelper;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.List;

/**
 * Created by dbraga on 31/07/17.
 */

public interface IMascotasDao {

    List <Mascota> getAllMascotas();

    List <Mascota> getFavoritesMascotas();

    void ratingMascota(Mascota mascota);


}
