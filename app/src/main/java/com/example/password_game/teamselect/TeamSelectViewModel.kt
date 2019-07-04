package com.example.password_game.teamselect

import android.app.Activity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.example.password_game.MainActivity
import com.example.password_game.model.Team

class TeamSelectViewModel : ViewModel(){

    companion object{
        val TEAM1_KEY = "team1"
        val TEAM2_KEY = "team2"
    }

    lateinit var team1: Team
    lateinit var team2: Team

    private var m_team1Name = MutableLiveData<String>()
    val team1Name: LiveData<String>
        get() = m_team1Name

    private var m_team2Name = MutableLiveData<String>()
    val team2Name: LiveData<String>
        get() = m_team2Name



    fun initTeams(team1Name: String, team2Name: String){
        m_team1Name.value = team1Name
        m_team2Name.value = team2Name
        team1 = Team(team1Name)
        team2 = Team(team2Name)
    }

    fun showGameScreen(activity: FragmentActivity?){
        var bundle = Bundle()
        bundle.putSerializable("team1", team1)
        bundle.putSerializable("team2", team2)
        activity?.supportFragmentManager?.beginTransaction()?.replace(MainActivity.CONTAINER_ID, GameFragment::class.java/*,TODO: napravi newInstance companion object i stavi tag*/)?
    }
}