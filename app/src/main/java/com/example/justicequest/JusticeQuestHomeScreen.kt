package com.example.justicequest

import JusticeQuestContactHelp
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.justicequest.databinding.ActivityJusticeQuestHomeScreenBinding

class JusticeQuestHomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityJusticeQuestHomeScreenBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityJusticeQuestHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar1)

        // Enable toggle button (hamburger menu)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout1, binding.toolbar1, R.string.open, R.string.close)
        binding.drawerLayout1.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        replaceFragment(JusticeQuestMenuScreen())

        // Navigation item selection listener
        binding.navigationView2.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_about -> replaceFragment(JusticeQuestAboutUs())
                R.id.nav_home -> replaceFragment(JusticeQuestMenuScreen())
                R.id.nav_details -> replaceFragment(JusticeQuestDetailsScreen())
                R.id.nav_logout -> showToast("Logout Screen")
                R.id.nav_help -> replaceFragment(JusticeQuestContactHelp())
                R.id.nav_rate_us -> replaceFragment(JusticeQuestRateUsScreen())
            }
            binding.drawerLayout1.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer1, fragment)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }
}