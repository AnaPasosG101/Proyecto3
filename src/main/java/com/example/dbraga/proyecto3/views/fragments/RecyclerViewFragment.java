package com.example.dbraga.proyecto3.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.listeners.OnMascotaIsRatedListener;
import com.example.dbraga.proyecto3.presenters.IRecyclerViewFragmentPresenter;
import com.example.dbraga.proyecto3.presenters.impl.RecyclerViewFragmentPresenterImpl;
import com.example.dbraga.proyecto3.views.activities.MainActivity;
import com.example.dbraga.proyecto3.adapters.MascotaRecyclerViewAdapter;

import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.views.fragments.viewmodel.IRecyclerViewFragmentViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment
        implements IRecyclerViewFragmentViewModel
        , OnMascotaIsRatedListener
         {


    private RecyclerView recyclerView;
    private View v;
    private IRecyclerViewFragmentPresenter presenter;
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
        v = inflater.inflate(R.layout.fragment_lista, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.mascotasRecyclerView);

        presenter = new RecyclerViewFragmentPresenterImpl(this, getContext());

        return v;
    }


    @Override
    public void initRecyclerView() {

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }


    @Override
    public void setRecyclerViewData(List<Mascota> mascotas) {
        adapter =
                new MascotaRecyclerViewAdapter(mascotas, getActivity(), this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void recyclerViewReload() {
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onMascotaIsRated(Mascota mascota) {
        presenter.ratingMascota(mascota);

    }



}



