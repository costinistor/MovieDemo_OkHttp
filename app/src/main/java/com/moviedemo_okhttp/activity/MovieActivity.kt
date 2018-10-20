package com.moviedemo_okhttp.activity

import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView


class MovieActivity : AppCompatActivity() {

    var lv: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.empty_layout)

        lv = ConstraintLayout(this)

        setContentView(lv)

        mainContainer(lv!!)
    }

    fun mainContainer(lv: ConstraintLayout){
        lv.setBackgroundColor(Color.RED)

        val title = TextView(this)
        title.text = "I have something to say"
        title.setTextColor(Color.WHITE)
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f)
        val param = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        title.layoutParams = param

        lv.addView(title)
    }
}