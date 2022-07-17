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

class ListaCirculosFragment : Fragment() {
    private lateinit var mRviCirculos : RecyclerView
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
        return inflater.inflate(R.layout.fragment_circulos, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_circulos, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviCirculos = view.findViewById(R.id.rviCirculos)

        val gestor = GestorCirculos.getInstance()

        GlobalScope.launch(Dispatchers.Main) {
            val lista = withContext(Dispatchers.IO) {
                 gestor.obtenerListaCirculos()
            }
            val adapter = ListadoCirculosAdapter(lista) {
                val bundle = Bundle()
                bundle.putString("dataID", it.ID)
                bundle.putString("dataNombre", it.NOMBRE)
                bundle.putString("dataDescripcion", it.DESCRIPCION)
                val fragment = CirculoFragment()
                fragment.arguments = bundle
                fragmentManager?.beginTransaction()?.replace(R.id.fcvSecciones, fragment)?.commit()
                Log.i("PlanetasFragment","Se hizo click en el planeta " + it.NOMBRE)
            }
            mRviCirculos.adapter = adapter
        }
    }
}