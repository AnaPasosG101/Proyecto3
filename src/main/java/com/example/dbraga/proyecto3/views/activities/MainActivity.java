package com.example.dbraga.proyecto3.views.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.adapters.MascotasPagerAdapter;
import com.example.dbraga.proyecto3.views.fragments.PerfilFragment;
import com.example.dbraga.proyecto3.views.fragments.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   // private List<Mascota> mascotas;

    private Toolbar toolbar;
    private ImageButton favoritosButton;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RecyclerViewFragment recyclerViewFragment;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.mascotasViewPager);

        setSupportActionBar(toolbar);

        //mascotas=new ArrayList<>();

        //setMascotasData();

        setFavorites();

        setUpViewPager();






    }


    private void setFavorites() {
        favoritosButton = (ImageButton) findViewById(R.id.toolbarFavoritesButton);
        favoritosButton.setVisibility(View.VISIBLE);
        favoritosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), FavoritesActivity.class);


                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.acerca_de:
                Intent intentAcerca = new Intent (getApplicationContext(),AcercaActivity.class);
                startActivity(intentAcerca);
                break;
            case R.id.contacto:
                Intent intentContacto = new Intent (getApplicationContext(),ContactoActivity.class);
                startActivity(intentContacto);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void setFavorites() {
        favoritosButton = (ImageButton) findViewById(R.id.toolbarFavoritesButton);
        favoritosButton.setVisibility(View.VISIBLE);
        favoritosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();


                List<Mascota> mascotasFavoritas = new ArrayList<>();

                for (int i = 0; i < mascotas.size(); i++) {
                    if (i < 5) {
                        mascotasFavoritas.add(mascotas.get(i));

                    } else {
                        int minLikes = 200000;
                        int position = -1;
                        for (int j = 0; j < mascotasFavoritas.size(); j++) {
                            int likes = mascotasFavoritas.get(j).getNumeroLikes();
                            if (minLikes > likes) {
                                minLikes = likes;
                                position = j;
                            }

                        }
                        if (mascotas.get(i).getNumeroLikes() > minLikes) {
                            mascotasFavoritas.remove(position);
                            mascotasFavoritas.add(mascotas.get(i));
                        }
                    }


                }


                for (int i = 0; i < mascotasFavoritas.size(); i++) {
                    bundle.putString("mascota" + i + "name", mascotasFavoritas.get(i).getName());
                    bundle.putInt("mascota" + i + "foto", mascotasFavoritas.get(i).getImageRef());
                    bundle.putInt("mascota" + i + "likes", mascotasFavoritas.get(i).getNumeroLikes());


                }


                Intent intent = new Intent(getApplicationContext(), FavoritesActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }*/

    /*private void setMascotasData() {
        mascotas.add(new Mascota("Perro", 5, R.drawable.perro));
        mascotas.add(new Mascota("Perro Dos", 7, R.drawable.perro2));
        mascotas.add(new Mascota("Perro Tres", 3, R.drawable.perro3));
        mascotas.add(new Mascota("Perro Cuatro", 9, R.drawable.perro4));
        mascotas.add(new Mascota("Perro De Agua", 2, R.drawable.perrodeagua));
        mascotas.add(new Mascota("Gato", 5, R.drawable.gato1));
    }*/

    private List<Fragment> agregarFragments(){
        List<Fragment> fragments = new ArrayList <>();
        recyclerViewFragment=RecyclerViewFragment.newInstance();
        fragments.add(recyclerViewFragment);
        fragments.add(PerfilFragment.newInstance());
        return fragments;

    }


    private void setUpViewPager() {
        viewPager.setAdapter
                (new MascotasPagerAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab_lista);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_perfil);

    }









   /* public List<Mascota> getAllMascotas() {
        return mascotas;
    }*/
}