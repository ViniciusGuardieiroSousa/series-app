package br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.guardieiro.sousa.detailfeature.R
import br.com.vinicius.guardieiro.sousa.detailfeature.databinding.SeasonComponentBinding
import br.com.vinicius.guardieiro.sousa.detailfeature.presentation.view.component.recyclerview.SeasonComponentAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.bottomsheet.BottomSheetDialog


class SeasonComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    private var binding = SeasonComponentBinding.inflate(LayoutInflater.from(context), this, true)

    var list: List<Long> = emptyList()
        set(value) {
            field = value
            configClickListener()
        }

    var listener: (Long) -> Unit = {}
        set(value) {
            field = value
            configClickListener()
        }
    var selectedItem: Long = 0L
        set(value) {
            field = value
            binding.seasonText.text = value.toString()
        }

    init {
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

    }

    private fun configClickListener() {
        this.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(context)
            bottomSheetDialog.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
            configRecycler(bottomSheetDialog)
            bottomSheetDialog.show()
        }
    }

    private fun configRecycler(bottomSheetDialog: BottomSheetDialog) {
        val recycler = bottomSheetDialog.findViewById<RecyclerView>(R.id.season_recycler)
        recycler?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = SeasonComponentAdapter()
        adapter.addList(list)
        adapter.listener = {
            selectedItem = it
            listener.invoke(it)
            bottomSheetDialog.dismiss()
        }
        recycler?.adapter = adapter
    }
}