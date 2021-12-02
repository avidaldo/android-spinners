package com.example.spinners.autocompletado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import com.example.spinners.R
import com.example.spinners.databinding.ActivityAutocompletado3Binding

class Autocompletado3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAutocompletado3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutocompletado3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.actvProvincias.setAdapter<ArrayAdapter<CharSequence>>(
            ArrayAdapter.createFromResource(
                this, R.array.provincias_espana,
                android.R.layout.simple_spinner_item
            )
        )
        binding.actvProvincias.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                when (binding.actvProvincias.text.toString()) {
                    "A Coruña" -> setSpinner(R.array.ciudades_corunha)
                    "Lugo" -> setSpinner(R.array.ciudades_lugo)
                    "Ourense" -> setSpinner(R.array.ciudades_ourense)
                    "Pontevedra" -> setSpinner(R.array.ciudades_pontevedra)
                    else -> {
                        Toast.makeText(
                            this,
                            "No hay ciudades registradas de esa provincia",
                            Toast.LENGTH_SHORT
                        ).show()
                        setSpinner(null)
                    }
                }
            }

    }

    private fun setSpinner(recurso: Int?) {
        if (recurso == null) {
            binding.spinnerCiudades.visibility = View.GONE
            binding.tvCiudades.visibility = View.GONE
        } else {
            binding.spinnerCiudades.adapter = ArrayAdapter.createFromResource(
                this,
                recurso,
                android.R.layout.simple_spinner_dropdown_item
            )
            binding.spinnerCiudades.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View,
                        position: Int,
                        id: Long
                    ) {
                        Toast.makeText(
                            this@Autocompletado3Activity, """
             Provincia: ${binding.actvProvincias.text}
             Localidade: ${binding.spinnerCiudades.selectedItem}
             """.trimIndent(), Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
            binding.tvCiudades.visibility = View.VISIBLE
            binding.spinnerCiudades.visibility = View.VISIBLE
        }
    }

}