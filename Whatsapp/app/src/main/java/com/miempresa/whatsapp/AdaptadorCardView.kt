package com.miempresa.whatsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCardView(val ListaElementos:ArrayList<Estado>): RecyclerView.Adapter<AdaptadorCardView.ViewHolder>() {

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val fNombre = itemView.findViewById<TextView>(R.id.elemento_nombre)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
        val fDescripcion = itemView.findViewById<TextView>(R.id.elemento_descripcion)
        val fDescargas = itemView.findViewById<TextView>(R.id.elemento_descargas)
        val fCalificacion = itemView.findViewById<TextView>(R.id.elemento_calificacion)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorCardView.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.estadoscardview, parent, false);
        return AdaptadorCardView.ViewHolder(v);
    }

    override fun onBindViewHolder(holder: AdaptadorCardView.ViewHolder, position: Int) {
        holder?.fNombre?.text=ListaElementos[position].nombre
        holder?.fDescripcion?.text=ListaElementos[position].descripcion
        holder?.fDescargas?.text=ListaElementos[position].descargas
        holder?.fCalificacion?.text=ListaElementos[position].valoracion
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)

        holder.itemView.setOnClickListener(){
            Toast.makeText(holder.itemView.context,
                "Pulsaste cardView"+(position + 1), Toast.LENGTH_LONG).show()
            if(position!=null){
                var llamaractividad = Intent(holder.itemView.context, Chat::class.java)
                holder.itemView.context.startActivity(llamaractividad)
            }
        }

    }

    override fun getItemCount(): Int {
        return ListaElementos.size;
    }
}
