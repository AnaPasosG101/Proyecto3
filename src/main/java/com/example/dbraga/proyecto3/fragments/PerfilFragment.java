package com.example.dbraga.proyecto3.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.activities.MainActivity;
import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PerfilFragment extends Fragment {


    private List<Mascota> mascotas;

    private RecyclerView recyclerView;

    private TextView nombreTextView;




    public PerfilFragment() {
        // Required empty public constructor
    }


    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_perfil, container, false);

        mascotas=new ArrayList<>();

        setDataPerfilMascotas();
        recyclerView = (RecyclerView) v.findViewById(R.id.perfilRecyclerView);




        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);




        recyclerView.setLayoutManager(glm);

        MascotaRecyclerViewAdapter adapter =
                new MascotaRecyclerViewAdapter(mascotas,getActivity(),this);

        recyclerView.setAdapter(adapter);

        nombreTextView = (TextView) v.findViewById(R.id.nombrePerfilTextView);

        nombreTextView.setText("Perro de agua");



        return v;
    }

    private void setDataPerfilMascotas() {
        Random random=new Random();



        for (int i = 0; i < 50; i++) {
            mascotas.add(new Mascota ("",random.nextInt(30),R.drawable.perrodeagua));
        }
    }
}