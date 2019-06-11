package com.grupo04.huellitas.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grupo04.huellitas.database.entities.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:User)

    @Query("SELECT * FROM User WHERE name==:name")
    fun getUserByName(name: String): LiveData<List<User>>

    @Query("SELECT * FROM User")
    fun getAllUsers():LiveData<List<User>>

}