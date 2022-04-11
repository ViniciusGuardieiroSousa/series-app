package br.com.vinicius.guardieiro.sousa.series.di

import android.content.Context
import androidx.room.Room
import br.com.vinicius.guardieiro.sousa.commons.data.database.AppDatabase
import br.com.vinicius.guardieiro.sousa.commons.data.database.FavoriteDAO
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { provideDataBase(androidContext()) }
    single<FavoriteDAO> { provideDao(get()) }
}

fun provideDataBase(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, "favorite_db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}

fun provideDao(dataBase: AppDatabase): FavoriteDAO {
    return dataBase.favoriteDAO()
}