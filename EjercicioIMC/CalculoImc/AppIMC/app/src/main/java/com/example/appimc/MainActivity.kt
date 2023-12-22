package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.introducirPeso)
        val altura: EditText = findViewById(R.id.introducirAltura)
        val calculo: Button = findViewById(R.id.calcular)
        val resultadoCalculo: TextView = findViewById(R.id.resultado)

        var valorPeso: Int = 0
        var valorAltura: Float = 0F
        var imc: Float = 0F

        calculo.setOnClickListener {
            val textoPeso = peso.text.toString()
            if (textoPeso.isNotEmpty()) {
                valorPeso = textoPeso.toInt()
            } else {
                println("Falta algún valor por rellenar")
            }

            val textoAltura = altura.text.toString()
            if (textoAltura.isNotEmpty()) {
                valorAltura = textoAltura.toFloat()
            } else {
                println("Falta algún valor por rellenar")
            }

            if (valorPeso != 0 && valorAltura != 0F) {
                imc = valorPeso / (valorAltura * valorAltura)
                resultadoCalculo.text = imc.toString()
                mostrarMensaje(imc)
            }
        }
    }

    private fun mostrarMensaje(imc: Float) {
        val mensajeSalida: TextView = findViewById(R.id.mensaje)
        val mensaje: String = when {
            imc < 18.5 -> "Usted sufre delgadez, debería comer más."
            imc in 18.5..24.9 -> "Su estado de forma es bueno."
            imc in 25.0..29.9 -> "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista."
            else -> "Usted sufre obesidad, debería llamar a un médico urgentemente."
        }
        mensajeSalida.text = mensaje


    }
}