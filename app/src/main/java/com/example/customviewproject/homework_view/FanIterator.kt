package com.example.customviewproject.homework_view

class FanIterator(var count: Int, var finalScore: Int, var operation: Int) {
    fun next(): Int {
        count += operation
        return count
    }
}