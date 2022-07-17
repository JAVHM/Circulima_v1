package pe.edu.ulima.circulima_v1.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import pe.edu.ulima.circulima_v1.R
import pe.edu.ulima.circulima_v1.adapters.ListadoCirculosAdapter
import pe.edu.ulima.circulima_v1.models.GestorCirculos

class PlanetasFragment : Fragment() {
    private lateinit var mRviPlanetas : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Circulos"
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_planetas, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_planetas, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPlanetas = view.findViewById(R.id.rviPlanetas)

        val gestor = GestorCirculos.getInstance()

        GlobalScope.launch(Dispatchers.Main) {
            val lista = withContext(Dispatchers.IO) {
                 gestor.obtenerListaCirculos()
            }
            for (i in lista){
                println("nombre: " + i.NOMBRE)
            }

            val adapter = ListadoCirculosAdapter(lista) {
                Log.i("PlanetasFragment","Se hizo click en el planeta " + it.NOMBRE);
            }
            mRviPlanetas.adapter = adapter
        }

    }
}