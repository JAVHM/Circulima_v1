package pe.edu.ulima.circulima_v1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.edu.ulima.circulima_v1.fragments.ListaCirculosFragment
import pe.edu.ulima.circulima_v1.fragments.ListaPublicacionesFragment

class MainActivity : AppCompatActivity() {

    private val fragmentCirculos = ListaCirculosFragment()
    private val fragmentPublicaciones = ListaPublicacionesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentPublicaciones)
        ft.commit()
    }
}