package com.example.dots.PantUsuario

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantUsuario.ConfiguracionCuenta.ConfiguracionCuentaInsertarFotoActivity
import com.example.dots.R

class ConfiguracionUsuarioActivity : AppCompatActivity() {

    lateinit var btnCambiarFotoDePerfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracion_usuario)
        InitComponents()
        ListenerComponenst()
    }

    fun InitComponents(){
        btnCambiarFotoDePerfil = findViewById(R.id.ImagenViewprofilePhoto)
    }

    fun ListenerComponenst(){
        btnCambiarFotoDePerfil.setOnClickListener{
            val intent = Intent(this, ConfiguracionCuentaInsertarFotoActivity::class.java)
            startActivity(intent)
        }
    }
}