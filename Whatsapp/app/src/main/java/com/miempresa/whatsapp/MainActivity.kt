package com.miempresa.whatsapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.miempresa.whatsapp.fragments.CameraFragment
import com.miempresa.whatsapp.fragments.ChatFragment
import com.miempresa.whatsapp.fragments.EstadoFragment
import com.miempresa.whatsapp.fragments.LlamadasFragment
import com.miempresa.whatsapp.fragments.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(findViewById(R.id.mitoolbar))



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
        if (id == R.id.home){
            Toast.makeText(this, "Marcado Home", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_chats -> Toast.makeText(this, "Elegiste menu chats", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CameraFragment(), "")
        adapter.addFragment(ChatFragment(), "Chats")
        adapter.addFragment(EstadoFragment(), "Estados")
        adapter.addFragment(LlamadasFragment(), "Llamadas")
        viewPager.adapter = adapter
        tab_layout.setupWithViewPager(viewPager)

        tab_layout.getTabAt(0)!!.setIcon(R.drawable.icono_camera)
    }
}