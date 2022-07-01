package com.example.category.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.category.R
import com.example.category.Res.Constants.Companion.CRAFT_KEY

class CategoryFragment : Fragment() {
    private lateinit var womanButton: AppCompatTextView
    private lateinit var manButton: AppCompatTextView
    private lateinit var babyButton: AppCompatTextView
    private lateinit var travelButton: AppCompatTextView
    private lateinit var technicButton: AppCompatTextView
    private lateinit var foodButton: AppCompatTextView
    private lateinit var craftFragment: Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        initVariables(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initVariables(view: View) {
        craftFragment = CraftFragment()
        womanButton = view.findViewById(R.id.tv_Woman)
        manButton = view.findViewById(R.id.tv_Man)
        babyButton = view.findViewById(R.id.tv_Baby)
        travelButton = view.findViewById(R.id.tv_Travel)
        technicButton = view.findViewById(R.id.tv_Tech)
        foodButton = view.findViewById(R.id.tv_Food_and_Drink)
    }

    private fun initListeners() {
        womanButton.setOnClickListener {
            newInstance(CRAFT_KEY, "Woman")
            nextFragment()
        }
        manButton.setOnClickListener {
            newInstance(CRAFT_KEY, "Man")
            nextFragment()
        }
        babyButton.setOnClickListener {
            newInstance(CRAFT_KEY, "Baby")
            nextFragment()
        }
        travelButton.setOnClickListener {
            newInstance(CRAFT_KEY, "Travel")
            nextFragment()
        }
        technicButton.setOnClickListener {
            newInstance(CRAFT_KEY, "Technic")
            nextFragment()
        }
        foodButton.setOnClickListener {
            newInstance(CRAFT_KEY, "Food")
            nextFragment()
        }
    }

    private fun nextFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, craftFragment, "B").addToBackStack("A").commit()
    }

    private fun newInstance(key: String, category: String) {
        craftFragment.apply {
            arguments = Bundle().apply {
                putString(key, category)
            }
        }
    }
}