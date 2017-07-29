package com.example.dbraga.proyecto3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    List<Mascota> mascotas;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ImageButton favoritosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);



            toolbar = (Toolbar) findViewById(R.id.miActionBar);


            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            favoritosButton = (ImageButton) findViewById(R.id.toolbarFavoritesButton);


            recyclerView = (RecyclerView) findViewById(R.id.mascotasRecyclerView);

           mascotas=new ArrayList<>();

           readExtras();


            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(llm);

            MascotaRecyclerViewAdapter adapter =
                    new MascotaRecyclerViewAdapter(mascotas,this,null);

            recyclerView.setAdapter(adapter);


        }


    @Override
    protected void onResume() {
        super.onResume();
        MascotaRecyclerViewAdapter adapter=new MascotaRecyclerViewAdapter(mascotas,this,null);
        recyclerView.setAdapter(adapter);
    }

    private void readExtras() {
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null) {
            for (int i = 0; i <5; i++) {
                Mascota mascota=new Mascota();
                mascota.setName(bundle.getString("mascota"+i+"name"));
                mascota.setImageRef(bundle.getInt("mascota"+i+"foto"));
                mascota.setNumeroLikes(bundle.getInt("mascota"+i+"likes"));

                mascotas.add(mascota);

            }
        }
    }

}
