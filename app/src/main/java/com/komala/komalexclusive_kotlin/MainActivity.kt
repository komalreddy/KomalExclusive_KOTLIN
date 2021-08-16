package com.komala.komalexclusive_kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.komala.komalexclusive_kotlin.ui.weather.WeatherFragment

class MainActivity : AppCompatActivity() {

    private var dl: DrawerLayout? = null
    private var t: ActionBarDrawerToggle? = null
    private var nv: NavigationView? = null
    private var selectedCountry: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dl = findViewById(R.id.drawer_layout)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)
        t!!.isDrawerIndicatorEnabled = true
        dl!!.addDrawerListener(t!!)
        t!!.syncState()
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        nv = findViewById(R.id.navigationView)
        nv!!.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.nav_weather -> {
                    Toast.makeText(applicationContext, "Whether", Toast.LENGTH_SHORT).show()
                    launchFragment(Bundle(), WeatherFragment.newInstance("", ""))
                }
                else -> return@OnNavigationItemSelectedListener true
            }
            dl!!.closeDrawer(GravityCompat.START)
            true
        })
    }

    //    fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        return if (t!!.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item!!)
//    }
    override fun onBackPressed() {
        if (dl!!.isDrawerOpen(GravityCompat.START)) {
            dl!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun launchFragment(bundle: Bundle?, fragment: Fragment) {
        fragment.arguments = bundle
        val fragmentTransaction =
            supportFragmentManager.beginTransaction().replace(R.id.content_frame, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}

