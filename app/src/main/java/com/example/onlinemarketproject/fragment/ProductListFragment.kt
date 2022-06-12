package com.example.onlinemarketproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.databinding.FragmentProductListBinding
import com.example.onlinemarketproject.viewmodels.ProductListViewModel

class ProductListFragment : Fragment() {
    private val proViewModel: ProductListViewModel by viewModels()
    private lateinit var binding: FragmentProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductListBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.lifecycleOwner = this.viewLifecycleOwner
//        binding.homeViewModel = viewModel

    }


}