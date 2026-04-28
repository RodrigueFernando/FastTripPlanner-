package br.edu.ifsp.scl.sc3018237.fasttripplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TelaDadosViagem()
        }
    }
}

@Composable
fun TelaDadosViagem() {

    val contexto = LocalContext.current

    // Estados da tela
    //remember faz o valor não se perder quando a tela atualiza
    var destino by remember { mutableStateOf("") }
    var dias by remember { mutableStateOf("") }
    var orcamento by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Planejar Viagem", style = MaterialTheme.typography.titleLarge)

      //espaço entre componentes
        Spacer(modifier = Modifier.height(16.dp))

        // Campo destino
        TextField(
            value = destino,
            onValueChange = { destino = it },
            label = { Text("Destino") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo dias
        TextField(
            value = dias,
            onValueChange = { dias = it },
            label = { Text("Número de dias") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo orçamento
        TextField(
            value = orcamento,
            onValueChange = { orcamento = it },
            label = { Text("Orçamento diário") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão avançar
        Button(
            onClick = {

                // Validação
                if (destino.isBlank() || dias.isBlank() || orcamento.isBlank()) {
                    Toast.makeText(contexto, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                val diasInt = dias.toIntOrNull()
                val orcamentoDouble = orcamento.toDoubleOrNull()

                if (diasInt == null || orcamentoDouble == null) {
                    Toast.makeText(contexto, "Valores inválidos", Toast.LENGTH_SHORT).show()
                    return@Button
                }

            // Cria uma Intent para abrir a SegundaTela e envia os dados da viagem (destino, dias e orçamento) como parâmetros
                val intent = Intent(contexto, OpcoesViagem::class.java)
                intent.putExtra("destino", destino)
                intent.putExtra("dias", diasInt)
                intent.putExtra("orcamento", orcamentoDouble)

                contexto.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Avançar")
        }
    }
}