package com.simplest.uniapproomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataAccessObject {
    @Query("SELECT * FROM client")
    List<Client>getAll();

    @Insert
    void insert (Client client);

    @Delete
    void delete(Client client);

    @Update
    void update(Client client);

}
