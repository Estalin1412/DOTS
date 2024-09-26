package com.example.dots.PantNanoLab

import ButtonAdapter
import ButtonData
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dots.R

class NanoLabMainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonsAdapter: ButtonAdapter

    val buttonList = mutableListOf<ButtonData>(
        ButtonData(R.drawable.batch_path1_ajustes, "Nano 1"),
        ButtonData(R.drawable.batch_path1_ajustes, "Nano 2")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nano_lab_main)

        recyclerView = findViewById(R.id.recyclerViewButtons)
        recyclerView.layoutManager = LinearLayoutManager(this)


        buttonsAdapter = ButtonAdapter(buttonList)
        recyclerView.adapter = buttonsAdapter

        InitComponents()
        InitListeners()
    }

    public fun InitComponents(){


    }
    public fun InitListeners(){
        buttonList
    }
}