package com.example.dbraga.proyecto3.presenters.impl;

import android.content.Context;

import com.example.dbraga.proyecto3.dao.IMascotasDao;
import com.example.dbraga.proyecto3.dao.impl.MascotasDaoImpl;
import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.presenters.IRecyclerViewFragmentPresenter;
import com.example.dbraga.proyecto3.views.fragments.viewmodel.IRecyclerViewFragmentViewModel;

import java.util.List;

/**
 * Created by dbraga on 30/07/17.
 */

public class RecyclerViewFragmentPresenterImpl implements IRecyclerViewFragmentPresenter {

    private Context context;
    private IRecyclerViewFragmentViewModel iRecyclerViewFragmentViewModel;
    private IMascotasDao iMascotasDao;

    public RecyclerViewFragmentPresenterImpl
            (IRecyclerViewFragmentViewModel iRecyclerViewFragmentViewModel,Context context) {
        this.iRecyclerViewFragmentViewModel=iRecyclerViewFragmentViewModel;
        this.context=context;
        iMascotasDao=new MascotasDaoImpl(context);

        obtainMascotas();

    }



    @Override
    public void obtainMascotas() {



        List<Mascota> mascotas =iMascotasDao.getAllMascotas();


        presenterMascotas(mascotas);

    }

    @Override
    public void presenterMascotas(List<Mascota> favoritesMascotas) {
        iRecyclerViewFragmentViewModel.initRecyclerView();
        iRecyclerViewFragmentViewModel.setRecyclerViewData(favoritesMascotas);

    }

    @Override
    public void ratingMascota(Mascota mascota) {
        iMascotasDao.ratingMascota(mascota);
        iRecyclerViewFragmentViewModel.recyclerViewReload();

    }




}
