package com.example.dots.PantPrincipal

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dots.PantNanoLab.NanoLabMainActivity
import com.example.dots.R

class PantallaInicio : AppCompatActivity() {
    /*-------------------------Definicion de objetos visuales---------------------*/
    //Definicion de variable para botones en de activity_pantalla_inicio.xml
    lateinit var imbtnOpcionUsuario: ImageButton
    lateinit var imbtnOpcionesDispositivo: ImageButton
    lateinit var btnCuenta: LinearLayout





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)


        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )

        InitComponentes();
        InitListenersComponents();



    }
    /*---------Funciones Independientes(Se llama se deben llamar si o si)------------------*/
    //Funcion para asociar varibles con dispositivos
    public fun InitComponentes(){
        imbtnOpcionUsuario = findViewById(R.id.imbtnOpcionesDeUsuario)
        imbtnOpcionesDispositivo = findViewById(R.id.imbtnOpcionesDispositivos)
        btnCuenta = findViewById(R.id.linearCuenta)
    }
    //Funcion
    public fun InitListenersComponents(){
        //Para mostrar opciones flotantes
        imbtnOpcionesDispositivo.setOnClickListener{view -> showPopupMenu(view)}
        imbtnOpcionUsuario.setOnClickListener{
            val intent = Intent(this , ConfigurationCuentaActivity::class.java)
            startActivity(intent)
        }

        btnCuenta.setOnClickListener{
            val intent = Intent(this, usuarioActivity::class.java)
            startActivity(intent)
        }

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