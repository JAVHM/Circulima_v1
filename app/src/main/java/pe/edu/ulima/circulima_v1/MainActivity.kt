package pe.edu.ulima.circulima_v1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import pe.edu.ulima.circulima_v1.fragments.ListaCirculosFragment
import pe.edu.ulima.circulima_v1.fragments.ListaPublicacionesFragment

class MainActivity : AppCompatActivity() {

    private val fragmentCirculos = ListaCirculosFragment()
    private val fragmentPublicaciones = ListaPublicacionesFragment()

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        auth = FirebaseAuth.getInstance()

        val email = intent.getStringExtra("email")
        val givenName = intent.getStringExtra("givenName")
        val familyName = intent.getStringExtra("familyName")
        val displayName = intent.getStringExtra("displayName")

        println("INFO RECUPERADA")
        println(email)
        println(givenName)
        println(familyName)
        println(displayName)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentCirculos)
        ft.commit()

    }
}