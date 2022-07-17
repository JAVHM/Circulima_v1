package pe.edu.ulima.circulima_v1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import pe.edu.ulima.circulima_v1.fragments.PlanetasFragment
import pe.edu.ulima.circulima_v1.models.GestorCirculos

class MainActivity : AppCompatActivity(){

    private val fragmentPlanetas = PlanetasFragment()

     override fun onCreate(savedInstanceState: Bundle?) {
         // Configuramos el viewpager con el adapter creado
         super.onCreate(savedInstanceState)
         setContentView(R.layout.main_activity)


         val ft = supportFragmentManager.beginTransaction()
         ft.add(R.id.fcvSecciones, fragmentPlanetas)
         ft.commit()
    }
}