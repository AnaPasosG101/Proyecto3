package com.example.dbraga.proyecto3.restapi.adapter;

import com.example.dbraga.proyecto3.restapi.EndpointApi;
import com.example.dbraga.proyecto3.restapi.RestApiConstants;
import com.example.dbraga.proyecto3.restapi.deserialializadores.IdMascotaDeserializador;
import com.example.dbraga.proyecto3.restapi.deserialializadores.MascotaDeserializador;
import com.example.dbraga.proyecto3.restapi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dbraga on 19/08/17.
 */

public class RestApiAdapter {

    public EndpointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(RestApiConstants.ROOT_URL).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        return retrofit.create(EndpointApi.class);

    }

    public Gson buildGsonDeserializerMediaRecent () {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }

    public Gson buildGSONDeserializerUserId(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new IdMascotaDeserializador());

        return gsonBuilder.create();
    }
}
