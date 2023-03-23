package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

        binding.buttonLogin.setOnClickListener {
            val username = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()
            if (username.isBlank() || password.isBlank()) {

                Toast.makeText(
                    requireActivity(),
                    "Username and password cannot be blank",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                viewModel.logiUser(username, password)
                viewModel.successful.observe(viewLifecycleOwner){successful->
                    if (successful == true){
                        Toast.makeText(
                            requireActivity(),
                            "You have successfully logged into your account",
                            Toast.LENGTH_SHORT
                        ).show()
                        var sharedPreferencesForLogIn: SharedPreferences =requireActivity().getSharedPreferences("Logged_in",
                            Context.MODE_PRIVATE)
                        var editor=sharedPreferencesForLogIn.edit()
                        editor.putInt("state",2)
                        editor.apply()
                        findNavController().navigate(R.id.action_loginUserFragment_to_cartFragment)

                    }else if (successful == false){
                        Toast.makeText(
                            requireActivity(),
                            "Login failed! Please write password or username correctly",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }
        }


    }


}