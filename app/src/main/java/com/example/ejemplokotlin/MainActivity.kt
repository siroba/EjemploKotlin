package com.example.ejemplokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    //VAriables globales
    var puntos =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generarNumeros()
    }

    fun generarNumeros(){
        var botonIzq = findViewById<Button>(R.id.botonIzq)
        var botonDer = findViewById<Button>(R.id.botonDer)
        var random = Random();
        var num1 = random.nextInt(10)
        var num2 = random.nextInt(10)
        botonIzq.text="$num1"
        botonDer.text="$num2"

        if(num1==num2){
            generarNumeros()
        }

    }

    fun calcPuntos(esIzq:Boolean){
        var botonIzq = findViewById<Button>(R.id.botonIzq)
        var botonDer = findViewById<Button>(R.id.botonDer)

        val numIzq = botonIzq.text.toString().toInt()
        val numDer = botonDer.text.toString().toInt()

        if(esIzq &&numIzq > numDer || !esIzq &&numIzq< numDer){
            //+1 punto
            puntos++
        }else{
            //-1 punto
            puntos--
        }
        findViewById<TextView>(R.id.puntosText).text = "Puntos: $puntos"
        generarNumeros()
    }
    fun botonDer(view: View){
        calcPuntos(false)

    }
    fun botonIzq(view: View){
        calcPuntos(true)

    }
}