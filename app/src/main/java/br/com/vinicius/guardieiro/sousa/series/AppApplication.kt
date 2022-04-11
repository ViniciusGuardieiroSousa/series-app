package br.com.vinicius.guardieiro.sousa.series

import android.app.Application
import br.com.vinicius.guardieiro.sousa.detailfeature.data.di.detailModules
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.di.favoriteModules
import br.com.vinicius.guardieiro.sousa.listseries.di.listModules
import br.com.vinicius.guardieiro.sousa.searchfeature.di.searchModules
import br.com.vinicius.guardieiro.sousa.series.di.databaseModule
import br.com.vinicius.guardieiro.sousa.series.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(
                listOf(
                    networkModule,
                    searchModules,
                    listModules,
                    detailModules,
                    databaseModule,
                    favoriteModules
                )
            )
        }
    }
}