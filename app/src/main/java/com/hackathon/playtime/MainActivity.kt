package com.hackathon.playtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackathon.playtime.ui.view.GamesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GamesListFragment.newInstance())
                .commitNow()
        }
    }
}