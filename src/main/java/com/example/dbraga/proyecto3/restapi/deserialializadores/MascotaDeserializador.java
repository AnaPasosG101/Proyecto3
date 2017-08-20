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

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {


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

            JsonObject contactoResponseDataObject
                    = mascotaResponseData.get(i).getAsJsonObject();

            JsonObject userJson
                    = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER_JSON_OBJECT);

            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String name = userJson.get(JsonKeys.JSON_FULL_NAME).getAsString();


            JsonObject imageJson
                    = contactoResponseDataObject.getAsJsonObject(JsonKeys.IMAGES_JSON_OBJECT);
            JsonObject standardResolutionJson
                    = imageJson.getAsJsonObject(JsonKeys.STANDARD_RESOLUTION_JSON_OBJECT);

            String url = standardResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();


            JsonObject likesJson
                    = contactoResponseDataObject.getAsJsonObject(JsonKeys.LIKES_JSON_OBJECT);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES).getAsInt();

            Mascota mascota = new Mascota();
            mascota.setNumeroLikes(likes);
            mascota.setId(id);
            mascota.setName(name);
            mascota.setUrlImage(url);

            mascotas.add(mascota);


        }

        return mascotas;
    }
}
