package com.example.dbraga.proyecto3.presenters.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.presenters.IPerfilFragmentPresenter;
import com.example.dbraga.proyecto3.restapi.EndpointApi;
import com.example.dbraga.proyecto3.restapi.adapter.RestApiAdapter;
import com.example.dbraga.proyecto3.restapi.model.MascotaResponse;
import com.example.dbraga.proyecto3.views.fragments.viewmodel.IPerfilFragmentViewModel;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dbraga on 19/08/17.
 */

public class PerfilFragmentPresenterImpl implements IPerfilFragmentPresenter {
    private IPerfilFragmentViewModel viewModel;
    private Context context;
    private List<Mascota> mascotas;


    public PerfilFragmentPresenterImpl(IPerfilFragmentViewModel viewModel, Context context) {
        this.viewModel = viewModel;
        this.context = context;
        obtenerDatos();


    }

    @Override
    public void presentarInterfaz() {
        viewModel.setLayoutManager();
        viewModel.initRecyclerView(mascotas);

    }

    @Override
    public void obtenerDatos() {
        SharedPreferences prefs =
                context.getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);


        String id = prefs.getString("userId", "self");
        String url = prefs.getString("photoUrl","https://www.instagram.com/p/BW2ao5EBQUP/?hl=es&taken-by=perro_de_agua1");
        String name= prefs.getString("userName", "Not found");

        viewModel.initUser(name,url);

        Log.d("Dbra",id);

        RestApiAdapter adapter = new RestApiAdapter();


        Gson mediaGson= adapter.buildGsonDeserializerMediaRecent();
        EndpointApi endpointApi = adapter.establecerConexionRestApiInstagram(mediaGson);
        Call<MascotaResponse> mascotasResponseCall= endpointApi.getRecentMedia(id);
        mascotasResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas=mascotaResponse.getMascotas();
                presentarInterfaz();



            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

                //Toast o Log

            }
        });

    }
}
