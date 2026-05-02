package com.example.justicequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarouselRecycleViewAdapter(private val carouselDataList: ArrayList<JusticeRightModel>) :
    RecyclerView.Adapter<CarouselRecycleViewAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headingTextView: TextView = view.findViewById(R.id.rightHeading)
        val descriptionTextView: TextView = view.findViewById(R.id.rightDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val item = carouselDataList[position]
        holder.headingTextView.text = item.heading
        holder.descriptionTextView.text = item.description
    }

    override fun getItemCount(): Int {
        return carouselDataList.size
    }
}
