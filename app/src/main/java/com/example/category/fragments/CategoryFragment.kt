package com.example.category.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.category.R
import com.example.category.fragments.Constants.Companion.BABY
import com.example.category.fragments.Constants.Companion.FOOD
import com.example.category.fragments.Constants.Companion.MAN
import com.example.category.fragments.Constants.Companion.TECH
import com.example.category.fragments.Constants.Companion.TRAVEL
import com.example.category.fragments.Constants.Companion.WOMAN

class CategoryFragment : Fragment() {
    private lateinit var womanButton: AppCompatTextView
    private lateinit var manButton: AppCompatTextView
    private lateinit var babyButton: AppCompatTextView
    private lateinit var travelButton: AppCompatTextView
    private lateinit var technicButton: AppCompatTextView
    private lateinit var foodButton: AppCompatTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        initView(view)
        initListeners()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initView(view: View) {
        womanButton = view.findViewById(R.id.tv_Woman)
        manButton = view.findViewById(R.id.tv_Man)
        babyButton = view.findViewById(R.id.tv_Baby)
        travelButton = view.findViewById(R.id.tv_Travel)
        technicButton = view.findViewById(R.id.tv_Tech)
        foodButton = view.findViewById(R.id.tv_Food_and_Drink)
    }

    private fun initListeners() {
        womanButton.setOnClickListener {
            goToCraftFragment(WOMAN)
        }
        manButton.setOnClickListener {
            goToCraftFragment(MAN)
        }
        babyButton.setOnClickListener {
            goToCraftFragment(BABY)
        }
        travelButton.setOnClickListener {
            goToCraftFragment(TRAVEL)
        }
        technicButton.setOnClickListener {
            goToCraftFragment(TECH)
        }
        foodButton.setOnClickListener {
            goToCraftFragment(FOOD)
        }
    }

    private fun goToCraftFragment(category: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, CraftFragment.newInstance(category), "B")
            .addToBackStack("A")
            .commit()
    }
}