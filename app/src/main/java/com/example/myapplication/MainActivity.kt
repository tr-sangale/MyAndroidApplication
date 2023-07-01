package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)

        button.setOnClickListener {
            val inputText = editText.text.toString()
            val displayText = inputText.ifBlank {
                "Button Clicked"
            }
            textView.text = displayText
        }
    }
}