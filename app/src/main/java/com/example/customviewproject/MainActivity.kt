package com.example.customviewproject

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
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
        val transferBt = findViewById<Button>(R.id.button2)

        transferBt.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

//        val animator = ValueAnimator.ofFloat(1f, 0f)
//        animator.addUpdateListener { animation ->
//            iterator.alpha = (animation.animatedValue as Float)
//        }
        val set = AnimationUtils.loadAnimation(this, R.anim.set_animation)
        set.fillAfter = true
        var alpha = 0f
        button.setOnClickListener {

            if (button.text == getString(R.string.plus_bt)){
                button.text = getString(R.string.minus_bt)
            }else button.text = getString(R.string.plus_bt)
            iterator.onStateChange()
//            animator.duration = 4000
//            animator.start()
//            ObjectAnimator.ofFloat(iterator, View.ROTATION_X,0f, 360f).setDuration(4000).start()
//            ObjectAnimator.ofFloat(iterator, View.ROTATION_Y,0f, 360f).setDuration(4000).start()
//            ObjectAnimator.ofFloat(iterator, View.SCALE_X,0f, 30f).setDuration(4000).start()
//            iterator.animate().rotationBy(alpha).rotation(alpha+720).start()
//            alpha += 720f
            iterator.startAnimation(set)
        }


    }
}