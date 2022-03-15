package com.confiz.gridlayoutwork.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.confiz.gridlayoutwork.R
import com.confiz.gridlayoutwork.dto.ItemDetails

class StaggeredAdapter(private val context: Context, private val itemList: ArrayList<ItemDetails>) :
    RecyclerView.Adapter<StaggeredAdapter.ViewHolder>() {

    private var height: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cell, parent, false);
        height = parent.height
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return itemList[position].rows
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.placeText.apply {
            text = itemList[position].itemName
            setBackgroundColor(itemList[position].color)
        }
        val layoutManager: StaggeredGridLayoutManager.LayoutParams =
            holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
        layoutManager.height = (height / 5) * itemList[position].rows
        if (itemList[position].columns == 2) {
            layoutManager.isFullSpan = true
        }
        holder.itemView.layoutParams = layoutManager
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var placeText: TextView = itemView.findViewById(R.id.place)
    }
}