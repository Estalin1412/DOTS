package com.example.dots.PantUsuario

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantUsuario.Ajustes.AjustesCompartirDispositivoActivity
import com.example.dots.PantUsuario.ConfiguracionCuenta.ConfiguracionCuentaAutentificacionActivity
import com.example.dots.PantUsuario.ConfiguracionCuenta.ConfiguracionCuentaInsertarFotoActivity
import com.example.dots.R

class ConfiguracionCuentaActivity : AppCompatActivity() {

    lateinit var btnInsertarFotoPerfel: LinearLayout
    lateinit var btnCambiarPassword: CardView
    lateinit var btnAjustesDispositivosCompartidos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracion_cuenta)
        InitComponents()
        ListenerComponents()

    }


    fun InitComponents(){
        btnInsertarFotoPerfel = findViewById(R.id.linearInsertarFotoPerfil)
        btnCambiarPassword = findViewById(R.id.cardViewCambiarPassword)
        btnAjustesDispositivosCompartidos = findViewById(R.id.linearDispositivosCompartidos)

    }
    fun ListenerComponents(){
        btnInsertarFotoPerfel.setOnClickListener{
            val intent = Intent(this, ConfiguracionCuentaInsertarFotoActivity::class.java)
            startActivity(intent)
        }
        btnCambiarPassword.setOnClickListener{
            val intent = Intent(this, ConfiguracionCuentaAutentificacionActivity::class.java)
            startActivity(intent)
        }
        btnAjustesDispositivosCompartidos.setOnClickListener{
            val intent = Intent(this, AjustesCompartirDispositivoActivity::class.java)
            startActivity(intent)
        }


    }
}