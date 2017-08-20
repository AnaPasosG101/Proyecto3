package com.example.dbraga.proyecto3.restapi;

import com.example.dbraga.proyecto3.pojo.Mascota;
import com.example.dbraga.proyecto3.restapi.model.MascotaResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dbraga on 19/08/17.
 */

public interface EndpointApi {

    /*@GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
}*/


    @GET(RestApiConstants.URL_GET_USER_MEDIA_RECENT_1+"{id}"+RestApiConstants.URL_GET_USER_MEDIA_RECENT_2)
    Call<MascotaResponse> getRecentMedia(@Path("id") String id);

    @GET(RestApiConstants.URL_GET_USER_ID_1)
    Call<MascotaResponse> getUserID(@Query("q") String name, @Query("access_token") String accessToken);
}
