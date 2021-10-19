package com.miempresa.whatsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorElementos(val ListaElementos:ArrayList<Elementos>): RecyclerView.Adapter<AdaptadorElementos.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.nombre)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
        val fMensaje = itemView.findViewById<TextView>(R.id.mensaje)
        val fNotify = itemView.findViewById<ImageView>(R.id.not)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorElementos.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoslista, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdaptadorElementos.ViewHolder, position: Int) {
        holder?.fTexto?.text=ListaElementos[position].nombre
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)
        holder?.fMensaje?.text=ListaElementos[position].mensaje
        holder?.fNotify?.setImageBitmap(ListaElementos[position].notify)

        holder.itemView.setOnCreateContextMenuListener{ contextMenu, _, _ ->
            contextMenu.setHeaderTitle("Se eligio opcion" + (position+1))
            true
        }

        holder.itemView.setOnClickListener(){
            if(position!=null){
                var llamaractividad = Intent(holder.itemView.context, Chat::class.java)
                holder.itemView.context.startActivity(llamaractividad)
            }
        }

    }

    override fun getItemCount(): Int {
        return  ListaElementos.size
    }
}