package com.miempresa.whatsapp.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.miempresa.whatsapp.AdaptadorCardView
import com.miempresa.whatsapp.Estado
import com.miempresa.whatsapp.R
import kotlinx.android.synthetic.main.fragment_chat.view.*
import kotlinx.android.synthetic.main.fragment_chat.view.lista
import kotlinx.android.synthetic.main.fragment_estado.view.*

class EstadoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_estado, container, false)

        root.estados.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        root.estados.layoutManager = LinearLayoutManager(context);

        var llenarLista = ArrayList<Estado>()
        for (i in 1 until 6) {
            llenarLista.add(Estado("Elemento "+i,
                BitmapFactory.decodeResource(resources, R.drawable.img_prueba3),"Esta es la mejor aplicacion :v" + i, "100${i}", "${i}/5"))
        }

        val adapter = AdaptadorCardView(llenarLista)
        root.estados.adapter = adapter

        return root
    }

   
}