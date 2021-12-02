package com.example.spinners.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinners.R
import com.example.spinners.databinding.ActivityEj3Binding

class Ej4FromResourceActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityEj3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creando el adaptador desde un recurso
        binding.spinner3.adapter = ArrayAdapter.createFromResource(
            this, R.array.planetas, android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinner3.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        binding.textViewElection.text = "Elección: ${parent.selectedItem}"
        binding.textViewId.text = "Id: $id"
        binding.textViewPosition.text = "Posición: $position"
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}


}