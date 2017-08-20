package com.example.dbraga.proyecto3.presenters.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.presenters.IConfigActivityPresenter;
import com.example.dbraga.proyecto3.restapi.EndpointApi;
import com.example.dbraga.proyecto3.restapi.RestApiConstants;
import com.example.dbraga.proyecto3.restapi.adapter.RestApiAdapter;
import com.example.dbraga.proyecto3.restapi.model.MascotaResponse;
import com.example.dbraga.proyecto3.views.activities.viewmodel.IConfigActivityViewModel;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dbraga on 20/08/17.
 */

public class CofigActivityPresenterImpl implements IConfigActivityPresenter {

    private IConfigActivityViewModel viewModel;
    private Context context;

    public CofigActivityPresenterImpl(IConfigActivityViewModel viewModel, Context context) {
        this.viewModel = viewModel;
        this.context = context;
        presentarIntefaz();
    }

    @Override
    public void presentarIntefaz() {
        viewModel.validar();

    }

    @Override
    public void obtenerID(String name) {
        Log.d("Dbra", name);
        RestApiAdapter adapter = new RestApiAdapter();


        Gson idGson= adapter.buildGSONDeserializerUserId();
        EndpointApi endpointApi = adapter.establecerConexionRestApiInstagram(idGson);
        Call<MascotaResponse> mascotasResponseCall
                = endpointApi.getUserID(name, RestApiConstants.ACCESS_TOKEN);
        mascotasResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                List<Mascota> mascotas = mascotaResponse.getMascotas();
                if (mascotas == null || mascotas.size() == 0) {
                    Toast.makeText(context, "El usuario no existe", Toast.LENGTH_SHORT).show();
                } else if (mascotas.size() > 1) {
                    Toast.makeText
                            (context, "Hay mas de un usuario con ese nombre", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences prefs =
                            context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("userId", mascotas.get(0).getId());
                    editor.putString("photoUrl", mascotas.get(0).getUrlImage());
                    editor.putString("userName", mascotas.get(0).getName());
                    Log.d("Dbra",mascotas.get(0).getId());
                    editor.apply();

                }
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

                Log.d("dbra",t.getMessage());
                //Toast o Log

            }
        });

    }

    @Override
    public void onBackPresed() {
        viewModel.setBack();
    }

}

