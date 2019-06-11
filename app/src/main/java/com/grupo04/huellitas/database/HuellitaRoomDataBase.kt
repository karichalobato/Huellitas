package com.grupo04.huellitas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grupo04.huellitas.database.daos.*
import com.grupo04.huellitas.database.entities.*

@Database(entities = [User::class,
    Pet::class,
    Article::class,
    Tag::class,
    Vaccine::class], version = 1, exportSchema = false)
public abstract class HuellitaRoomDataBase : RoomDatabase() {

    abstract fun userDAO():UserDAO
    abstract fun petDAO(): PetDAO
    abstract fun articleDAO(): ArticleDAO
    abstract fun tagDAO(): TagDAO
    abstract fun vaccineDAO(): VaccineDAO

    companion object{
        @Volatile
        private var INSTANCE: HuellitaRoomDataBase? = null

        fun getInstance(
            context: Context
        ): HuellitaRoomDataBase{
            val temInstance = INSTANCE
            if(temInstance != null){
                return temInstance
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, HuellitaRoomDataBase::class.java,
                        "Huellitas_DataBase")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}