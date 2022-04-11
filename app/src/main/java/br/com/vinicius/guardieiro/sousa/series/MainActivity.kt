package br.com.vinicius.guardieiro.sousa.series

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.activity.DetailSeriesActivity
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.fragment.FavoriteFragment
import br.com.vinicius.guardieiro.sousa.searchfeature.di.searchModules
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment.ListSeriesFragment
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment.SearchFragment
import br.com.vinicius.guardieiro.sousa.series.di.networkModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules


class MainActivity : AppCompatActivity() {

    private val onItemClickListener: (Long) -> Unit ={
        startActivity(DetailSeriesActivity.getIntent(this, it))
    }

    init {
        loadKoinModules(listOf(networkModule, searchModules))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, FavoriteFragment.newInstance(onItemClickListener), "search")
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(networkModule, searchModules))

    }
}