package com.example.category.exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.example.category.R
import com.example.category.Res.Constants.Companion.LOGIN_BACK_STACK
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {
    private lateinit var edUsername: AppCompatEditText
    private lateinit var edpassword: AppCompatEditText
    private lateinit var btnLogIn: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        initView(view)
        initListeners()
        return view
    }

    private fun initView(view: View) {
        edUsername = view.findViewById(R.id.ed_username)
        edpassword = view.findViewById(R.id.ed_password)
        btnLogIn = view.findViewById(R.id.btn_login)
    }

    private fun initListeners() {
        btnLogIn.setOnClickListener {
            val username = edUsername.text.toString().trim()
            val password = edpassword.text.toString().trim()
            if (username.checkUserName() && password.checkPassword()) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(
                        R.id.container, LoggedInFragment.newInstance(username)
                    ).addToBackStack(LOGIN_BACK_STACK)
                    .commit()
                Toast.makeText(
                    requireContext(),
                    "You have been successfully logged in",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun String.checkUserName(): Boolean {
        return if (isNotEmpty() && this[0].isUpperCase() && length > 7) {
            true
        } else {
            Snackbar.make(
                requireActivity().findViewById(R.id.activity_root),
                "Username is not valid!",
                Snackbar.LENGTH_LONG
            ).show()
            false
        }
    }


    private fun String.checkPassword(): Boolean {
        return if (isNotEmpty() && !this[0].isDigit() && length > 7) {
            true
        } else {
            Snackbar.make(
                requireActivity().findViewById(R.id.activity_root),
                "Password is not valid!",
                Snackbar.LENGTH_LONG
            ).show()
            false
        }
    }
}