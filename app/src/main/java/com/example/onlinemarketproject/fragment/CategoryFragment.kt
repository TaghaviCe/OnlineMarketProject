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

        binding.categoryList.adapter=  RecyclerViewCategoryAdapter{id -> onProductListItemClick(id)}
        setlistProduct()
    }
    private fun onProductListItemClick(id: Int) {
        val bundle = bundleOf(product to id)
        findNavController().navigate(R.id.action_categoryFragment_to_productListFragment, bundle)
    }

    private fun setlistProduct() {
        viewModel.getCategoryItem()
        attachCategoryOnScrollListener()
    }
    private fun attachCategoryOnScrollListener() {
        binding.categoryList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getCategoryItem()

                }
            }
        })
    }


}