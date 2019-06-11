package com.grupo04.huellitas.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.grupo04.huellitas.database.entities.Article
import com.grupo04.huellitas.database.entities.Tag

@Dao
interface ArticleJOINTag {

    @Query("SELECT * FROM Article INNER JOIN ArticleXTag ON Article.idArticle = ArticleXTag.articleID WHERE ArticleXTag.tagID=:articleID")
    fun getArticleOfTags(articleID:Int):LiveData<List<Article>>

    @Query("SELECT * FROM Tag INNER JOIN ArticleXTag ON Tag.idTag = ArticleXTag.tagID WHERE ArticleXTag.tagID=:tagID")
    fun getTagsOfArticle(tagID:Int):LiveData<List<Tag>>

}