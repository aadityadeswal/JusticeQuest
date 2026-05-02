package com.example.justicequest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.justicequest.databinding.FragmentJusticeQuestRateUsScreenBinding

class JusticeQuestRateUsScreen : Fragment() {

    private lateinit var binding: FragmentJusticeQuestRateUsScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJusticeQuestRateUsScreenBinding.inflate(inflater, container, false)


        val sharedPref = requireActivity().getSharedPreferences("JusticeQuestPrefs", Context.MODE_PRIVATE)
        val savedRating = sharedPref.getFloat("user_rating", 0.0f) // default = 0
        binding.ratingBar1.rating = savedRating

        binding.submitButton.setOnClickListener {
            val rating = binding.ratingBar1.rating
            with(sharedPref.edit()) {
                putFloat("user_rating", rating)
                apply()
            }
            Toast.makeText(requireContext(), "Thank you for rating us $rating stars!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
