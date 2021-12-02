package com.example.spinners.autocompletado

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.spinners.databinding.ActivityAutocompletado2Binding

class Autocompletado2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAutocompletado2Binding

    // Array de las Provincias
    private val arrayProvincias = arrayOf(
        "A Coruña", "Almería", "Alicante", "León", "Lugo",
        "Ourense", "Palencia", "Pontevedra"
    )
    private val sinLocalidades = arrayOf("No tenemos localidades")

    // Arrays de las Localidades
    private val arrayCoruña = arrayOf("Arteixo", "La Coruña", "Ferrol", "Betanzos")
    private val arrayPontevedra = arrayOf("Vigo", "Baiona", "Cangas", "Moaña")
    private val arrayLugo = arrayOf("Abadín", "Burela", "Foz", "Guitiriz")
    private val arrayOurense = arrayOf("Allariz", "Barbadás", "Carballiño", "Verín")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutocompletado2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val adaptador: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.simple_spinner_item, arrayProvincias)
        binding.actvProvincias.threshold = 1
        binding.actvProvincias.setAdapter<ArrayAdapter<String>>(adaptador)

        binding.actvProvincias.setOnItemClickListener { parent, view, position, id ->
            when (binding.actvProvincias.text.toString()) {
                 "A Coruña" -> {
                    cargarLocalidadesSpinner(arrayCoruña)
                    mostrarToast()
                    mostrarToastLocalidades()
                }
                "Lugo" -> {
                    cargarLocalidadesSpinner(arrayLugo)
                    mostrarToast()
                    mostrarToastLocalidades()
                }
                "Ourense" -> {
                    cargarLocalidadesSpinner(arrayOurense)
                    mostrarToast()
                    mostrarToastLocalidades()
                }
                "Pontevedra" -> {
                    cargarLocalidadesSpinner(arrayPontevedra)
                    mostrarToast()
                    mostrarToastLocalidades()
                }
                else -> {
                    cargarLocalidadesSpinner(sinLocalidades)
                    Toast.makeText(
                        applicationContext, "Aún no se han definido localidades", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }


    fun cargarLocalidadesSpinner(array: Array<String>) { // TODO: array nullable?
        // Creamos el Adaptador con el Array de Localidades recibido
        val adaptador = ArrayAdapter(applicationContext, R.layout.simple_spinner_item, array)
        // Añadimos el Adaptador al Spinner de Localidades
        binding.spinnerLocalidades.adapter = adaptador
    }

    fun mostrarToast() {
        Toast.makeText(
            this, """
     Provincia: ${binding.actvProvincias.text}
     Localidad: ${binding.spinnerLocalidades.selectedItem}
     """.trimIndent(), Toast.LENGTH_SHORT
        ).show()
    }

    fun mostrarToastLocalidades() {
        binding.spinnerLocalidades.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        applicationContext, """
         Provincia: ${binding.actvProvincias.text}
         Localidad: ${binding.spinnerLocalidades.selectedItem}
         """.trimIndent(), Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

}