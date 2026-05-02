package com.example.justicequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class JusticeQuestLiteracyVideos : Fragment() {
    private lateinit var youTubePlayerView1: YouTubePlayerView
    private lateinit var youTubePlayerView2: YouTubePlayerView
    private lateinit var youTubePlayerView3: YouTubePlayerView
    private lateinit var youTubePlayerView4: YouTubePlayerView
    private lateinit var youTubePlayerView5: YouTubePlayerView
    private lateinit var youTubePlayerView6: YouTubePlayerView
    private lateinit var youTubePlayerView7: YouTubePlayerView
    private lateinit var youTubePlayerView8: YouTubePlayerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_justice_quest_literacy_videos, container, false)

        // Initialize YouTube player views
        youTubePlayerView1 = view.findViewById(R.id.youtube_player_view1)
        youTubePlayerView2 = view.findViewById(R.id.youtube_player_view2)
        youTubePlayerView3 = view.findViewById(R.id.youtube_player_view3)
        youTubePlayerView4 = view.findViewById(R.id.youtube_player_view4)
        youTubePlayerView5 = view.findViewById(R.id.youtube_player_view5)
        youTubePlayerView6 = view.findViewById(R.id.youtube_player_view6)
        youTubePlayerView7 = view.findViewById(R.id.youtube_player_view7)
        youTubePlayerView8 = view.findViewById(R.id.youtube_player_view8)

        // Initialize YouTube player with default controls
        initializeYouTubePlayer(youTubePlayerView1, "HHNfaPuoZHM")
        initializeYouTubePlayer(youTubePlayerView2, "ju-f-n7wsPg")
        initializeYouTubePlayer(youTubePlayerView3, "HCYLdtug8sk")
        initializeYouTubePlayer(youTubePlayerView4, "aJoGct2vJrI")
        initializeYouTubePlayer(youTubePlayerView5, "QGLnnk46UQ0")
        initializeYouTubePlayer(youTubePlayerView6, "mI2dYmNCJVQ")
        initializeYouTubePlayer(youTubePlayerView7, "GAYVZD0yV2w")
        initializeYouTubePlayer(youTubePlayerView8, "COjVj9czgrY")



        return view
    }

    private fun initializeYouTubePlayer(youTubePlayerView: YouTubePlayerView, videoId: String) {
        lifecycle.addObserver(youTubePlayerView)

        // Set up the YouTube player with default controls
        val listener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                // Use cueVideo instead of loadVideo to avoid autoplay
                youTubePlayer.cueVideo(videoId, 0f) // Cue the video without autoplaying
            }
        }

        // Set the options to use YouTube's default controls
        val options = IFramePlayerOptions.Builder()
            .controls(1) // Default controls (play/pause, volume, etc.)
            .ccLoadPolicy(1) // Optional: enable closed captions if required
            .build()

        // Initialize the YouTube player
        youTubePlayerView.initialize(listener, options)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        youTubePlayerView1.release()
        youTubePlayerView2.release()
    }
}
