package com.grupo04.huellitas.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.grupo04.huellitas.database.entities.Pet
import com.grupo04.huellitas.database.entities.Vaccine

@Dao
interface VaccineJOINPet {

    @Query("SELECT * FROM Vaccine INNER JOIN VaccineXPet ON Vaccine.idVaccine = VaccineXPet.vacunaID WHERE VaccineXPet.mascotaID=:vacunaID")
    fun getVaccineOfPets(vacunaID:Int):LiveData<List<Vaccine>>

    @Query("SELECT * FROM Pet INNER JOIN VaccineXPet ON Pet.idPet = VaccineXPet.mascotaID WHERE VaccineXPet.mascotaID=:mascotaID")
    fun getPetsOfVaccines(mascotaID:Int):LiveData<List<Pet>>

    //LUEGO DE HABER SELECCIONADO UNA MASCOTA Y VER SUS VACUNAS SE PODRA FILTRAR SEGUN UN MES SELECCIONADO.
}