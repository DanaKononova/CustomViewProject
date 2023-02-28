package com.example.customviewproject.iterator_game_view

class FanCounter(var count: Int, var finalScore: Int) {

    fun next(): Int {
        count += 1
        return count
    }
}