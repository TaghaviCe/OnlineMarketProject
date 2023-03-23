package com.example.onlinemarketproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.onlinemarketproject.R
import com.example.onlinemarketproject.databinding.FragmentSignUpUserBinding
import com.example.onlinemarketproject.viewmodels.SignUpViewModel
import com.google.android.material.snackbar.Snackbar


class SignUpUserFragment : Fragment() {
    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var binding: FragmentSignUpUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpUserBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this.viewLifecycleOwner
        //binding.signUpViewModel=viewModel
        binding.buttonSignup.setOnClickListener {
            val username = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()
            if (username.isBlank() || password.isBlank()) {

                Toast.makeText(
                    requireActivity(),
                    "Username and password cannot be blank",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                viewModel.registerUser(username, password)
                Toast.makeText(
                    requireActivity(),
                    "send",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.successful.observe(viewLifecycleOwner) { successful ->
                    Toast.makeText(
                        requireActivity(),
                        "$successful",
                        Toast.LENGTH_SHORT
                    ).show()

//                    if (successful == true) {
//                        Toast.makeText(
//                            requireActivity(),
//                            "your account was created!",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        var sharedPreferencesForLogIn: SharedPreferences =
//                            requireActivity().getSharedPreferences(
//                                "Logged_in",
//                                Context.MODE_PRIVATE
//                            )
//                        var editor = sharedPreferencesForLogIn.edit()
//                        editor.putInt("state", 1)
//                        editor.apply()
//                        findNavController().navigate(R.id.action_signUpUserFragment_to_loginUserFragment)
//
//                    } else if (successful == false) {
//                        Toast.makeText(
//                            requireActivity(),
//                            "Error connecting to the server! Please try again...",
//                            Toast.LENGTH_SHORT
//                        ).show()
//
//                    } else {
//                        Toast.makeText(
//                            requireActivity(),
//                            "$successful",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
                }
            }

            }



        }


    }
