package com.inc.iana.aboutiana.activities

import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync
import android.util.Log
import android.arch.lifecycle.MutableLiveData
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.widget.Toast
import com.inc.iana.aboutiana.ApiService.BloggerApiService
import com.inc.iana.aboutiana.Model.PostList
import com.inc.iana.aboutiana.R
import com.inc.iana.aboutiana.adapters.MainActivityPagerAdapter
import com.inc.iana.aboutiana.fragments.AndroidFragment
import com.inc.iana.aboutiana.fragments.DataScienceFragment
import com.inc.iana.aboutiana.fragments.PythonFragment
import com.inc.iana.aboutiana.fragments.RFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener , DataScienceFragment.OnFragmentInteractionListener,
        AndroidFragment.OnFragmentInteractionListener, PythonFragment.OnFragmentInteractionListener,RFragment.OnFragmentInteractionListener{

    private lateinit var mPagerAdapter: MainActivityPagerAdapter
    private lateinit var mViewPager: ViewPager
    private var tabLayout: TabLayout? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPagerAdapter = MainActivityPagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.pager)
        setupViewPager(mViewPager)

        tabLayout = findViewById(R.id.tablayout) as TabLayout
        tabLayout!!.setupWithViewPager(mViewPager)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


    }

    private fun setupViewPager(viewPager: ViewPager) {
        val mPagerAdapter = MainActivityPagerAdapter(supportFragmentManager)
        mPagerAdapter.addFragment(DataScienceFragment(), "Data Science")
        mPagerAdapter.addFragment(AndroidFragment(), "Android")
        mPagerAdapter.addFragment(PythonFragment(), "Python")
        mPagerAdapter.addFragment(RFragment(), "R")
        mViewPager.adapter = mPagerAdapter
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_account -> {
                Toast.makeText(this, "My Account", Toast.LENGTH_SHORT).show();
            }
            R.id.nav_settings -> {
                Toast.makeText(this, "My Settings", Toast.LENGTH_SHORT).show();
            }
            R.id.nav_manage -> {
                Toast.makeText(this, "My Tools", Toast.LENGTH_SHORT).show();
            }
            R.id.nav_share -> {
                Toast.makeText(this, "My Share", Toast.LENGTH_SHORT).show();
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(uri: Uri) {
        //you can leave it empty
    }
}
