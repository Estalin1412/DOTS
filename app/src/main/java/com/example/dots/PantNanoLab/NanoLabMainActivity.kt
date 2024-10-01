package com.example.dots.PantNanoLab

import ButtonAdapter
import ButtonData
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dots.R


class NanoLabMainActivity : AppCompatActivity() {


    /*----------------Definicion de objeto visuales(botones, textoeditables, recicladores visuales---*/
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonsAdapter: ButtonAdapter
    /*Definicion de Objetos con listas----------------------------------------------------*/
    val buttonList = mutableListOf<ButtonData>(
        ButtonData(R.drawable.batch_path1_ajustes, "Nano 1"),
        ButtonData(R.drawable.batch_path1_ajustes, "Nano 2")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nano_lab_main)


        InitComponents()
        InitListeners()
    }
    /*----------------FUNCIONES INDEPENDIENTES(funciones que se ejecutan si o si)---------*/
    public fun InitComponents(){
        recyclerView = findViewById(R.id.recyclerViewButtons)


        buttonsAdapter = ButtonAdapter(buttonList) { buttonData ->
            when (buttonData.text) {
                "Nano 1" -> {
                    // Abrir DataNanoLabActivity cuando se hace clic en "Nano 1"
                    val intent = Intent(this, DataNanoLabActivity::class.java)
                    startActivity(intent)
                }
                "Nano 2" -> {
                    // Puedes agregar lógica para otros botones si es necesario
                }
            }
        }

    }
    public fun InitListeners(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = buttonsAdapter
        buttonList
    }
    /*FUNCIONES DEPENDIENTES, SE EJECUTAN en las funciones dependiente---------------------*/



}