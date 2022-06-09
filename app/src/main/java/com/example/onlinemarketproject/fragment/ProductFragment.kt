package com.example.onlinemarketproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.onlinemarketproject.databinding.FragmentProductBinding
import com.example.onlinemarketproject.viewmodels.ProductPageViewModel

class ProductFragment : Fragment() {

   private val pageViewModel: ProductPageViewModel by viewModels()
    private lateinit var binding: FragmentProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.productViewModel=pageViewModel
        pageViewModel.getProductWithId(requireArguments().getInt(product, 0))



    }


}