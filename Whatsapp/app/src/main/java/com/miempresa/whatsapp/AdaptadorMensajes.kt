package com.miempresa.whatsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdaptadorMensajes(val ListaElementos:ArrayList<Mensajes>): RecyclerView.Adapter<AdaptadorMensajes.ViewHolder>() {

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val fNombre = itemView.findViewById<TextView>(R.id.elemento_mensaje)
        val fHora = itemView.findViewById<TextView>(R.id.elemento_hora)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorMensajes.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.chatcardview, parent, false);
        return AdaptadorMensajes.ViewHolder(v);
    }

    override fun onBindViewHolder(holder: AdaptadorMensajes.ViewHolder, position: Int) {
        holder?.fNombre?.text=ListaElementos[position].mensaje
        holder?.fHora?.text=ListaElementos[position].hora

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
