package com.example.spinners.spinners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.spinners.R
import com.example.spinners.databinding.ActivityEj6Binding
import java.util.ArrayList

class Ej6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEj6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj6Binding.inflate(layoutInflater)
        setContentView(binding.root)


        /* Selecciona el primer elemento antes de setear el escuchador, evitando que este salte en
        el momento en el que se carga de elementos */
        binding.spinner61.setSelection(0, false)

        /* Se le asigna al primer spinner el escuchador para cuando se seleciona uno de sus elementos.
		En este caso, se está definiendo el escuchador en otra clase */
        binding.spinner61.onItemSelectedListener = CustomOnItemSelectedListener()

        val arrayList: MutableList<String> = ArrayList()  // Añadimos items dinámicamente al segundo spinner
        arrayList.add("elemento 1")
        arrayList.add("elemento 2")
        arrayList.add("elemento 3")

        // El ArrayAdapter es el intermediario entre el arraylist y el AdapterView (el spinner)
        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayList
        )
        arrayAdapter.setDropDownViewResource(R.layout.item_guay)
        binding.spinner62.adapter = arrayAdapter

        /* Seteamos programáticamente un título para el spinner, que se mostrará
        ya que está definido en modo "dialog" */
        binding.spinner62.prompt = resources.getString(R.string.item_prompt)

        binding.spinner63.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.array_paises,
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.btnSubmit.setOnClickListener {
            Toast.makeText(
                this,
                """OnClickListener : 
                Spinner 1 : ${binding.spinner61.selectedItem}
                Spinner 2 : ${binding.spinner61.selectedItem}
                """.trimIndent(),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}

class CustomOnItemSelectedListener : AdapterView.OnItemSelectedListener {

    /**
     * Método de callback al que se invoca cuando se selecciona un elemento de un listado (el spinner1, en este caso)
     *
     * @param adapterView Vista que contiene los elementos, en este caso, el spinner.
     *                    (spinner es una de las clases que heredan de AdapterView: clases que utilizan adaptadores.
     *                    En general, se trata de views consistententes en listados de elementos)
     * @param view        Vista concreta del elemento (el elemento TextView que se pulsa dentro del spinner.
     * @param posicion    la posición del elemento en el adaptador
     * @param id          la id de la fila seleccionada
     */
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(
            parent?.context,
            """OnItemSelectedListener:
                ${parent?.getItemAtPosition(position)}
                ${(view as TextView).text}
                """.trimIndent(),  // Dos modos de hacer lo mismo
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

}
