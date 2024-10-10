package com.example.dots.PantNanoLab

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidplot.xy.LineAndPointFormatter
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.XYPlot
import com.androidplot.xy.XYSeries
import com.example.dots.R
import java.io.BufferedReader
import java.io.InputStreamReader


class NanoLabMainDataLabActivity : AppCompatActivity() {
    /*DEFINICION DE OBJETOS VISUALES------------------------------------------------*/
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DatosNanolabAdapter

    private lateinit var plot: XYPlot

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nano_lab_main_data)


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

            }

            recyclerView.adapter = adapter


    }
    private fun InitComponent(){
        recyclerView = findViewById(R.id.recyclerViewDatos)

        val graphContainer = findViewById<FrameLayout>(R.id.graphContainer)

        // Crear el gráfico
        plot = XYPlot(this, "Gráfico de CSV")
        plot.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        // Agregar el gráfico al contenedor
        graphContainer.addView(plot)

        // Leer los datos del archivo CSV y configurarlos en el gráfico
        val (xValues, yValues) = leerCsvDesdeAssets()

        // Configurar el gráfico con los datos
        configurarGrafico(xValues, yValues)
    }
    private fun InitListeners(){

    }
    /*FUNCIONES DEPENDIENTES--------------------------------------------------------------------*/
    fun leerCsvDesdeAssets(): Pair<List<String>, List<Double>> {
        val xVals = mutableListOf<String>() // Lista para las horas
        val yVals = mutableListOf<Double>() // Lista para los valores decimales

        try {
            val inputStream = assets.open("datos.csv") // Lee el archivo data1.csv desde assets
            val reader = BufferedReader(InputStreamReader(inputStream))

            reader.forEachLine { linea ->
                // Eliminar caracteres BOM al inicio de la primera línea si están presentes
                var lineaLimpia = linea
                if (lineaLimpia.startsWith("﻿")) {
                    lineaLimpia = lineaLimpia.substring(1) // Elimina el primer carácter (BOM)
                }

                val columnas = lineaLimpia.split(";") // Cambia el separador a punto y coma (;)
                val y = columnas[1].toDouble() // Primera columna (valor decimal)
                val x = columnas[0].trim() // Segunda columna (hora)

                yVals.add(y)
                xVals.add(x)
            }

            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("CSV", "Error al leer el archivo CSV: ${e.message}")
        }

        return Pair(xVals, yVals) // Retorna las dos listas
    }



    private fun configurarGrafico(xValues: List<String>, yValues: List<Double>) {
        // Crear una serie con los valores del eje Y
        val series1: XYSeries = SimpleXYSeries(
            yValues, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Valores del CSV"
        )

        // Crear un formato para la línea y los puntos
        val series1Format = LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels)

        // Omitir los valores (puntos con etiquetas)
        series1Format.pointLabelFormatter = null

        // Añadir la serie al gráfico
        plot.addSeries(series1, series1Format)

        // Redibujar el gráfico
        plot.redraw()
    }
}