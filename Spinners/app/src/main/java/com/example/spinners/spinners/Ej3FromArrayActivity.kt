package com.example.spinners.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinners.R
import com.example.spinners.databinding.ActivityEj3Binding

class Ej3FromArrayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEj3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Partimos de un array. Lógicamente, en un caso real no tendría sentido definir un
         * array a base de literales hardcodeados. Sirve de ejemplo, pero este método para cargar
         * spinners solo tendría sentido si el array se carga en tiempo de ejecución */
        val arrayPlanets = arrayOf(
            "Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"
        )

        /* El ArrayAdapter la abstracción intermedia que relaciona el array con el listado de elementos
        * del spinner */
        val arrayAdapter = ArrayAdapter(
            this,
            /* El segundo parámetro es el layout con el diseño del elemento cuando está seleccionado */
            //android.R.layout.simple_list_item_1,
            R.layout.item_guay,
            /* El último parámetro pasa el listado de los elemento a adaptar, en este caso en un array de Strings */
            arrayPlanets
        )

        // Asignación del layout de cada elemento cuando se despliega la lista
        arrayAdapter.setDropDownViewResource(
            //android.R.layout.simple_spinner_dropdown_item
            R.layout.chachi_spinner_item
        )

        // Utilizando un adaptador podemos cargar los elementos dinámicamente en el spinner
        binding.spinner3.adapter = arrayAdapter


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