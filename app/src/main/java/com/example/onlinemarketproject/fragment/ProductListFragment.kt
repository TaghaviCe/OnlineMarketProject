package com.example.onlinemarketproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.adapter.RecyclerViewProductAdapter
import com.example.onlinemarketproject.databinding.FragmentProductListBinding
import com.example.onlinemarketproject.viewmodels.ProductListViewModel

class ProductListFragment : Fragment() {
    private val viewModel: ProductListViewModel by viewModels()
    private lateinit var binding: FragmentProductListBinding
    private var bundle:Int=0
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
       binding.lifecycleOwner = this.viewLifecycleOwner
       binding.productListViewModel= viewModel

        binding.productRecentList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }

        bundle=requireArguments().getInt(product, 0)
        setInformationProductList()

    }

    private fun setInformationProductList() {
        viewModel.getCategoryProductListItem(20,bundle.toString())
        attachItemsOnScrollListener()
    }

    private fun onProductItemClick(id: Int) {
        val bundle = bundleOf(product to id)
        findNavController().navigate(R.id.action_homeFragment_to_productFragment, bundle)
    }

    private fun attachItemsOnScrollListener() {
        binding.productRecentList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getCategoryProductListItem(20,bundle.toString())

                }
            }
        })
    }


}