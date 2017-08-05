package com.example.dbraga.proyecto3.views.fragments.viewmodel;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.List;

/**
 * Created by dbraga on 30/07/17.
 */

public interface IRecyclerViewFragmentViewModel {

    public void initRecyclerView();

    public void setRecyclerViewData(List<Mascota> mascotas);

    void recyclerViewReload();
}
