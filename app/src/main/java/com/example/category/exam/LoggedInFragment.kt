package com.example.category.exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.category.R
import com.example.category.Res.Constants.Companion.USERNAME_KEY


class LoggedInFragment : Fragment() {
    private lateinit var welcomeText : AppCompatTextView
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(USERNAME_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_logged_in, container, false)
        initView(view)
        addNameToWelcomeText()
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        successToastCall()
    }

    private fun initView(view: View){
        welcomeText = view.findViewById(R.id.tv_welcome)
    }

    private fun addNameToWelcomeText(){
        welcomeText.text = String.format("Welcome \nDear %s",userName)
    }

    private fun successToastCall(){
        Toast.makeText(
            requireContext(),
            getString(R.string.toast_success_text),
            Toast.LENGTH_LONG
        ).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(username: String) =
            LoggedInFragment().apply {
                arguments = Bundle().apply {
                    putString(USERNAME_KEY, username)
                }
            }
    }
}