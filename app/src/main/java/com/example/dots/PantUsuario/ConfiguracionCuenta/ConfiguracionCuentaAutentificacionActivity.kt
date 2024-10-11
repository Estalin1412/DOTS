package com.example.dots.PantUsuario.ConfiguracionCuenta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.R
import org.checkerframework.common.subtyping.qual.Bottom

class ConfiguracionCuentaAutentificacionActivity : AppCompatActivity() {

    lateinit var btnCambiarPasword: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracion_cuenta_autentificacion)

        InitComponents()
        ListenerComponents()
    }
    fun InitComponents(){
        btnCambiarPasword = findViewById(R.id.buttonCambiarPassword)
    }
    fun ListenerComponents(){
        btnCambiarPasword.setOnClickListener{
            val intent = Intent(this, ConfiguracionCuentaCambiarPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}