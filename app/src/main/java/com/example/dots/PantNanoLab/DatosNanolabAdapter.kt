package com.example.dots.PantNanoLab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dots.R

class DatosNanolabAdapter(private val listaDatos: List<Dato>, private val onClick: (Dato) -> Unit) :
    RecyclerView.Adapter<DatosNanolabAdapter.DatoViewHolder>() {
    private var selectedItemPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dato_nanolab, parent, false)
        return DatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DatoViewHolder, position: Int) {
        val dato = listaDatos[position]
        holder.bind(dato, onClick)

        // Cambia el estado visual dependiendo de si está seleccionado
        holder.itemView.isSelected = (selectedItemPosition == position)

        // Manejar el click en un ítem
        holder.itemView.setOnClickListener {
            // Actualizar la posición seleccionada y refrescar los ítems
            val previousItemPosition = selectedItemPosition
            selectedItemPosition = position
            notifyItemChanged(previousItemPosition)  // Refresca el ítem previamente seleccionado
            notifyItemChanged(position)  // Refresca el nuevo ítem seleccionado

            // Llamar a la función onClick
            onClick(dato)
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    class DatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textNombre: TextView = itemView.findViewById(R.id.textNombreDato)
        private val textCantidad: TextView = itemView.findViewById(R.id.textCantidadDato)
        private val textUnidad: TextView = itemView.findViewById(R.id.textUnidadDato)

        fun bind(dato: Dato, onClick: (Dato) -> Unit) {
            textNombre.text = dato.nombre
            textCantidad.text = dato.cantidad
            textUnidad.text = dato.unidad
        }
    }
}
