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
import com.example.onlinemarketproject.adapter.sortRecyclerView
import com.example.onlinemarketproject.databinding.FragmentSortListBinding
import com.example.onlinemarketproject.viewmodels.SearchViewModel

class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSortListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentSortListBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.sortViewModel= viewModel

        binding.rvCheap.adapter =sortRecyclerView()
        viewModel.mCheapestItem.observe(viewLifecycleOwner){

        }
        binding.rvExpensive.adapter=
            RecyclerViewProductAdapter{ id -> onProductItemClick(id) }

        var mybundle=requireArguments().getInt("categoryId", 0)
        binding.textView4.text=mybundle.toString()


        setList(mybundle)


    }

    private fun setList(mybund:Int) {
        viewModel.cheapestClicked(mybund.toString())
        viewModel.mostExpensiveClicked(mybund.toString())
        attachExpensiveItemsOnScrollListener(mybund)
        attachCheapestItemsOnScrollListener(mybund)
    }

    private fun attachCheapestItemsOnScrollListener(mybund:Int) {
        binding.rvCheap.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.cheapestClicked(mybund.toString())
                }
            }
        })
    }


    private fun onProductItemClick(id: Int) {
        val bundle = bundleOf(product to id)
        findNavController().navigate(R.id.action_productListFragment_to_productFragment, bundle)
    }

    private fun attachExpensiveItemsOnScrollListener(mybund:Int) {
        binding.rvExpensive.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.mostExpensiveClicked(mybund.toString())

                }
            }
        })
    }





}