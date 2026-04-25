package com.example.loginsignupsql_flow

import android.R.id.home
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

public class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.drawerArrowDrawable.color = ContextCompat.getColor(this, R.color.blue)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, Home())
                .commit()

            navigationView.setCheckedItem(R.id.home)
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Home())
                    .commit()
            }
            R.id.account -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Account())
                    .commit()
            }
            R.id.calculator -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Calculator())
                    .commit()
            }
            R.id.daily -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Daily_intake())
                    .commit()
            }
            R.id.history -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, History())
                    .commit()
            }
            R.id.notifications -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Notifications())
                    .commit()
            }
            R.id.settings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Settings())
                    .commit()
            }
            R.id.logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        fun onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }

        return true
    }
}