package com.example.dots.PantPrincipal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantUsuario.AjustesActivity
import com.example.dots.PantUsuario.ayudaPrincipalActivity
import com.example.dots.R

class usuarioActivity : AppCompatActivity() {

    lateinit var btnAyuda: LinearLayout
    lateinit var btnDots: LinearLayout
    lateinit var btnAjustes: LinearLayout
    lateinit var imbtnOpcionUsuario: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usuario)
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
        imbtnOpcionUsuario = findViewById(R.id.linearConfigCuenta)
    }
    fun InitListenersComponents(){
        btnAyuda.setOnClickListener{
            intent = Intent(this, ayudaPrincipalActivity::class.java)
            startActivity(intent)
        }
        btnDots.setOnClickListener{
            intent = Intent(this, PantallaInicio::class.java)
            startActivity(intent)
        }
        btnAjustes.setOnClickListener{
            intent = Intent(this, AjustesActivity::class.java)
            startActivity(intent)
        }
        imbtnOpcionUsuario.setOnClickListener{
            val intent = Intent(this , ConfigurationUsuarioActivity::class.java)
            startActivity(intent)
        }

    }
}