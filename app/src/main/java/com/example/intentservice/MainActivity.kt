package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartService.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                startService(it)
                tvServiceStatus.text="Service is Running..."

            }

        }

        btnStopService.setOnClickListener {
            MyIntentService.stopService()
            tvServiceStatus.text="Service is not Running..."

        }
    }
    override fun onDestroy() {
        Log.d("MyIntentService","App is destroyed...")
        MyIntentService.stopService()
        super.onDestroy()
    }
}