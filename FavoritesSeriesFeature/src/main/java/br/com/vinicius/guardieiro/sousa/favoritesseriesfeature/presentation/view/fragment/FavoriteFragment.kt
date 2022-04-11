package br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import br.com.vinicius.guardieiro.sousa.commons.presentation.view.BaseFragment
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.databinding.FragmentFavoriteBinding
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.di.favoriteModules
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.view.recyclerview.FavoriteAdapter
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.viewModel.EitherFavoritePresentationModel
import br.com.vinicius.guardieiro.sousa.favoritesseriesfeature.presentation.viewModel.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment(listOf(favoriteModules)) {

    companion object {
        @JvmStatic
        fun newInstance(onItemClickListener: (Long) -> Unit) =
            FavoriteFragment().apply {
                setClickListener(onItemClickListener)
            }
    }

    private val viewModel by viewModel<FavoriteViewModel>()
    private lateinit var binding: FragmentFavoriteBinding
    private val adapter: FavoriteAdapter = FavoriteAdapter()

    fun setClickListener(listener: (Long) -> Unit) {
        onItemClickListener = listener
        adapter.itemClickListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpLoadState()
        setUpSwitch()
    }

    private fun setUpSwitch() {
        binding.favoriteOrder.isChecked = false
        viewModel.getAllFavorites()
        binding.favoriteOrder.setOnCheckedChangeListener { compoundButton, boolean ->
            if (boolean) {
                viewModel.getAllFavoritesOrderByName()
            } else {
                viewModel.getAllFavorites()
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.favoriteRecyclerView.layoutManager = GridLayoutManager(this.requireActivity(), 3)
        binding.favoriteRecyclerView.adapter = adapter
        viewModel.seriesPresentationList.observe(viewLifecycleOwner) {
            when (it) {
                is EitherFavoritePresentationModel.Right -> {
                    adapter.addList(it.value)
                }
                else -> {
                    Toast.makeText(
                        requireContext(),
                        "We have some problem to list favorite :(",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun setUpLoadState() {
        viewModel.loadState.observe(viewLifecycleOwner) {
            if (it) {
                binding.favoriteProgress.visibility = View.VISIBLE
            } else {
                binding.favoriteProgress.visibility = View.GONE

            }
        }
    }
}