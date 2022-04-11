package br.com.vinicius.guardieiro.sousa.series.di

import br.com.vinicius.guardieiro.sousa.commons.data.network.RetrofitConfig.provideOkHttpClient
import br.com.vinicius.guardieiro.sousa.commons.data.network.RetrofitConfig.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}




