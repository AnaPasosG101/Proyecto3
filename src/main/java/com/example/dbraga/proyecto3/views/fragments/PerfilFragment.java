package com.example.dbraga.proyecto3.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;
import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.presenters.IPerfilFragmentPresenter;
import com.example.dbraga.proyecto3.presenters.impl.PerfilFragmentPresenterImpl;
import com.example.dbraga.proyecto3.views.fragments.viewmodel.IPerfilFragmentViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PerfilFragment extends Fragment implements IPerfilFragmentViewModel{




    private RecyclerView recyclerView;

    private TextView nombreTextView;

    private ImageView imageViewPerfil;

    private IPerfilFragmentPresenter presenter;




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
        recyclerView = (RecyclerView) v.findViewById(R.id.perfilRecyclerView);
        nombreTextView = (TextView) v.findViewById(R.id.nombrePerfilTextView);

        nombreTextView.setText("Perro de agua");

        imageViewPerfil = (ImageView) v.findViewById(R.id.imageViewPerfil);
        presenter=new PerfilFragmentPresenterImpl(this,getContext());







        return v;
    }

    public void initRecyclerView(List<Mascota>mascotas) {
        MascotaRecyclerViewAdapter adapter =
                new MascotaRecyclerViewAdapter(mascotas,getActivity(),this);

        recyclerView.setAdapter(adapter);
    }

    public void setLayoutManager() {
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(glm);
    }

    public void initUser(String name, String url){
        nombreTextView.setText(name);
        Picasso.with(getContext()).load(url)
                .placeholder(R.drawable.perro)
                .into(imageViewPerfil);


    }


}