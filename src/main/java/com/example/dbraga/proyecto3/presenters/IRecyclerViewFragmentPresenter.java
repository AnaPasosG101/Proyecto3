package com.example.dbraga.proyecto3.presenters;

import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.List;

/**
 * Created by dbraga on 30/07/17.
 */

public interface IRecyclerViewFragmentPresenter {
    public void obtainMascotas();

    public void presenterMascotas(List<Mascota> favoritesMascotas );

    void ratingMascota(Mascota mascota);



}
