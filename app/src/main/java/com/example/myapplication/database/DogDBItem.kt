package com.example.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog_list")
data class DogDBItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val classification: String,
    val age: Int
)