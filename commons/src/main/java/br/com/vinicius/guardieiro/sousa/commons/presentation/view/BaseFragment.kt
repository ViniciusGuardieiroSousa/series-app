package br.com.vinicius.guardieiro.sousa.commons.presentation.view

import androidx.fragment.app.Fragment
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

open class BaseFragment(private val modules : List<Module>) : Fragment() {

    protected lateinit var onItemClickListener: (Long) -> Unit

    init {
        loadKoinModules(modules)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(modules)
    }
}