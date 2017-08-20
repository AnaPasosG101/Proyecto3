package com.example.dbraga.proyecto3.views.fragments.viewmodel;

import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.List;

/**
 * Created by dbraga on 19/08/17.
 */

public interface IPerfilFragmentViewModel {
    void initRecyclerView(List<Mascota> mascotas);

    void setLayoutManager();

    void initUser(String name, String url);
}
