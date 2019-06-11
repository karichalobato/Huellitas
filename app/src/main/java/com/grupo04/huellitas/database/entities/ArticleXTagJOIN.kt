package com.grupo04.huellitas.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "ArticleXTag",
    primaryKeys = arrayOf("articleID","tagID"),
    foreignKeys = [ForeignKey(entity = Article::class,
        parentColumns = ["idArticle"], childColumns = ["id_article"]),
    ForeignKey(entity = Tag::class,
        parentColumns = ["idTag"],childColumns = ["id_tag"])])
data class ArticleXTagJOIN(var articleID:Int, var tagID:Int)