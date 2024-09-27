package com.example.dots.PantNanoLab

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dots.R

class DataNanoLabActivity : AppCompatActivity() {
    /*DEFINICION DE OBJETOS VISUALES------------------------------------------------*/
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DatosNanolabAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_nano_lab)


            val listaDatos = listOf(
            DatoNanolab("Ácido Ascórbico (ASC)", "57", "mg/dl"),
            DatoNanolab("Glucosa (GLU)", "3", "mg/dl"),
            DatoNanolab("Bilirrubina (BIL)", "7", "mg/dl"),
            DatoNanolab("Cuerpos cetónicos (KET)", "5", "mg/dl"),
            DatoNanolab("Proteínas (PRO)", "2", "g/ml")
        )

        InitComponent()
            recyclerView.layoutManager = LinearLayoutManager(this)

            // Configurar el adaptador
            adapter = DatosNanolabAdapter(listaDatos) { dato ->
                // Acción al hacer clic en un elemento (por ejemplo, actualizar el gráfico)
                mostrarGrafico(dato)
            }

            recyclerView.adapter = adapter


    }
    private fun InitComponent(){
        recyclerView = findViewById(R.id.recyclerViewDatos)

    }
    private fun InitListeners(){

    }

    private fun mostrarGrafico(dato: DatoNanolab) {
    }
}