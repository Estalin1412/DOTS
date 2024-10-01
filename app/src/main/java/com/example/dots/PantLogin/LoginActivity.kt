package com.example.dots.PantLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantPrincipal.PantallaInicio
import com.example.dots.R

class LoginActivity : AppCompatActivity() {
    /*OBJETOS VISUALES(botones, textos clickleables, caja de box)--------------------------------------*/
    lateinit var btnAccederSession: Button
    lateinit var tvCreatAcount: TextView
    lateinit var tvForgotPassword: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Init();
        InitListeners();

    }

    /*FUNCI0NES INDEPENDIENTES(funciones que se deben ejecutar si o si)------------------------*/
    //Funcion para sincronizar variables con su respectivo objeto visual
    public  fun Init(){
        btnAccederSession = findViewById(R.id.buttonLogin)
        tvCreatAcount = findViewById(R.id.createAccount)
        tvForgotPassword = findViewById(R.id.forgotPassword)
    }

    public fun InitListeners(){
        //Configurar boton para iniciar sesion
        btnAccederSession.setOnClickListener{
            val intent = Intent(this , PantallaInicio::class.java)
            startActivity(intent)
        }
        //Boton para redirigirte a la pantalla de Crear Cuenta(PantallaRegistrarActivity)
        tvCreatAcount.setOnClickListener{
            val intent = Intent(this, PantallaRegistrarActivity::class.java)
            startActivity(intent)
        }
        //Boton para recuperar contraseña
        tvForgotPassword.setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

}