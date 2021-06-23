package com.simplest.uniapproomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Client.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DataAccessObject Dao();
}

