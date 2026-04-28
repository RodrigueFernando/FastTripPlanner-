package br.edu.ifsp.scl.sc3018237.fasttripplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

class OpcoesViagem : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

    val contexto = LocalContext.current

    // Estado
    var hospedagem by remember { mutableStateOf("Econômica") }

    var transporte by remember { mutableStateOf(false) }
    var alimentacao by remember { mutableStateOf(false) }
    var passeios by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Opções da Viagem", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Destino: ${destino ?: "Não informado"}")
        Text("Dias: $dias")
        Text("Orçamento diário: $orcamento")

        Spacer(modifier = Modifier.height(16.dp))

        //  HOSPEDAGEM
        Text("Hospedagem:")

        Row {
            RadioButton(
                selected = hospedagem == "Econômica",
                onClick = { hospedagem = "Econômica" }
            )
            Text("Econômica")
        }

        Row {
            RadioButton(
                selected = hospedagem == "Conforto",
                onClick = { hospedagem = "Conforto" }
            )
            Text("Conforto")
        }

        Row {
            RadioButton(
                selected = hospedagem == "Luxo",
                onClick = { hospedagem = "Luxo" }
            )
            Text("Luxo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        //  SERVIÇOS
        Text("Serviços:")

        Row {
            Checkbox(
                checked = transporte,
                onCheckedChange = { transporte = it }
            )
            Text("Transporte")
        }

        Row {
            Checkbox(
                checked = alimentacao,
                onCheckedChange = { alimentacao = it }
            )
            Text("Alimentação")
        }

        Row {
            Checkbox(
                checked = passeios,
                onCheckedChange = { passeios = it }
            )
            Text("Passeios")
        }

        Spacer(modifier = Modifier.height(16.dp))


        // Calcular
        Button(
            onClick = {
                val intent = Intent(contexto, ResumoViagem::class.java)

                intent.putExtra("destino", destino)
                intent.putExtra("dias", dias)
                intent.putExtra("orcamento", orcamento)
                intent.putExtra("hospedagem", hospedagem)

                intent.putExtra("transporte", transporte)
                intent.putExtra("alimentacao", alimentacao)
                intent.putExtra("passeios", passeios)

                contexto.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Voltar
        Button(
            onClick = {
                (contexto as ComponentActivity).finish()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}