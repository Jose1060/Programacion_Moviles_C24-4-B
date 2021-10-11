package com.miempresa.whatsapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this)

        var llenarLista = ArrayList<Elementos>()
        for (i in 1 until 20){
            llenarLista.add(
                Elementos("Elemento" + i, BitmapFactory.decodeResource(resources, R.drawable.imgfoto), "Mensaje" + i, BitmapFactory.decodeResource(resources, R.drawable.check)))
        }

        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter

        registerForContextMenu(lista)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.config){
            Toast.makeText(this, "Aqui podrias configurar :v", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.about){
            Toast.makeText(this, "Soy Jose Antonio", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.message){
            Toast.makeText(this, "Hola, este es un mensaje", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.search){
            Toast.makeText(this, "Puedes decirme que estas buscando", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}