package com.grupo04.huellitas.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import java.util.*

@Entity(tableName = "VaccineXPet",
    primaryKeys = arrayOf("vacunaID","mascotaID"),
    foreignKeys = [ForeignKey(entity = Vaccine::class,
        parentColumns = ["idVaccine"], childColumns = ["id_vaccine"]),
    ForeignKey(entity = Pet::class, parentColumns = ["idPet"],
        childColumns = ["id_pet"])])
data class VaccineXPetJOIN(var vacunaID:Int, var mascotaID:Int,
                           @ColumnInfo(name = "Date_Of_Application")
                           val dateOfApplication: Date
)
