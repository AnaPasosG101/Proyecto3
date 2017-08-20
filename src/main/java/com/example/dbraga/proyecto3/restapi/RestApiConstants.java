package com.example.dbraga.proyecto3.restapi;

/**
 * Created by dbraga on 19/08/17.
 */

public final class RestApiConstants {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com"+VERSION;
    public static final String KEY_ACCESS_TOKEN ="?access_token=";
    public static final String  ACCESS_TOKEN = "5768735771.aee743c.0a42296b261746c596e951d16ae5e416";

    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_USERS = "users/";
    public static final String KEY_GET_USER_MEDIA_RECENT = "/media/recent/";
    public static final String URL_GET_USER_MEDIA_RECENT_1
            = ROOT_URL+KEY_GET_USERS;
    public static final String URL_GET_USER_MEDIA_RECENT_2
            = KEY_GET_USER_MEDIA_RECENT+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN
    //public static final String KEY_SEARCH = "search?q=";
    //public static final String KEY_ACCESS_TOKEN_FOR_SEARCH= "&access_token=";
    //public static final String URL_GET_USER_ID_1=ROOT_URL+KEY_GET_USERS+KEY_SEARCH;
    //public static final String URL_GET_USER_ID_2=KEY_ACCESS_TOKEN_FOR_SEARCH+ACCESS_TOKEN;
    public static final String KEY_SEARCH = "search?";
    public static final String URL_GET_USER_ID_1=ROOT_URL+KEY_GET_USERS+KEY_SEARCH;
}
