package com.example.presentation.wish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.wish.WishList
import com.example.presentation.R
import com.example.presentation.onClick
import kotlinx.android.synthetic.main.item_wish_list.view.*

class WishListAdapter(
    private val values: List<WishList>,
    val listner: (item: WishList) -> Unit = {}
): RecyclerView.Adapter<WishListAdapter.ViewHolder>() {



    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val id: TextView = view.id_wish_list
        val name: TextView = view.name_wish_list
        val description: TextView = view.description_wish_list

        override fun toString(): String {
            return super.toString() + " '" + name.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wish_list, parent, false)
        return ViewHolder(view).onClick {
            listner.invoke(values[it])
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.id.text = item.id
        holder.name.text = item.name
        holder.description.text = item.description
    }

    interface OnItemClick{
        fun onClick(position: Int)
    }
}