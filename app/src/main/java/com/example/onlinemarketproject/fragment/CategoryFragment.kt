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
import com.example.onlinemarketproject.adapter.RecyclerViewCategoryAdapter
import com.example.onlinemarketproject.adapter.RecyclerViewProductAdapter
import com.example.onlinemarketproject.databinding.FragmentCategoryBinding
import com.example.onlinemarketproject.viewmodels.CategoryViewModel


class CategoryFragment : Fragment() {

    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCategoryBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
         binding.categoryViewModel = viewModel

        binding.productRecentList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }
        binding.productPopularList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }
        binding.productBestList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }
        binding.productWomanList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }

        setlistProduct()
    }

    private fun onProductItemClick(id: Int) {
        val bundle = bundleOf(product to id)
        findNavController().navigate(R.id.action_homeFragment_to_productFragment, bundle)
    }


    private fun setlistProduct() {
        viewModel.getProductItem()
        viewModel.getPopularList()
        viewModel.getRecentList()
        viewModel.getTopList()
        viewModel.getWomanList()
        attachPopularOnScrollListener()
        attachRecentOnScrollListener()
        attachTopOnScrollListener()
        attachWomanOnScrollListener()
    }

    //
    private fun attachPopularOnScrollListener() {
        binding.productPopularList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getProductItem()

                }
            }
        })
    }

    //
    private fun attachRecentOnScrollListener() {
        binding.productRecentList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getPopularList()
                }
            }
        })

    }

    private fun attachTopOnScrollListener() {
        binding.productBestList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getTopList()
                }
            }
        })

    }

    private fun attachWomanOnScrollListener() {
        binding.productBestList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getWomanList()
                }
            }
        })

    }


}