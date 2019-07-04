package com.example.password_game.teamselect

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.password_game.MainActivity
import com.example.password_game.R

class TeamSelectFragment : Fragment(), View.OnClickListener{
    private lateinit var team1NameTextView: TextView
    private lateinit var team2NameTextView: TextView
    private lateinit var team1NameInput: EditText
    private lateinit var team2NameInput: EditText
    private lateinit var startButton: Button

    private lateinit var viewModel: TeamSelectViewModel

    companion object{
        val TAG = "TeamSelectFragment"

        @JvmStatic
        fun newInstance(): TeamSelectFragment = TeamSelectFragment() // isto sta i return ovo desno od =
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_team_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModelAndSetObservers()

        initUiElements(view)

        startButton.setOnClickListener(this::onClick)

    }

    override fun onClick(v: View?) {
        viewModel.initTeams(team1NameInput.text.toString(), team2NameInput.text.toString())
        viewModel.showGameScreen(activity)
    }

    private fun initViewModelAndSetObservers(){
        viewModel = ViewModelProviders.of(this).get(TeamSelectViewModel::class.java)
        setObservers()
    }

    fun setObservers(){
        viewModel.team1Name.observe(this, Observer { team1Name ->
            team1NameTextView.text = team1Name
        })
        viewModel.team2Name.observe(this, Observer { team2Name ->
            team2NameTextView.text = team2Name
        })
    }

    private fun initUiElements(view: View){
        team1NameTextView = view.findViewById(R.id.fragment_team_select_team1_text_view)
        team2NameTextView = view.findViewById(R.id.fragment_team_select_team2_text_view)
        team1NameInput = view.findViewById(R.id.fragment_team_select_team1_input)
        team2NameInput = view.findViewById(R.id.fragment_team_select_team2_input)
        startButton = view.findViewById(R.id.fragment_team_select_start_button)
    }
}