package br.com.vinicius.guardieiro.sousa.commons.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDAO(): FavoriteDAO
}

