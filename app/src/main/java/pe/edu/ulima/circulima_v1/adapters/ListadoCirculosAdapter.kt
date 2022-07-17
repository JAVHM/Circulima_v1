package pe.edu.ulima.circulima_v1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.circulima_v1.R
import pe.edu.ulima.circulima_v1.models.beans.Circulo

class ListadoCirculosAdapter(private val mListaPlanetas : List<Circulo>,
                             private val mOnItemClickListener : (circulo : Circulo) -> Unit)
    : RecyclerView.Adapter<ListadoCirculosAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPlanetaNombre : TextView
        val tviPlanetaTerreno : TextView
        val tviPlanetaPoblacion : TextView

        init {
            tviPlanetaNombre = view.findViewById(R.id.tviPlanetaNombre)
            tviPlanetaTerreno = view.findViewById(R.id.tviPlanetaTerreno)
            tviPlanetaPoblacion = view.findViewById(R.id.tviPlanetaPoblacion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planeta, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val circulo = mListaPlanetas[position]
        holder.tviPlanetaNombre.text = circulo.NOMBRE
        holder.tviPlanetaTerreno.text = circulo.DESCRIPCION
        holder.tviPlanetaPoblacion.text = circulo.CARRERA

        holder.itemView.setOnClickListener {
            mOnItemClickListener(circulo)
        }
    }

    override fun getItemCount(): Int {
        // Devolver el nro de items a mostrar
        return mListaPlanetas.size
    }
}