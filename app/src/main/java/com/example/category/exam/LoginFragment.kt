package com.example.category.exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private lateinit var username: String
    private lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initListeners()

    }

    private fun initView(view: View) {
        edUsername = view.findViewById(R.id.ed_username)
        edpassword = view.findViewById(R.id.ed_password)
        btnLogIn = view.findViewById(R.id.btn_login)
    }

    private fun initListeners() {
        btnLogIn.setOnClickListener {
            username = edUsername.text.toString().trim()
            password = edpassword.text.toString().trim()
            if (username.checkUserName() && password.checkPassword()) {
                goToMainPage()
            }
        }
    }

    private fun goToMainPage() {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(
                R.id.container, LoggedInFragment.newInstance(username)
            ).addToBackStack(LOGIN_BACK_STACK)
            .commit()
        cleanEditTexts()
    }

    private fun String.checkUserName(): Boolean {
        return if (isNotEmpty() && this[0].isUpperCase() && length > 7) {
            true
        } else {
            Snackbar.make(
                requireActivity().findViewById(R.id.activity_root),
                getString(R.string.snack_bar_user_text),
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
                getString(R.string.snack_bar_password_text),
                Snackbar.LENGTH_LONG
            ).show()
            false
        }
    }

    private fun cleanEditTexts(){
        edUsername.setText("")
        edpassword.setText("")
    }
}