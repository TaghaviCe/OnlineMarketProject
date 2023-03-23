package com.example.onlinemarketproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.databinding.FragmentLoginUserBinding
import com.example.onlinemarketproject.databinding.FragmentProductBinding
import com.example.onlinemarketproject.viewmodels.LoginViewModel


class LoginUserFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding:FragmentLoginUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginUserBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}