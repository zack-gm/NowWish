package com.example.presentation.wish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.wish.Wish
import com.example.presentation.R
import com.example.presentation.onClick
import kotlinx.android.synthetic.main.item_wish.view.*

class WishAdapter(
    private val values: List<Wish>,
    val listner: (item: Wish) -> Unit
): RecyclerView.Adapter<WishAdapter.ViewHolder>() {



    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val id: TextView = view.id_wish
        val title: TextView = view.title_wish
        val description: TextView = view.description_wish

        override fun toString(): String {
            return super.toString() + " '" + title.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wish, parent, false)
        return ViewHolder(view).onClick {
            listner.invoke(values[it])
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.id.text = item.id
        holder.title.text = item.title
        holder.description.text = item.description
    }

    interface OnItemClick{
        fun onClick(position: Int)
    }
}
