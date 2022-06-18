package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.data.myPreference
import com.example.onlinemarketproject.databinding.FragmentProductBinding
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository
import com.example.onlinemarketproject.viewmodels.ProductPageViewModel
import com.google.gson.Gson

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
        var id=requireArguments().getInt(product, 0)
        pageViewModel.getProductWithId(id)

        binding.button4.setOnClickListener {
            try {
               // var list =id

                myPreference.addIdItem(id)
                binding.button4.setBackgroundColor(Color.WHITE);
                findNavController().navigate(R.id.action_productFragment_to_cartFragment)

            }catch (e: Exception){
                Toast.makeText(context,"error",Toast.LENGTH_LONG)

            }


        }



    }



}