package com.example.spinners.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.spinners.databinding.ActivityEj3Binding
import java.util.ArrayList

class Ej5FromArrayListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEj3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val planetas: MutableList<String> = ArrayList()
        planetas.add("Mercurio")
        planetas.add("Venus")
        planetas.add("Tierra")
        planetas.add("Marte")
        planetas.add("Júpiter")
        planetas.add("Saturno")
        planetas.add("Urano")
        planetas.add("Neptuno")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planetas)

        binding.spinner3.adapter = adapter

        binding.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                binding.textViewElection.text = "Elección: ${parent.selectedItem}"
                binding.textViewId.text = "Id: $id"
                binding.textViewPosition.text = "Posición: $position"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }

}