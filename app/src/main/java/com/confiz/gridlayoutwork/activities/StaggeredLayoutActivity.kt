package com.confiz.gridlayoutwork.activities

import android.graphics.Color.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.confiz.gridlayoutwork.dto.ItemDetails
import com.confiz.gridlayoutwork.adapters.StaggeredAdapter
import com.confiz.gridlayoutwork.databinding.ActivityStaggeredLayoutBinding

class StaggeredLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStaggeredLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaggeredLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachLayoutManager()
    }

    private fun attachLayoutManager() {
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
            }
        binding.items.run {
            layoutManager = staggeredGridLayoutManager
            setHasFixedSize(true)
            adapter = staggeredAdapter()
        }
    }

    private fun staggeredAdapter() = StaggeredAdapter(baseContext, getItemDetails())

    private fun getItemDetails(): ArrayList<ItemDetails> {
        val details: ArrayList<ItemDetails> = ArrayList()
        for (index in items.indices) {
            details.add(
                ItemDetails(items[index], itemColors[index], itemRows[index], itemColumns[index])
            )
        }
        return details
    }

    companion object {
        private var items =
            arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8")
        private var itemColors = arrayOf(BLACK, BLUE, CYAN, GRAY, GREEN, MAGENTA, RED, YELLOW)
        private var itemRows = arrayOf(1, 2, 1, 1, 1, 1, 2, 1)
        private var itemColumns = arrayOf(2, 1, 1, 1, 2, 1, 1, 1)
    }
}