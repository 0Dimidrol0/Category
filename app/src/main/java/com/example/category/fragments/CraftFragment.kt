package com.example.category.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.category.R
import com.example.category.fragments.Constants.Companion.BABY
import com.example.category.fragments.Constants.Companion.CATEGORY_KEY
import com.example.category.fragments.Constants.Companion.FOOD
import com.example.category.fragments.Constants.Companion.MAN
import com.example.category.fragments.Constants.Companion.TECH
import com.example.category.fragments.Constants.Companion.TRAVEL
import com.example.category.fragments.Constants.Companion.WOMAN

class CraftFragment : Fragment() {
    private var crafting: String? = null
    private lateinit var backButton: AppCompatButton
    private lateinit var craftRoot: ConstraintLayout
    private lateinit var craftLogo: ImageFilterView
    private lateinit var craftName: AppCompatTextView
    private lateinit var craftAbout: AppCompatTextView
    private lateinit var craftMore: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            crafting = it.getString(CATEGORY_KEY)
        }
        Log.d("crafting:", "$crafting")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_craft, container, false)
        initVariables(view)
        setCategory(crafting.toString())
        initListeners()

        return view
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initVariables(view: View) {
        craftRoot = view.findViewById(R.id.Craft_root)
        craftName = view.findViewById(R.id.tv_name)
        craftLogo = view.findViewById(R.id.Iv_logo)
        craftAbout = view.findViewById(R.id.tv_about)
        craftMore = view.findViewById(R.id.tv_More)
        backButton = view.findViewById(R.id.btn_back)

    }

    private fun initListeners() {
        backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setCategory(category: String) {
        when (category) {
           WOMAN -> view.run {
                Glide.with(requireContext())
                    .load("https://picsum.photos/200/300")
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            TODO("Not yet implemented")
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(craftLogo)
                craftName.text = resources.getString(R.string.woman_text)
                craftRoot.setBackgroundColor(resources.getColor(R.color.women_bg))
                craftAbout.text = resources.getString(R.string.woman_about_text)
                craftMore.text = (resources.getString(R.string.woman_more_text))
                return@run
            }
            MAN -> view.run {
                craftLogo.setImageDrawable(resources.getDrawable(R.mipmap.ic_man_icon_foreground))
                craftName.text = resources.getString(R.string.man_text)
                craftRoot.setBackgroundColor(resources.getColor(R.color.man_bg))
                craftAbout.text = resources.getString(R.string.man_about_text)
                craftMore.text = (resources.getString(R.string.man_more_text))
                return@run
            }
            BABY -> view.run {
                craftLogo.setImageDrawable(resources.getDrawable(R.mipmap.ic_baby_foreground))
                craftLogo.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.mipmap.ic_baby_foreground))
                craftName.text = (resources.getString(R.string.baby_text))
                craftRoot.setBackgroundColor(resources.getColor(R.color.baby_bg))
                craftAbout.text = resources.getString(R.string.baby_about_text)
                craftMore.text = resources.getString(R.string.baby_more_text)
                return@run
            }
            TRAVEL -> view.run {
                craftLogo.setImageDrawable(resources.getDrawable(R.mipmap.ic_travel_draw))
                craftName.text = resources.getString(R.string.travel_text)
                craftRoot.setBackgroundColor(resources.getColor(R.color.plane_bg))
                craftAbout.text = resources.getString(R.string.travel_about_text)
                craftMore.text = resources.getString(R.string.travel_more_text)
                return@run
            }
            FOOD -> view.run {
                craftLogo.setImageDrawable(resources.getDrawable(R.mipmap.ic_food_foreground))
                craftName.text = resources.getString(R.string.food_drink_text)
                craftRoot.setBackgroundColor(resources.getColor(R.color.phone_bg))
                craftAbout.text = resources.getString(R.string.food_drink_about_text)
                craftMore.text = resources.getString(R.string.food_drink_more_text)
                return@run
            }
            TECH -> view.run {
                craftLogo.setImageDrawable(resources.getDrawable(R.mipmap.ic_technic_foreground))
                craftName.text = resources.getString(R.string.technic_text)
                craftRoot.setBackgroundColor(resources.getColor(R.color.women_bg))
                craftAbout.text = resources.getString(R.string.technic_about_text)
                craftMore.text = resources.getString(R.string.technic_more_text)
                return@run
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(category: String) =
            CraftFragment().apply {
                arguments = Bundle().apply {
                    putString(CATEGORY_KEY, category)
                }
            }
    }
}