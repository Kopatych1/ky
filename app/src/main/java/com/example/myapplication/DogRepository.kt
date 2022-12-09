package com.example.myapplication

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.DogDBItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogRepository(
    private val application: Application
) {

    private val scope = CoroutineScope(Dispatchers.Default)

    private val dogDao = AppDatabase.getInstance(application).dogDao()

    fun getDogList(): LiveData<List<DogDBItem>> {
        return dogDao.getDogList()
    }

    fun insertDog(nameDog: String, classificationDog: String, ageDog: Int) {
        scope.launch {
            var i = 0
            while (i < 1) {
                val dogDbItem = DogDBItem(
                    id = 0,
                    name = nameDog,
                    classification = classificationDog,
                    age = ageDog
                )
                dogDao.insertDogItem(dogDbItem)
                i += 1
            }
        }
    }
}