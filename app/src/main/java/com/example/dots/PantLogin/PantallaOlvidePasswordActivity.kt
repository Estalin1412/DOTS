package com.example.dots.PantLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.dots.PantPrincipal.PantallaInicioActivity
import com.example.dots.R

class PantallaOlvidePasswordActivity : AppCompatActivity() {

    lateinit var btnRecuperarCuenta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_olvide_password)
    }


    fun InitComponents(){
        btnRecuperarCuenta = findViewById(R.id.buttonCambiarPassword)
    }

    fun ListenersComponents(){
        btnRecuperarCuenta.setOnClickListener{
            intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
        }
    }
}