package com.inc.iana.aboutiana.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.inc.iana.aboutiana.fragments.AndroidFragment
import com.inc.iana.aboutiana.fragments.DataScienceFragment
import com.inc.iana.aboutiana.fragments.PythonFragment
import com.inc.iana.aboutiana.fragments.RFragment

class MainActivityPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }
}
