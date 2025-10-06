package com.jordan.lab_week06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jordan.lab_week06.model.CatModel

class CatAdapter(private val layoutInflater: LayoutInflater, private val
imageLoader: ImageLoader) : RecyclerView.Adapter<CatViewHolder>() {
    //Mutable list for storing all the list data
    private val cats = mutableListOf<CatModel>()
    //A function to set the mutable list
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }
    //This is used to get the amount of data/item in the list
    override fun getItemCount() = cats.size
    //This is used to bind each data to each layout views
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        holder.bindData(cats[position])
    }
}
