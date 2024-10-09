package com.example.dots.PantUsuario

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantUsuario.Ajustes.AjustesAcercaDotsAppActivity
import com.example.dots.PantUsuario.Ajustes.AjustesActualizacionesActivity
import com.example.dots.PantUsuario.Ajustes.AjustesCompartirDispositivoActivity
import com.example.dots.PantUsuario.Ajustes.AjustesIdiomaActivity
import com.example.dots.PantUsuario.Ajustes.AjustesNotificacionesActivity
import com.example.dots.PantUsuario.Ajustes.AjustesPaisActivity
import com.example.dots.PantUsuario.Ajustes.AjustesPermisosSistemaActivity
import com.example.dots.PantUsuario.Ajustes.AjustesPrivacidadInfoLegalActivity
import com.example.dots.PantUsuario.Ajustes.AjustesSeguridadActivity
import com.example.dots.R

class AjustesActivity : AppCompatActivity() {

    lateinit var btnAjustesNotificaciones: TextView


    lateinit var btnAjustesSeguridad: TextView
    lateinit var btnAjustesDispositivosCompartidos: TextView


    lateinit var btnAjustesPais: LinearLayout
    lateinit var btnAjustesIdioma: LinearLayout

    lateinit var btnAjustesPermisosSistema: LinearLayout
    lateinit var btnAjustesPrivacidadInformacionLegal: LinearLayout

    lateinit var btnAjustesAcercaDotsApp: LinearLayout
    lateinit var btnAjustesActualizaciones: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajustes)
        InitComponents()
        InitListeners()
    }

    fun InitComponents(){
        btnAjustesNotificaciones = findViewById(R.id.tvNotificationSettingsText)

        btnAjustesSeguridad = findViewById(R.id.textViewAjustesSguridad)
        btnAjustesDispositivosCompartidos = findViewById(R.id.textViewDispositivosCompartidos)
        btnAjustesPais = findViewById(R.id.linearPais)
        btnAjustesIdioma = findViewById(R.id.linearIdioma)

        btnAjustesPermisosSistema = findViewById(R.id.linearPermisosSistema)
        btnAjustesPrivacidadInformacionLegal = findViewById(R.id.linearPrivacidaInformacionLegal)

        btnAjustesAcercaDotsApp = findViewById(R.id.linearAcercaDOTSapp)
        btnAjustesActualizaciones = findViewById(R.id.linearActualizaciones)
    }
    fun InitListeners(){
        btnAjustesNotificaciones.setOnClickListener{
            val intent = Intent(this, AjustesNotificacionesActivity::class.java)
            startActivity(intent)
        }

        btnAjustesSeguridad.setOnClickListener{
            val intent = Intent(this, AjustesSeguridadActivity::class.java)
            startActivity(intent)
        }
        btnAjustesDispositivosCompartidos.setOnClickListener{
            val intent = Intent(this, AjustesCompartirDispositivoActivity::class.java)
            startActivity(intent)
        }
        btnAjustesPais.setOnClickListener{
            val intent = Intent(this, AjustesPaisActivity::class.java)
            startActivity(intent)
        }
        btnAjustesIdioma.setOnClickListener{
            val intent = Intent(this, AjustesIdiomaActivity::class.java)
            startActivity(intent)
        }
        btnAjustesPermisosSistema.setOnClickListener{
            val intent = Intent(this, AjustesPermisosSistemaActivity::class.java)
            startActivity(intent)
        }
        btnAjustesPrivacidadInformacionLegal.setOnClickListener{
            val intent = Intent(this, AjustesPrivacidadInfoLegalActivity::class.java)
            startActivity(intent)
        }
        btnAjustesAcercaDotsApp.setOnClickListener{
            val intent = Intent(this, AjustesAcercaDotsAppActivity::class.java)
            startActivity(intent)
        }
        btnAjustesActualizaciones.setOnClickListener{
            val intent = Intent(this, AjustesActualizacionesActivity::class.java)
            startActivity(intent)
        }

    }
}