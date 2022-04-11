package br.com.vinicius.guardieiro.sousa.commons.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM FavoriteEntity")
    fun getAll(): List<FavoriteEntity>

    @Query("SELECT * FROM FavoriteEntity order by name")
    fun getAllOrderByName(): List<FavoriteEntity>

    @Query("SELECT * FROM FavoriteEntity WHERE id=:id ")
    fun getById(id: Long): FavoriteEntity?

    @Insert
    fun insert(favoriteSeries: FavoriteEntity)

    @Delete
    fun delete(favoriteSeries: FavoriteEntity)
}