package com.example.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.category.fragments.CategoryFragment

class MainActivity : AppCompatActivity() {
    private lateinit var categoryFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoryFragment = CategoryFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, categoryFragment, "A")
            .addToBackStack("A").commit()
    }
}