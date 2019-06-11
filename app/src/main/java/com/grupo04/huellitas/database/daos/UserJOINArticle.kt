package com.grupo04.huellitas.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.grupo04.huellitas.database.entities.Article
import com.grupo04.huellitas.database.entities.User

@Dao
interface UserJOINArticle {

    @Query("SELECT * FROM User INNER JOIN UserXArticle ON User.idUser = UserXArticle.userID WHERE UserXArticle.articleID=:userID")
    fun getUserOfArticles(userID:Int):LiveData<List<User>>

    @Query("SELECT * FROM Article INNER JOIN UserXArticle ON Article.idArticle = UserXArticle.articleID WHERE UserXArticle.articleID=:articleID")
    fun getArticlesOfUsers(articleID:Int):LiveData<List<Article>>
}