package com.example.dbraga.proyecto3.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.activities.MainActivity;
import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;
import com.example.dbraga.proyecto3.listeners.OnMascotasRequiredListener;
import com.example.dbraga.proyecto3.listeners.OnRecyclerViewReloadListener;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements OnRecyclerViewReloadListener {



    private RecyclerView recyclerView;

    private List<Mascota> mascotas;

    private MascotaRecyclerViewAdapter adapter;






    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        if(getActivity() instanceof MainActivity) {

            mascotas = ((MainActivity)getActivity()).onMascotasRequired();
        }
        recyclerView = (RecyclerView) v.findViewById(R.id.mascotasRecyclerView);




        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        adapter = new MascotaRecyclerViewAdapter(mascotas,getActivity(),this);

        recyclerView.setAdapter(adapter);

        return v;
    }


    @Override
    public void onRecyclerViewReload(List<Mascota> mascotas) {
        this.mascotas=mascotas;
        adapter.notifyDataSetChanged();


    }
}
