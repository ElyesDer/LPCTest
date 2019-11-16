package com.lakooz.lpctest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lakooz.lpctest.databinding.PotsFragmentBinding
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.utils.IUICallBacks


class PotsFragment : Fragment(), IUICallBacks {
    override fun doOnSuccess(msg: String) {
        Toast.makeText(context, "Succes", Toast.LENGTH_SHORT).show()
    }

    override fun doOnFailure(msg: String) {
        Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show()
    }

    private lateinit var binding: PotsFragmentBinding

    private lateinit var viewModel: PotsViewModel

    private val recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = PotsFragmentBinding.inflate(inflater, container, false)

        // set up recycler view
        binding.recyclerView.adapter = PotAdapter(context!!)
        // TODO : set up view model

        return binding.root
    }
}