package com.example.spinners.autocompletado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spinners.R
import com.example.spinners.databinding.ActivityAutocompletadoBinding

class AutocompletarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAutocompletadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutocompletadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAutocompletar1.setOnClickListener { startActivity(Intent(this, Autocompletado1Activity::class.java)) }
        binding.btnAutocompletar2.setOnClickListener { startActivity(Intent(this, Autocompletado2Activity::class.java)) }
        binding.btnAutocompletar3.setOnClickListener { startActivity(Intent(this, Autocompletado3Activity::class.java)) }

    }

}