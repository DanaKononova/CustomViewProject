package com.example.customviewproject

class FanCounter(var count: Int, var finalScore: Int) {

    fun next(): Int {
        count += 1
        return count
    }
}