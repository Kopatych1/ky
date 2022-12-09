package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DogDao {

    @Query("SELECT * FROM dog_list ORDER BY id")
    fun getDogList(): LiveData<List<DogDBItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDogItem(dog: DogDBItem)
}