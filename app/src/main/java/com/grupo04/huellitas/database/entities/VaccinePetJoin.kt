package com.grupo04.huellitas.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "VaccineXPet",
    primaryKeys = arrayOf("vacunaID","mascotaID"),
    foreignKeys = [ForeignKey(entity = Vaccine::class,
        parentColumns = ["idVaccine"], childColumns = ["id_vaccine"]),
    ForeignKey(entity = Pet::class, parentColumns = ["idPet"],
        childColumns = ["id_pet"])])
data class VaccinePetJoin( var vacunaID:Int, var mascotaID:Int)
