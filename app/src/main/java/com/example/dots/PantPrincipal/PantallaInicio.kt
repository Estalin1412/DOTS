package com.example.dots.PantPrincipal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
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
    /*-------------------------Definicion de objetos visuales---------------------*/
    //Definicion de variable para botones en de activity_pantalla_inicio.xml
    lateinit var imbtnOpcionUsuario: ImageButton
    lateinit var imbtnOpcionesDispositivo: ImageButton





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)


        InitComponentes();
        InitListenersComponents();



    }
    /*---------Funciones Independientes(Se llama se deben llamar si o si)------------------*/
    //Funcion para asociar varibles con dispositivos
    public fun InitComponentes(){
        imbtnOpcionUsuario = findViewById(R.id.imbtnOpcionesDeUsuario)
        imbtnOpcionesDispositivo = findViewById(R.id.imbtnOpcionesDispositivos)
    }
    //Funcion
    public fun InitListenersComponents(){
        //Para mostrar opciones flotantes
        imbtnOpcionesDispositivo.setOnClickListener{view -> showPopupMenu(view)}

    }

    /*------FUNCIONES DEPENDIENTES SE LLAMAN EN LAS FUNCIONES INDEPENDIENTES--------*/
    private fun showPopupMenu(view: View) {
        // Crea el PopupMenu
        // Mostrar el PopupMenu
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)


        // Manejar los eventos de clic en las opciones del menú
        popupMenu.setOnMenuItemClickListener {
            item: MenuItem ->
            when (item.itemId) {
                //Elegir nano lab
                R.id.menu_Nanolab ->{
                    //Para ingresar a la pantalla de NanoLabMainActivity-----------
                    val intent = Intent(this , NanoLabMainActivity::class.java)
                    startActivity(intent)
                    //----------------------------------------------------------
                    true
                }
                //ELEGIR estacion
                R.id.menu_Estacion -> {
                    true
                }
                //ELEGIR HIPERLINK
                R.id.menu_Hyperlink -> {
                    true
                }
                else -> false
            }
        }
        popupMenu.show()

    }
}