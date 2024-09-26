package com.example.a05

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a05.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os elementos da interface
        val heightInput = findViewById<EditText>(R.id.heightInput)
        val weightInput = findViewById<EditText>(R.id.weightInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            // Obter valores inseridos pelo usuário
            val heightText = heightInput.text.toString()
            val weightText = weightInput.text.toString()

            if (heightText.isNotEmpty() && weightText.isNotEmpty()) {
                // Converter textos para números
                val height = heightText.toDoubleOrNull()
                val weight = weightText.toDoubleOrNull()

                if (height != null && weight != null && height > 0) {
                    // Calcular IMC
                    val imc = weight / (height * height)
                    // Determinar a categoria
                    val category = when {
                        imc < 18.5 -> "Abaixo do peso"
                        imc in 18.5..24.9 -> "Peso normal"
                        imc in 25.0..29.9 -> "Sobrepeso"
                        else -> "Obesidade"
                    }
                    // Exibir resultado
                    resultText.text = "IMC: %.2f\nCategoria: $category".format(imc)
                } else {
                    resultText.text = "Por favor, insira valores válidos."
                }
            } else {
                resultText.text = "Por favor, preencha todos os campos."
            }
        }
    }
}
