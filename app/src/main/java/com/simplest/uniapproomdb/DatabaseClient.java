package com.simplest.uniapproomdb;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private Context context;
    private static DatabaseClient mInstance;

    //our app database object
    private AppDataBase appDataBase;

    private DatabaseClient(Context context) {
        this.context = context;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDataBase = Room.databaseBuilder(context, AppDataBase.class, "MyToDos")
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);


        }
        return mInstance;
    }

    public AppDataBase getAppDataBase() {
        return appDataBase;
    }
}



