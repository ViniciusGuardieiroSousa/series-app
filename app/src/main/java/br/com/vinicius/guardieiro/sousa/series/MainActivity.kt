package br.com.vinicius.guardieiro.sousa.series

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.BaseFragment
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.activity.DetailSeriesActivity
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.fragment.FavoriteFragment
import br.com.vinicius.guardieiro.sousa.searchfeature.di.searchModules
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment.ListSeriesFragment
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment.SearchFragment
import br.com.vinicius.guardieiro.sousa.series.databinding.ActivityMainBinding
import br.com.vinicius.guardieiro.sousa.series.di.networkModule
import com.google.android.material.navigation.NavigationBarView
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private val onItemClickListener: (Long) -> Unit = {
        startActivity(DetailSeriesActivity.getIntent(this, it))
    }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    init {
        loadKoinModules(listOf(networkModule, searchModules))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navigationView.setOnItemSelectedListener(this)
        binding.navigationView.selectedItemId = R.id.navigation_list
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(networkModule, searchModules))

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_list -> {
                initFragment(
                    ListSeriesFragment.newInstance(onItemClickListener)
                )
                true
            }
            R.id.navigation_search -> {
                initFragment(
                    SearchFragment.newInstance(onItemClickListener)
                )
                true
            }
            R.id.navigation_favorite -> {
                initFragment(
                    FavoriteFragment.newInstance(onItemClickListener),
                )
                true
            }
            else -> {
                false
            }
        }
    }

    private fun initFragment(fragment: BaseFragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

}