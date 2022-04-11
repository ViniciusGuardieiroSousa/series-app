package br.com.vinicius.guardieiro.sousa.searchfeature.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.BaseFragment
import br.com.vinicius.guardieiro.sousa.listseries.data.di.listModules
import br.com.vinicius.guardieiro.sousa.listseries.databinding.FragmentListBinding
import br.com.vinicius.guardieiro.sousa.listseries.presentation.view.recyclerview.ListSeriesAdapter
import br.com.vinicius.guardieiro.sousa.listseries.presentation.viewModel.EitherListSeriesPresentationModel
import br.com.vinicius.guardieiro.sousa.listseries.presentation.viewModel.ListSeriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class ListSeriesFragment : BaseFragment(listOf(listModules)) {

    companion object {
        @JvmStatic
        fun newInstance(onItemClickListener: (Long) -> Unit) =
            ListSeriesFragment().also {
                it.setClickListener(onItemClickListener)
            }
    }

    private val viewModel by viewModel<ListSeriesViewModel>()

    private lateinit var binding: FragmentListBinding
    private val adapter: ListSeriesAdapter = ListSeriesAdapter()

    fun setClickListener(listener : (Long) -> Unit){
        onItemClickListener = listener
        adapter.itemClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel.getNextPage()
        setUpLoadState()
    }

    private fun setUpRecyclerView() {
        binding.listSeriesRecyclerView.layoutManager = GridLayoutManager(this.requireActivity(), 3)
        binding.listSeriesRecyclerView.adapter = adapter
        viewModel.series.observe(viewLifecycleOwner) {
            when (it) {
                is EitherListSeriesPresentationModel.Right -> {
                    adapter.addList(it.value)
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "We have some problem to get the list of series :(",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        pagination()
    }

    private fun pagination() {
        binding.listSeriesRecyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    try {
                        viewModel.getNextPage()
                    } catch (e: Exception) {
                        Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
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