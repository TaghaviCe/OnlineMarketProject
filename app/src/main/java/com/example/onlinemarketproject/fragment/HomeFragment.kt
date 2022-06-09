package com.example.onlinemarketproject.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.adapter.RecyclerViewProductAdapter
import com.example.onlinemarketproject.databinding.FragmentHomeBinding
import com.example.onlinemarketproject.viewmodels.HomeViewModel

const val product = "PRODUCT_ID"
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.homeViewModel = viewModel

        binding.productRecentList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }
        binding.productPopularList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }
        binding.productBestList.adapter =
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
        attachPopularMoviesOnScrollListener()
        attachRecentMoviesOnScrollListener()
        attachTopMoviesOnScrollListener()
    }

    //
    private fun attachPopularMoviesOnScrollListener() {
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
    private fun attachRecentMoviesOnScrollListener() {
        binding.productRecentList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getPopularList()
                }
            }
        })

    }

    private fun attachTopMoviesOnScrollListener() {
        binding.productBestList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getTopList()
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

          return  when (item.itemId) {
                R.id.categoryFragment -> {
                    findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
                    true
                }
              else-> return super.onOptionsItemSelected(item)
            }
        }


}