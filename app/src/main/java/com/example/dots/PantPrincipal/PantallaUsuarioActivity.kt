package com.example.dots.PantPrincipal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dots.PantUsuario.AjustesActivity
import com.example.dots.PantUsuario.AyudaActivity
import com.example.dots.PantUsuario.ConfiguracionUsuarioActivity
import com.example.dots.PantUsuario.ConfiguracionCuentaActivity
import com.example.dots.R

class PantallaUsuarioActivity : AppCompatActivity() {


    lateinit var btnDots: LinearLayout


    lateinit var btnConfiguracionCuenta: LinearLayout

    lateinit var btnConfiguracionUsuario: LinearLayout

    lateinit var btnAjustes: LinearLayout

    lateinit var btnAyuda: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_usuario)
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
        InitComponents()
        InitListenersComponents()


    }

    /*FUNCIONES INDEPENDIENTES ESTAS SE LLAMAN SI O SI*/
    fun InitComponents(){
        btnAyuda = findViewById(R.id.linearButtomAyudaRecomendaciones)
        btnDots = findViewById(R.id.linearIdInicio)
        btnAjustes = findViewById(R.id.linearAjustes)
        btnConfiguracionUsuario = findViewById(R.id.linearConfigUsuario)
        btnConfiguracionCuenta = findViewById(R.id.linearConfiguracionCuenta)
    }
    fun InitListenersComponents(){

        btnDots.setOnClickListener{
            intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
        }
        btnConfiguracionUsuario.setOnClickListener{
            intent = Intent(this, ConfiguracionUsuarioActivity::class.java)
            startActivity(intent)
        }

        btnConfiguracionCuenta.setOnClickListener{
            val intent = Intent(this , ConfiguracionCuentaActivity::class.java)
            startActivity(intent)
        }

        btnAjustes.setOnClickListener{
            intent = Intent(this, AjustesActivity::class.java)
            startActivity(intent)
        }
        btnAyuda.setOnClickListener{
            intent = Intent(this, AyudaActivity::class.java)
            startActivity(intent)
        }

    }
}