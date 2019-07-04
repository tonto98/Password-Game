package com.example.password_game

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.password_game.teamselect.TeamSelectFragment

class MainActivity : AppCompatActivity() {

    companion object{
        val CONTAINER_ID = R.id.activity_main_fragment_container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(CONTAINER_ID, TeamSelectFragment.newInstance(), TeamSelectFragment.TAG).commit()
    }



}
