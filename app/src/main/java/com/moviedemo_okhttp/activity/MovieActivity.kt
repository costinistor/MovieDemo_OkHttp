package com.moviedemo_okhttp.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.moviedemo_okhttp.R
import kotlinx.android.synthetic.main.empty_layout.*

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
        //val lv = LinearLayout(this)
        lv.setBackgroundColor(Color.RED)

        val title = TextView(this)
        title.text = "I have something to say"
        title.setTextColor(Color.WHITE)
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26f)
        val param = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        param.circleRadius= 60

        title.layoutParams = param

        //title.textAlignment = View.TEXT_ALIGNMENT_CENTER

        lv.addView(title)
    }
}