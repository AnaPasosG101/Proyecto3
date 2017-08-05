package com.example.dbraga.proyecto3.database;

/**
 * Created by dbraga on 31/07/17.
 */

public class DatabaseContract {

    private DatabaseContract(){

    };

    public final class DatabaseConstants{

        /*************Database instance data**********/
        public static final String DATABASE_NAME = "petagram";
        public static final int DATABASE_VERSION = 1;

        /*************Mascotas Table*****************/
        public static final String MASCOTAS_TABLE_NAME = "mascotas";
        public static final String MASCOTAS_ID_SPAN= "id";
        public static final String MASCOTAS_NAME_SPAN = "name";
        public static final String MASCOTAS_LIKES_SPAN = "likes";
        public static final String MASCOTAS_IMG_REF_SPAN = "img";


    }

}
