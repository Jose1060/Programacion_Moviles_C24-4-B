package com.miempresa.whatsapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.fragment_chat.view.*

class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        setSupportActionBar(findViewById(R.id.chatbar))
        supportActionBar?.setHomeAsUpIndicator(R.drawable.icon_return)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mensajes.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mensajes.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Mensajes>()
        for (i in 1 until 10) {
            llenarLista.add(Mensajes("Mensaje "+i,"20:3${i}"))
        }

        val adapter = AdaptadorMensajes(llenarLista)
        mensajes.adapter = adapter



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal, menu)
        return true
    }
}