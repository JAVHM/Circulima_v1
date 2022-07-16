package pe.edu.ulima.circulima_v1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import pe.edu.ulima.circulima_v1.beans.GestorCirculos


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        val button = findViewById<View>(R.id.button) as Button

        GestorCirculos.getInstance().printDB()
        GestorCirculos.getInstance().prueba()
        println("IDENTIFICADOR2")

        button.setOnClickListener {
            openActivity2()
        }
    }

    fun openActivity2() {
        val editText2 = findViewById<View>(R.id.edittext2) as EditText
        val number = editText2.text.toString().toInt()
        Intent(this, MainActivity::class.java).also {
            it.putExtra("EXTRA_CODE", number)
            startActivity(it)
        }
    }
}