package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.BaseFragment
import br.com.vinicius.guardieiro.sousa.searchfeature.databinding.FragmentSearchBinding
import br.com.vinicius.guardieiro.sousa.searchfeature.di.searchModules
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.recyclerview.SearchAdapter
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.viewModel.EitherSearchSeriesModel
import br.com.vinicius.guardieiro.sousa.searchfeature.presentation.viewModel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class SearchFragment : BaseFragment(listOf(searchModules)) {

    companion object {
        @JvmStatic
        fun newInstance(onItemClickListener: (Long) -> Unit) =
            SearchFragment().apply {
                setClickListener(onItemClickListener)
            }
    }

    private val viewModel by viewModel<SearchViewModel>()
    private lateinit var binding: FragmentSearchBinding
    private val adapter: SearchAdapter = SearchAdapter()


    fun setClickListener(listener: (Long) -> Unit) {
        onItemClickListener = listener
        adapter.itemClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSearch()
        setUpRecyclerView()
        setUpLoadState()
    }

    private fun setUpSearch() {
        binding.searchSearchView.doOnTextChanged { text, start, before, count ->
            viewModel.searchSeriesByName(text.toString())
        }
    }

    private fun setUpRecyclerView() {
        binding.listSeriesRecyclerView.layoutManager = GridLayoutManager(this.requireActivity(), 3)
        binding.listSeriesRecyclerView.adapter = adapter
        viewModel.seriesPresentationList.observe(viewLifecycleOwner) {
            when (it) {
                is EitherSearchSeriesModel.Right -> {
                    adapter.addList(it.value)
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "We have some problem searching this series :(",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun setUpLoadState() {
        viewModel.loadState.observe(viewLifecycleOwner) {
            if (it) {
                binding.seriesProgress.visibility = View.VISIBLE
            } else {
                binding.seriesProgress.visibility = View.GONE

            }
        }
    }
}
