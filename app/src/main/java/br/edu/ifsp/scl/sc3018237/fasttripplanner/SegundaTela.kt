package br.edu.ifsp.scl.sc3018237.fasttripplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SegundaTela : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dados vindos da Tela 1
        val destino = intent.getStringExtra("destino")
        val dias = intent.getIntExtra("dias", 0)
        val orcamento = intent.getDoubleExtra("orcamento", 0.0)

        setContent {
            TelaSegunda(destino, dias, orcamento)
        }
    }
}

@Composable
fun TelaSegunda(destino: String?, dias: Int, orcamento: Double) {

    // Estado (agora no lugar certo)
    var hospedagem by remember { mutableStateOf("Econômica") }

}