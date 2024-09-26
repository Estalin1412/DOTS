package com.example.dots.PantPrincipal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantNanoLab.NanoLabMainActivity
import com.example.dots.R

class PantallaInicio : AppCompatActivity() {

    lateinit var imagenButtonProgramas: ImageButton
    lateinit var imbtnAgregarPrograma: ImageButton





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        InitComponentes();
        InitListenersComponents();



    }
    public fun InitComponentes(){
        imagenButtonProgramas = findViewById(R.id.menuButton)
        imbtnAgregarPrograma = findViewById(R.id.btnAgregarNanoLab)
    }
    public fun InitListenersComponents(){
        imbtnAgregarPrograma.setOnClickListener{view -> showPopupMenu(view)}

    }


    private fun showPopupMenu(view: View) {
        // Crea el PopupMenu
        // Mostrar el PopupMenu
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)


        // Manejar los eventos de clic en las opciones del menú
        popupMenu.setOnMenuItemClickListener {
            item: MenuItem ->
            when (item.itemId) {
                R.id.menu_Nanolab ->{
                    val intent = Intent(this , NanoLabMainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_Estacion -> {
                    Toast.makeText(this, "Escanear", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_Estacion -> {
                    Toast.makeText(this, "Crear escena inteligente", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()

    }
}