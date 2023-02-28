package com.example.customviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.customviewproject.homework_view.FanIterator
import com.example.customviewproject.homework_view.IteratorView

class MainActivity : AppCompatActivity() {

    companion object {
        var buttonText = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var text: String
        var count = 1
        buttonText = getString(R.string.plus_bt)
        button.setOnClickListener {
            text = if (count % 2 == 0) getString(R.string.plus_bt) else getString(R.string.minus_bt)
            button.text = text
            buttonText = text
            count++
        }
    }
}