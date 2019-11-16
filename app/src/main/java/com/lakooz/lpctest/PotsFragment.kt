package com.lakooz.lpctest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lakooz.lpctest.databinding.PotsFragmentBinding
import com.lakooz.lpctest.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView


class PotsFragment : Fragment() {

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