package com.example.spinners.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spinners.databinding.ActivityEj1Binding

class Ej1EntriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEj1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.textViewElection.text = binding.spinner.selectedItem.toString()
            binding.textViewId.text = binding.spinner.selectedItemId.toString()
            binding.textViewPosition.text = binding.spinner.selectedItemPosition.toString()

        }

    }

}