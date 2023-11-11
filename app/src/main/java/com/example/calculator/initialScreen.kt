package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.calculator.databinding.ActivityInitialScreenBinding
import com.example.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_initial_screen.etEnterYourname
import kotlinx.android.synthetic.main.activity_initial_screen.view.etEnterYourname


class initialScreen : AppCompatActivity() {
    private lateinit var binding: ActivityInitialScreenBinding
    var count = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInitialScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            var name = etEnterYourname.text.toString()
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("m",name)
            startActivity(intent)
        }



    }
}