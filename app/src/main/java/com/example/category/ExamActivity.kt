package com.example.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.category.Res.Constants.Companion.LOGIN_BACK_STACK
import com.example.category.exam.LoginFragment

class ExamActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)
        supportActionBar?.hide()
        addFragmentToContainer()
    }


    private fun addFragmentToContainer() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, LoginFragment(), LOGIN_BACK_STACK)
            .addToBackStack(LOGIN_BACK_STACK)
            .commit()
    }
}