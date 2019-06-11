package com.grupo04.huellitas.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "UserXArticle",
    primaryKeys = arrayOf("userID", "articleID"),
    foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = ["idUser"], childColumns = ["id_user"]),
    ForeignKey(entity = Article::class,parentColumns = ["idArticle"],
        childColumns = ["id_article"])])
data class UserXArticleJOIN (var userID:Int, var articleID:Int)
