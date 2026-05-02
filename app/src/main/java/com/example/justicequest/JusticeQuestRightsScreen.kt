package com.example.justicequest

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.justicequest.databinding.FragmentJusticeQuestRightsScreenBinding

class JusticeQuestRightsScreen : Fragment() {

    private var _binding: FragmentJusticeQuestRightsScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJusticeQuestRightsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.rightsPager1

        // 1. Basic ViewPager settings
        viewPager.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        // 2. Set the Adapter with Full Rights Data
        val rightsData = arrayListOf(
            JusticeRightModel(
                "Right to Survival: Ensuring a Strong Start",
                "Every child has the right to survival – a right to be born and cared for, irrespective of their gender or social background. This right underscores the importance of proper nutrition, healthcare, and a safe environment during the early years of life, allowing each child to thrive and fulfil their potential."
            ),
            JusticeRightModel(
                "Right to Education: Nurturing Young Minds",
                "The right to education is a cornerstone of child development. It ensures that every Indian child has access to quality education, enabling them to explore their interests, acquire knowledge, and pave the way for a brighter future."
            ),
            JusticeRightModel(
                "Right to Protection: Safeguarding Innocence",
                "Child protection is a paramount concern. The Child Protection Act in India safeguards children from abuse and exploitation, ensuring their physical, emotional, and psychological well-being."
            ),
            JusticeRightModel(
                "Right to Participation: Empowering Young Voices",
                "Children are not passive recipients; they are active participants in society. Every child deserves a platform to voice their opinions, ideas, and concerns."
            ),
            JusticeRightModel(
                "Right to Development: Nurturing Holistic Growth",
                "Childhood is a period of rapid growth and development. This right emphasizes the importance of ensuring that every child has access to nutrition, healthcare, and opportunities that promote their physical, mental, and emotional well-being."
            ),
            JusticeRightModel(
                "Right to Health and Well-being: Building a Healthy Future",
                "Good health is fundamental to a child's growth. This right encompasses proper healthcare, immunization, and sanitation facilities to prevent diseases and promote overall well-being among children."
            ),
            JusticeRightModel(
                "Right to Identity: Recognizing Individuality",
                "Every child has the right to an identity, including a name and nationality. Birth registration is crucial for legal recognition and access to services."
            ),
            JusticeRightModel(
                "Right to Expression: Fostering Creativity",
                "Children are natural explorers and creators. This right encourages freedom of expression, allowing children to express their thoughts, ideas, and creativity without fear."
            ),
            JusticeRightModel(
                "Right against Discrimination: Promoting Equality",
                "Discrimination based on gender, caste, religion, or any other factor has no place in a just society. This right ensures that every child is treated equally."
            ),
            JusticeRightModel(
                "Right to a Safe Environment: Preserving Tomorrow's World",
                "The environment in which a child grows shapes their future. This right emphasizes the need for a clean, safe, and sustainable environment."
            )
        )

        viewPager.adapter = CarouselRecycleViewAdapter(rightsData)

        // 3. Add margin and scaling (zoom-in) effect
        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
            addTransformer { page, position ->
                val r = 1 - kotlin.math.abs(position)
                page.scaleY = 0.80f + r * 0.20f
            }
        }
        viewPager.setPageTransformer(compositePageTransformer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
