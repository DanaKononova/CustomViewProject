package com.example.customviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.customviewproject.homework_view.FanIterator
import com.example.customviewproject.homework_view.IteratorView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.text = getString(R.string.plus_bt)
        val iterator = findViewById<IteratorView>(R.id.iterator)
        button.setOnClickListener {
            if (button.text == getString(R.string.plus_bt)){
                button.text = getString(R.string.minus_bt)
            }else button.text = getString(R.string.plus_bt)
            iterator.onStateChange()
        }
    }
}