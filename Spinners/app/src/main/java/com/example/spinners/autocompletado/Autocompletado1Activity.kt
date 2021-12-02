package com.example.spinners.autocompletado

import com.example.spinners.R
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spinners.databinding.ActivityAutocompletado1Binding
import java.util.*

class Autocompletado1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAutocompletado1Binding

    // Array y ArrayList de palabras que puede elegir el Usuario, ejemplificando el caso de que fuesen cargadas dinámicamente
    private val arrayAutocompletado =
        arrayOf("Abel", "Ana", "Anacleto", "Anastasio", "Anastasia", "Anibal", "Antonio")
    private val arrayNombres: List<String> = ArrayList(listOf(*arrayAutocompletado))  //TODO: *?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutocompletado1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // Cargando desde el Array
        val adapter1 = ArrayAdapter<CharSequence>(
            this, android.R.layout.select_dialog_item, arrayAutocompletado
        )

        // O cargando desde la lista
        val adapter2: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.select_dialog_item, arrayNombres
        )

        // Si el array de elementos no se va a generar dinámicamente, tiene más sentido leerlo de un recurso
        val adapter3 = ArrayAdapter<CharSequence>(
            this, android.R.layout.select_dialog_item, resources.getStringArray(R.array.nombres)
        )

        // Para lo cual, mejor, existe un método específico:
        val adapter =
            ArrayAdapter.createFromResource(
                this, R.array.nombres, android.R.layout.select_dialog_item
            )

        // Para que el Autocompletado empiece a dar sugerencias desde la primera letra que se introduzca
        binding.actvProvincias.threshold = 1

        // Añadimos el Adaptador al autoCompleteTextView
        binding.actvProvincias.setAdapter<ArrayAdapter<CharSequence>>(adapter)

        // Listener sobre la elección de una de las opciones
        binding.actvProvincias.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                applicationContext,
                //"Has elegido el nombre ${binding.autoCompleteTextView.text}",
                "Has elegido el nombre ${(view as TextView).text}",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}