package com.example.dbraga.proyecto3.presenters.impl;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.dbraga.proyecto3.dao.IMascotasDao;
import com.example.dbraga.proyecto3.dao.impl.MascotasDaoImpl;
import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.presenters.IFavoritesActivityPresenter;
import com.example.dbraga.proyecto3.views.activities.FavoritesActivity;
import com.example.dbraga.proyecto3.views.activities.viewmodel.IFavoritesActivityViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbraga on 30/07/17.
 */

public class FavoritesActivityPresenterImpl implements IFavoritesActivityPresenter {

    private IFavoritesActivityViewModel iFavoritesActivityViewModel;
    private Context context;
    private IMascotasDao mascotasDao;

    public FavoritesActivityPresenterImpl
            (IFavoritesActivityViewModel iFavoritesActivityViewModel, Context context){

        this.context=context;
        this.iFavoritesActivityViewModel=iFavoritesActivityViewModel;
        mascotasDao=new MascotasDaoImpl(context);

        obtainFavoritesMascotas();


    }

    @Override
    public void obtainFavoritesMascotas() {
        List <Mascota> favoritesMascotas=mascotasDao.getFavoritesMascotas();
        presenterFavoritesMascotas(favoritesMascotas);

    }

    @Override
    public void presenterFavoritesMascotas(List <Mascota> favoritesMascotas) {
        iFavoritesActivityViewModel.setToolbar();

        iFavoritesActivityViewModel.initRecyclerView();
        iFavoritesActivityViewModel.setRecyclerViewData(favoritesMascotas);

    }
}
