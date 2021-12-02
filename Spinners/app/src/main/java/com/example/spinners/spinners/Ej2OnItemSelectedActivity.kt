package com.example.spinners.spinners

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.example.spinners.databinding.ActivityEj2Binding

class Ej2OnItemSelectedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEj2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Selecciona el primer elemento antes de setear el escuchador, evitando que este salte en
        el momento en el que se carga de elementos */
        //binding.spinner2.setSelection(0,false)

        /* Seteamos un escuchador para el evento de cambio de evento seleccionado
        en el spinner. */
        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                binding.textViewElection.text = "Elección: ${(view as TextView).text}"
                //binding.textViewElection.text = "Elección: ${parent.selectedItem}"  // Otro modo de acceder
                binding.textViewId.text = "Id: $id"
                binding.textViewPosition.text = "Posición: $position"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }

}