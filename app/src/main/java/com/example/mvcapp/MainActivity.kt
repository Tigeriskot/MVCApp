package com.example.mvcapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {


    var myModel: Model? = null


    var Button1: Button? = null
    var Button2: Button? = null
    var Button3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myModel = Model()
        myModel!!.addObserver(this)

        Button1 = findViewById(R.id.button)
        Button2 = findViewById(R.id.button2)
        Button3 = findViewById(R.id.button3)



        Button1?.setOnClickListener(this)
        Button2?.setOnClickListener(this)
        Button3?.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> myModel?.setValueAtIndex(0)
            R.id.button2 -> myModel?.setValueAtIndex(1)
            R.id.button3 -> myModel?.setValueAtIndex(2)
        }
    }


    override fun update(arg0: Observable, arg1: Any?) {

        Button1!!.text = "Count: " + myModel!!.getValueAtIndex(0)
        Button2!!.text = "Count: " + myModel!!.getValueAtIndex(1)
        Button3!!.text = "Count: " + myModel!!.getValueAtIndex(2)
    }
}
