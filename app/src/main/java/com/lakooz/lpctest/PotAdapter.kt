package com.lakooz.lpctest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.databinding.PotItemBinding
import com.lakooz.lpctest.model.Pot


class PotAdapter(private val context: Context, private var emptyView: View? = null) :
    RecyclerView.Adapter<PotAdapter.ViewHolder>() {

    private var view: PotItemBinding? = null
    private var layoutInflater: LayoutInflater? = null
    private var pots: List<Pot>? = listOf()
    private var recyclerView: RecyclerView? = null


    // as a call back fun
    fun setPots(pots: List<Pot>?) {
        this.pots = pots
        // TODO :DONE notify data change and handle empty view
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(context)
        view = DataBindingUtil.inflate(
            layoutInflater!!,
            R.layout.pot_item,
            parent,
            false
        )
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        // TODO
        return pots!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO :DONE bind view holder & format amount properly DONE
        //todo DONE do some conversion to amount with amount = 0.0 format

        val potItem: Pot = pots!![position]
        holder.binding.pot = potItem
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = null

        super.onDetachedFromRecyclerView(recyclerView)
    }


    inner class ViewHolder(val binding: PotItemBinding) : RecyclerView.ViewHolder(binding.root)

    // couldn't do it the other way
    /*
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val image: ImageView = itemView!!.findViewById(R.id.img)
        val title: TextView = itemView!!.findViewById(R.id.title)
        val subtitle: TextView = itemView!!.findViewById(R.id.subtiltle)
        val viewers: TextView = itemView!!.findViewById(R.id.viewers)

    }

     */
}
