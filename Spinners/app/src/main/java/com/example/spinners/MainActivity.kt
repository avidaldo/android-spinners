package com.example.spinners

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spinners.autocompletado.AutocompletarActivity
import com.example.spinners.databinding.ActivityMainBinding
import com.example.spinners.spinners.*


/* https://developer.android.com/guide/topics/ui/controls/spinner */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toSpinners.setOnClickListener { startActivity(Intent(this, SpinnersActivity::class.java)) }
        binding.toAutocompletar.setOnClickListener { startActivity(Intent(this, AutocompletarActivity::class.java)) }

    }

}