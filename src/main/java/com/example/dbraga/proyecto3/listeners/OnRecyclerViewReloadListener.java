package com.example.dbraga.proyecto3.listeners;

import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.List;

/**
 * Created by dbraga on 29/07/17.
 */

public interface OnRecyclerViewReloadListener {

    void onRecyclerViewReload (List<Mascota> mascotas);
}
