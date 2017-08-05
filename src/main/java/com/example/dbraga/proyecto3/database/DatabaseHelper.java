package com.example.dbraga.proyecto3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.dao.IMascotasDao;
import com.example.dbraga.proyecto3.dao.impl.MascotasDaoImpl;
import com.example.dbraga.proyecto3.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbraga on 31/07/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE ="CREATE TABLE IF NOT EXISTS";
    private static final String SPACE = " ";
    private static final String COMMA=",";
    private static final String VARCHAR_30 = "VARCHAR (30)";
    private static final String INTEGER = "INTEGER";
    private static final String PRIMARY_KEY = "PRIMARY KEY AUTOINCREMENT";
    private static final String APOSTROPH = "'";
    private static final String OFFENE_KLAMMER = "(";
    private static final String GESCHLOSSENE_KLAMMER=")";
    private static final String DROP_TABLE= "DROP TABLE IF EXIST";
    private static final String SELECT="SELECT";
    private static final String ASTERISCO="*";
    private static final String FROM="FROM";
    private static final String INSERT="INSERT";
    private static final String INTO="INTO";
    private static final String VALUES="VALUES";
    private static final String ORDER_BY="ORDER BY";
    private static final String DESC="DESC";
    private static final String LIMIT="LIMIT";



    private Context context;


    public DatabaseHelper(Context context) {
        super(context
                , DatabaseContract.DatabaseConstants.DATABASE_NAME
                , null
                , DatabaseContract.DatabaseConstants.DATABASE_VERSION);
        this.context=context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable= CREATE_TABLE+SPACE+ DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME
                +OFFENE_KLAMMER
                + DatabaseContract.DatabaseConstants.MASCOTAS_ID_SPAN+SPACE+INTEGER+SPACE
                +PRIMARY_KEY+COMMA+SPACE
                +DatabaseContract.DatabaseConstants.MASCOTAS_NAME_SPAN+SPACE+VARCHAR_30+COMMA+SPACE
                +DatabaseContract.DatabaseConstants.MASCOTAS_LIKES_SPAN+SPACE+INTEGER+COMMA+SPACE
                +DatabaseContract.DatabaseConstants.MASCOTAS_IMG_REF_SPAN+SPACE+INTEGER
                +GESCHLOSSENE_KLAMMER;

        db.execSQL(createTable);

        List <Mascota>mascotas= new ArrayList<>();
        mascotas.add(new Mascota(0,"Perro", 5, R.drawable.perro));
        mascotas.add(new Mascota(1,"Perro Dos", 7, R.drawable.perro2));
        mascotas.add(new Mascota(2,"Perro Tres", 3, R.drawable.perro3));
        mascotas.add(new Mascota(3,"Perro Cuatro", 9, R.drawable.perro4));
        mascotas.add(new Mascota(4,"Perro De Agua", 2, R.drawable.perrodeagua));
        mascotas.add(new Mascota(5,"Gato", 5, R.drawable.gato1));

        for (int i = 0; i <mascotas.size() ; i++) {
            String init_db = INSERT+SPACE+INTO+SPACE
                    +DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME+SPACE+OFFENE_KLAMMER
                    +DatabaseContract.DatabaseConstants.MASCOTAS_NAME_SPAN
                    +COMMA
                    +DatabaseContract.DatabaseConstants.MASCOTAS_LIKES_SPAN
                    +COMMA
                    +DatabaseContract.DatabaseConstants.MASCOTAS_IMG_REF_SPAN
                    +GESCHLOSSENE_KLAMMER+SPACE+VALUES+SPACE+OFFENE_KLAMMER
                    +APOSTROPH+mascotas.get(i).getName()+APOSTROPH
                    +COMMA
                    +mascotas.get(i).getNumeroLikes()
                    +COMMA
                    +mascotas.get(i).getImageRef()+GESCHLOSSENE_KLAMMER;

            db.execSQL(init_db);

        }




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable=DROP_TABLE+SPACE+ DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME;

        db.execSQL(dropTable);

        onCreate(db);

    }


    public List<Mascota> getAllMascotas(){

        List<Mascota>mascotas = new ArrayList<>();

        SQLiteDatabase db= getReadableDatabase();

        Cursor cursor=db.rawQuery(
                SELECT+SPACE+ASTERISCO+SPACE+FROM+SPACE
                        + DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME, null);

        while(cursor.moveToNext()){
            Mascota mascota=new Mascota();

            mascota.setId(cursor.getInt(0));
            mascota.setName(cursor.getString(1));
            mascota.setNumeroLikes(cursor.getInt(2));
            mascota.setImageRef(cursor.getInt(3));


            mascotas.add(mascota);
        }
        return mascotas;
    }

    public List <Mascota> getFavoritesMascotas(){

        List<Mascota> mascotas=new ArrayList <> ();

        SQLiteDatabase db=getReadableDatabase();

        String query=SELECT+SPACE+ASTERISCO+SPACE+FROM+SPACE
                + DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME+SPACE
                + ORDER_BY+SPACE+ DatabaseContract.DatabaseConstants.MASCOTAS_LIKES_SPAN+SPACE+DESC
                +SPACE+LIMIT+SPACE+5;

        Cursor cursor=db.rawQuery(query,null);


        while(cursor.moveToNext()){
            Mascota mascota=new Mascota();

            mascota.setId(cursor.getInt(0));
            mascota.setName(cursor.getString(1));
            mascota.setNumeroLikes(cursor.getInt(2));
            mascota.setImageRef(cursor.getInt(3));


            mascotas.add(mascota);
        }

        db.close();
        return mascotas;


    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME
                ,null
                ,contentValues
                );
        db.close();
    }

    public void ratingMascota(ContentValues contentValues,String [] arg){
        SQLiteDatabase db= getWritableDatabase();

        db.update(DatabaseContract.DatabaseConstants.MASCOTAS_TABLE_NAME,
                contentValues,
                "id=?",
                arg
                );
    }





}
