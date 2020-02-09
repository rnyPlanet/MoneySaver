package com.grin.moneysaver

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.grin.moneysaver.fragments.CategoriesFragment
import com.grin.moneysaver.fragments.OperationsFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation: BottomNavigationView = findViewById(R.id.nav_view)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.container, CategoriesFragment(), CategoriesFragment::class.java.getSimpleName())
            .commit()
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            var fragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.categories -> {
                    fragment = CategoriesFragment()
                }
                R.id.operations -> {
                    fragment = OperationsFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment!!, fragment.javaClass.getSimpleName())
                .commit()

            return true
        }

    }
}
