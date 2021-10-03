package com.simdamsi.zenith.ui.zenith

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simdamsi.zenith.R
import com.simdamsi.zenith.model.Mountain
import kotlinx.android.synthetic.main.item_mountain.view.*


class ZenithAdapter(
    private val list: List<Mountain>,
    private val context: Context
) : RecyclerView.Adapter<ZenithAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Mountain) {
            itemView.textViewName.text = item.name
            itemView.textViewAlt.text = item.alt.toString()


            /*Glide.with(itemView.context)
                .load(item.imageurl)
                .placeholder(android.R.color.transparent)
                .into(itemView.imageView)*/

            /*itemView.setOnClickListener {
                var bundle = bundleOf("alt" to item.alt)
                it.findNavController()
                    .navigate(R.id.action_navigation_zenith_to_navigation_dashboard, bundle)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mountain, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
