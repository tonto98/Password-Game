package com.example.password_game.model

import java.io.Serializable

data class Team(
    private val teamName: String
): Serializable {
    private var points: Int = 0

    fun incrementPoints(numberOfPoints: Int) {
        points += numberOfPoints
    }

    fun getPoints(): Int {
        return points
    }

    fun getName(): String{
        return teamName
    }
}