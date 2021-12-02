package com.example.spinners.spinners

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spinners.databinding.ActivitySpinnersBinding


class SpinnersActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpinnersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelectorEj.setOnClickListener {
            val seleccion = binding.mainSpinner.selectedItemPosition
            startActivity(
                Intent(
                    this,
                    when (seleccion) {
                        0 -> Ej1EntriesActivity::class.java
                        1 -> Ej2OnItemSelectedActivity::class.java
                        2 -> Ej3FromArrayActivity::class.java
                        3 -> Ej4FromResourceActivity::class.java
                        4 -> Ej5FromArrayListActivity::class.java
                        5 -> Ej6Activity::class.java
                        else -> throw Exception("Opción no existente")
                    }
                )
            )
        }

    }
}