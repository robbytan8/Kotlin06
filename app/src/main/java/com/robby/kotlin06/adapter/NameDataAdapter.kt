package com.robby.kotlin06.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

/**
 * @author Robby Tan
 */
class NameDataAdapter(var names: ArrayList<String>) : Adapter<NameDataAdapter.NameViewHolder>() {

    private lateinit var itemDataClicked: ItemDataClicked

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = TextView(parent.context)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.setData(names[position])
        holder.itemView.setOnClickListener {
            itemDataClicked.onItemClicked(names[position])
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }

    fun setOnItemDataClicked(itemDataClicked: ItemDataClicked) {
        this.itemDataClicked = itemDataClicked
    }

    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvName: TextView

        init {
            tvName = itemView as TextView
            tvName.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        fun setData(name: String) {
            tvName.text = name
        }
    }

    interface ItemDataClicked {
        fun onItemClicked(name: String)
    }
}