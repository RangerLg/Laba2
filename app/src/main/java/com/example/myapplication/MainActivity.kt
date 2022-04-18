package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.Fragment_Place, LogIn.newInstance("", "")).commit()
    }

    fun ChangeFragment(f: Fragment) {
        if (f is EditF) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.Fragment_Place, f)
                .addToBackStack("Profile")
                .commit()
        } else {
            supportFragmentManager.popBackStack()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.Fragment_Place, f)
                .commit()
        }
    }
}