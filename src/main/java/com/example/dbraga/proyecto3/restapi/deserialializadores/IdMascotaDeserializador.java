package com.example.dbraga.proyecto3.restapi.deserialializadores;

import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.restapi.JsonKeys;
import com.example.dbraga.proyecto3.restapi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbraga on 20/08/17.
 */

public class IdMascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize
            (JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json,MascotaResponse.class);
        JsonArray mascotaResponseData =
                json.getAsJsonObject().getAsJsonArray(JsonKeys.RESPONSE_ARRAY_MEDIA);

        mascotaResponse.setMascotas(deserializingMascota(mascotaResponseData));



        return mascotaResponse;
    }

    private List<Mascota> deserializingMascota(JsonArray mascotaResponseData){

        List <Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i <mascotaResponseData.size() ; i++) {

            JsonObject mascotaResponseDataObject
                    = mascotaResponseData.get(i).getAsJsonObject();



            String id = mascotaResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String url = mascotaResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();
            String name =mascotaResponseDataObject.get(JsonKeys.JSON_FULL_NAME).getAsString();


            Mascota mascota = new Mascota();

            mascota.setId(id);
            mascota.setUrlImage(url);
            mascota.setName(name);


            mascotas.add(mascota);


        }

        return mascotas;
    }
}
