package com.example.dbraga.proyecto3.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;
import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.presenters.IFavoritesActivityPresenter;
import com.example.dbraga.proyecto3.presenters.impl.FavoritesActivityPresenterImpl;
import com.example.dbraga.proyecto3.views.activities.viewmodel.IFavoritesActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements IFavoritesActivityViewModel{

    List<Mascota> mascotas;
    private Toolbar toolbar;
    private ImageButton favoritosButton;
    private RecyclerView recyclerView;
    private IFavoritesActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerView = (RecyclerView) findViewById(R.id.mascotasRecyclerView);

        presenter=new FavoritesActivityPresenterImpl(this,getApplicationContext());

    }

     @Override
     public void setToolbar(){
       toolbar = (Toolbar) findViewById(R.id.miActionBar);


       setSupportActionBar(toolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initRecyclerView(){


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

    }

    @Override
    public void setRecyclerViewData(List<Mascota> favoritesMascotas){

        MascotaRecyclerViewAdapter adapter =
                new MascotaRecyclerViewAdapter(favoritesMascotas,this,null);

        recyclerView.setAdapter(adapter);


    }




}
