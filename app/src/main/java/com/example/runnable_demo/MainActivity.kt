package com.example.runnable_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1 = findViewById(R.id.tv1)
        btn = findViewById(R.id.btnStart)
        val msg1 = "hello"
        val msg2 = "Good Afternoon"

        btn.setOnClickListener {
            // declaring main thread
            Thread(Runnable {
                while (true) {
                    //updating text view at current iteration
                    runOnUiThread { tv1.text = msg1 }
                    // thread sleeps for 1 sec
                    Thread.sleep(1000)
                    // updating text view at current iteration
                    runOnUiThread { tv1.text = msg2 }
                    // thread sleeps for 1 sec
                    Thread.sleep(1000)
                }
            }).start()
        }
    }
}