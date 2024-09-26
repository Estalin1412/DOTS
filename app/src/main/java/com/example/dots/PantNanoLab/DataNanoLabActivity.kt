package com.example.dots.PantNanoLab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dots.R

class DataNanoLabActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DatosNanolabAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_nano_lab)

        val listaDatos = listOf(
            Dato("Ácido Ascórbico (ASC)", "57", "mg/dl"),
            Dato("Glucosa (GLU)", "3", "mg/dl"),
            Dato("Bilirrubina (BIL)", "7", "mg/dl"),
            Dato("Cuerpos cetónicos (KET)", "5", "mg/dl"),
            Dato("Proteínas (PRO)", "2", "g/ml")
        )

        recyclerView = findViewById(R.id.recyclerViewDatos)
        recyclerView.layoutManager = LinearLayoutManager(this)

            recyclerView = findViewById(R.id.recyclerViewDatos)
            recyclerView.layoutManager = LinearLayoutManager(this)

            // Configurar el adaptador
            adapter = DatosNanolabAdapter(listaDatos) { dato ->
                // Acción al hacer clic en un elemento (por ejemplo, actualizar el gráfico)
                mostrarGrafico(dato)
            }

            recyclerView.adapter = adapter

    }


    private fun mostrarGrafico(dato: Dato) {
    }
}