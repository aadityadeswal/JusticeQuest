package com.example.justicequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.justicequest.databinding.FragmentJusticeQuestMenuScreenBinding

class JusticeQuestMenuScreen : Fragment() {

    private lateinit var binding: FragmentJusticeQuestMenuScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJusticeQuestMenuScreenBinding.inflate(inflater, container, false)

        // Set up click listeners for each card (or button) here
        setUpClickListeners()

        return binding.root
    }

    private fun setUpClickListeners() {
        // Click listeners for each card to navigate to the respective fragment
        binding.literacyTab1.setOnClickListener {
            openFragment(JusticeQuestLiteracyVideos())
        }

        binding.protectionTab1.setOnClickListener {
            openFragment(JusticeQuestLiteracyVideos())
        }

        binding.actsTab1.setOnClickListener {
            openFragment(JusticeQuestDetailsScreen())
        }

        binding.rightsTab1.setOnClickListener {
            openFragment(JusticeQuestRightsScreen())
        }
    }

    private fun openFragment(fragment: Fragment) {
        // This will replace the current fragment with the selected fragment
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer1, fragment)
        fragmentTransaction.addToBackStack(null) // Optional: To allow back navigation
        fragmentTransaction.commit()
    }
}
