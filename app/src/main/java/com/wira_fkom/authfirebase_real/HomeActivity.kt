package com.wira_fkom.authfirebase_real

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.wira_fkom.authfirebase_real.bottom_fragment.CartFragment
import com.wira_fkom.authfirebase_real.bottom_fragment.CategoryFragment
import com.wira_fkom.authfirebase_real.bottom_fragment.HistoryFragment
import com.wira_fkom.authfirebase_real.bottom_fragment.NotificationFragment
import com.wira_fkom.authfirebase_real.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_category -> {
                    replaceFragment(CategoryFragment())
                    title = "Category"
                }
                R.id.bottom_history -> {
                    replaceFragment(HistoryFragment())
                    title = "History"
                }
                R.id.bottom_notification -> {
                    replaceFragment(NotificationFragment())
                    title = "Notification"
                }
                R.id.bottom_cart -> {
                    replaceFragment(CartFragment())
                    title = "Cart"
                }
            }
            true
        }

        replaceFragment(CategoryFragment())
        title = "Category"

        val addFab = binding.addFabBtn
        addFab.setOnClickListener {
            Toast.makeText(this,"Add Clicked", Toast.LENGTH_LONG).show()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.bottomFragment.id, fragment)
            .commit()
    }

    fun onLogoutClick(view: View) {
        auth.signOut()
        Intent(this@HomeActivity, LoginActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

}
