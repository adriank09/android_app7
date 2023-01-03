package com.example.app7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize a list of 3 fragments
        val fragmentList = ArrayList<Fragment>()

        // add 3 new Fragments into the list
        fragmentList.add(SimpleFragment.newInstance("1"))
        fragmentList.add(SimpleFragment.newInstance("2"))
        fragmentList.add(SimpleFragment.newInstance("3"))

        val pageAdapter = SimpleFragmentPageAdapter(supportFragmentManager, fragmentList)
        val pager = findViewById<ViewPager2>(R.id.viewPager2)
        pager.adapter = pageAdapter
    }

    inner class SimpleFragmentPageAdapter(fm: FragmentManager,
                                          private val fragments: ArrayList<Fragment>)
        : FragmentStateAdapter(fm, lifecycle ) {
        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments.elementAt(position)
        }
    }
}