package com.lacourt.myapplication.util

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.lacourt.myapplication.R

object DialogHelper {
    fun getInstance(
        context: Context, titulo: String, mensagem: CharSequence,
        labelB1: String, acaoButton1: View.OnClickListener?,
        labelB2: String?, acaoButton2: View.OnClickListener?,
        labelB3: String?, acaoButton3: View.OnClickListener?
    ): AlertDialog {
        val aviso: AlertDialog.Builder = AlertDialog.Builder(context)

        val view = View.inflate(context, R.layout.dialogo_avalia_play_store, null)
        val tituloField = view.findViewById<TextView>(R.id.title_rating_play_store)
        tituloField.text = titulo

        val mensagemField = view.findViewById<TextView>(R.id.message_rating_play_store)
        mensagemField.text = mensagem

        val b1 = view.findViewById<TextView>(R.id.btn_nunca)
        b1.text = labelB1
        b1.visibility = View.VISIBLE
        aviso.setView(view)

        var b2: TextView? = null
        if (labelB2 != null) {
            b2 = view.findViewById(R.id.btn_mais_tarde)
            b2!!.text = labelB2
            b2.visibility = View.VISIBLE
        }

        var b3: TextView? = null
        if (labelB3 != null) {
            b3 = view.findViewById(R.id.btn_avaliar)
            b3!!.text = labelB3
            b3.visibility = View.VISIBLE
        }

        val dialog = aviso.create()

        b1.setOnClickListener { v ->
            dialog.dismiss()
            acaoButton1?.onClick(v)
        }

        b2?.setOnClickListener { v ->
            dialog.dismiss()
            acaoButton2?.onClick(v)
        }

        b3?.setOnClickListener { v ->
            dialog.dismiss()
            acaoButton3?.onClick(v)
        }

        val estrelas = view.findViewById<View>(R.id.btn_go_to_play_store_estrelas) as LinearLayout
        estrelas.setOnClickListener { v ->
            dialog.dismiss()
            acaoButton3?.onClick(v)
        }

        return dialog
    }
}