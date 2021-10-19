package com.miempresa.whatsapp.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.miempresa.whatsapp.AdaptadorElementos
import com.miempresa.whatsapp.Elementos
import com.miempresa.whatsapp.R
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_chat.view.*

class ChatFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_chat, container, false)


        root.lista.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        root.lista.layoutManager = LinearLayoutManager(context)

        var llenarLista = ArrayList<Elementos>()
        for (i in 1 until 20){
            llenarLista.add(
                Elementos("Elemento" + i, BitmapFactory.decodeResource(resources, R.drawable.imgfoto), "Mensaje" + i, BitmapFactory.decodeResource(resources, R.drawable.check))
            )
        }

        val adapter = AdaptadorElementos(llenarLista)
        root.lista.adapter = adapter

        registerForContextMenu(root.lista)

        return root
    }


}