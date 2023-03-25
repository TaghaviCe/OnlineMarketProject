package com.example.onlinemarketproject.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
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


        binding.productProductList.adapter =
            RecyclerViewProductAdapter { id -> onProductItemClick(id) }


        setlistProduct()

        binding.buttonSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

    }

    private fun onProductItemClick(id: Int) {
        val bundle = bundleOf(product to id)
        findNavController().navigate(R.id.action_homeFragment_to_productFragment, bundle)
    }


    private fun setlistProduct() {
        viewModel.getProductItem()
        attachPopularOnScrollListener()

    }

    private fun attachPopularOnScrollListener() {
        binding.productProductList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && dy != 0) {
                    viewModel.getProductItem()

                }
            }
        })
    }


//  if You Like ADD menu

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu_main, menu)
//
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//          return  when (item.itemId) {
//                R.id.categoryFragment -> {
//                    findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
//                    true
//                }
//              R.id.cartFragment->{
//                  findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
//                  true
//              }
//
//              else-> return super.onOptionsItemSelected(item)
//            }
//        }


}