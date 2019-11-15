package com.lakooz.lpctest

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.databinding.PotItemBinding
import com.lakooz.lpctest.model.Pot
import android.content.ClipData.Item
import android.view.LayoutInflater
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class PotAdapter(private val context: Context, private var emptyView: View? = null) :
    RecyclerView.Adapter<PotAdapter.ViewHolder>() {


    private var pots: List<Pot>? = listOf()
    private var recyclerView: RecyclerView? = null


    fun setPots(pots: List<Pot>?) {
        this.pots = pots
        // TODO : notify data change and handle empty view

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO : DONE
        // need to inflate this here
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pot_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // TODO : DONE
        // yearh return the size
        return pots!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO : bind view holder & format amount properly
        //todo do some conversion to amount with amount = 0.0 format
        val potItem: Pot = pots!!.get(position)
        holder.title.text = potItem.name
        holder.subtitle.text = potItem.amount.toString() + "$ Récoltés"
        holder.viewers.text = potItem.contributorsCount.toString()

        Glide.with(context).load(potItem.imageUrl)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = null

        super.onDetachedFromRecyclerView(recyclerView)
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val image: ImageView = itemView!!.findViewById(R.id.img)
        val title: TextView = itemView!!.findViewById(R.id.title)
        val subtitle: TextView = itemView!!.findViewById(R.id.subtiltle)
        val viewers: TextView = itemView!!.findViewById(R.id.viewers)

    }
}
