package com.example.dots.PantLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dots.PantPrincipal.PantallaInicio
import com.example.dots.R

class LoginActivity : AppCompatActivity() {

    val btnAccederSession: Button = findViewById<Button>(R.id.buttonLogin)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()





        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }

    public fun InitListeners(){
        btnAccederSession.setOnClickListener{
            val intent = Intent(this , PantallaInicio::class.java)
            startActivity(intent)
        }
    }

}