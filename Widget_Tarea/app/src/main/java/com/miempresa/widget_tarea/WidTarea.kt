package com.miempresa.widget_tarea

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */

const val control_widget = "control_widget"

class WidTarea : AppWidgetProvider() {

    fun actualizarWidget(context: Context, appWidgetManager: AppWidgetManager, widgetId: Int){
        val datos_w = context.getSharedPreferences("datos", Context.MODE_PRIVATE)

        val ciudad = datos_w.getString("ciudad", "Mensaje Recibido:")
        val temperatura = datos_w.getString("temperatura", "Mensaje Recibido:")
        val temperatura2 = temperatura?.toIntOrNull()?.plus(5)
        val temperatura3 = temperatura?.toIntOrNull()?.minus(4)
        val tiempo = datos_w.getString("tiempo", "Mensaje Recibido:")
        //String mensaje = Paper.book().read("mensaje");

        val controles = RemoteViews(context.packageName, R.layout.wid_tarea)
        controles.setTextViewText(R.id.txtCiudad, ciudad)
        controles.setTextViewText(R.id.txtTiempo, tiempo)
        controles.setTextViewText(R.id.txtTemp, "$temperatura°")
        controles.setTextViewText(R.id.txtTemp2, temperatura2.toString() + "°")
        controles.setTextViewText(R.id.txtTemp3, temperatura3.toString()+ "°")
        val sdfDate = SimpleDateFormat("HH:mm:ss a")
        val sdfDate2 = SimpleDateFormat("dd/MMMM/yy")
        val now = Date()
        val hora = sdfDate.format(now)
        val fecha = sdfDate2.format(now)

        controles.setTextViewText(R.id.txtHora, hora)
        controles.setTextViewText(R.id.txtFecha, fecha)

        val clicewidget = Intent(context, datos::class.java)
        val widgetesperando = PendingIntent.getActivity(
            context,
            widgetId,
            clicewidget,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        controles.setOnClickPendingIntent(R.id.layoutWidget, widgetesperando)



        val botonwidget = Intent(context, WidTarea::class.java)
        botonwidget.action = control_widget
        botonwidget.putExtra("appWidgetId", widgetId)

        val botonespera = PendingIntent.getBroadcast(
            context,
            0,
            botonwidget,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        controles.setOnClickPendingIntent(R.id.imgActualizar, botonespera)

        appWidgetManager.updateAppWidget(widgetId, controles)
    }


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
            actualizarWidget(context,appWidgetManager,appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (control_widget == intent?.action){
            val widgetId = intent.getIntExtra("appWidgetId", 0)
            actualizarWidget(context!!, AppWidgetManager.getInstance(context), widgetId)
        }
        super.onReceive(context, intent)
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.wid_tarea)




    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}