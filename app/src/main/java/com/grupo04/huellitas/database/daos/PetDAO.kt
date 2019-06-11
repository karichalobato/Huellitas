package com.grupo04.huellitas.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grupo04.huellitas.database.entities.Pet
import retrofit2.http.DELETE

@Dao
interface PetDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(pet: Pet)

    @Query("SELECT * FROM Pet WHERE name==:name")
    fun geyPetByName(name:String):LiveData<List<Pet>>

    //TODO BORRA SEGUN EL ID DE LA MASCOTA
    @Query("DELETE FROM Pet WHERE idPet==:idPet")
    fun deletePetByID(idPet: Int):LiveData<List<Pet>>

    @Query("DELETE FROM Pet")
    fun deletePets()
}