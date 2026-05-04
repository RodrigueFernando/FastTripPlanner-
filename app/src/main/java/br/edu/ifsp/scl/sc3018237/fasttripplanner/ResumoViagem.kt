package br.edu.ifsp.scl.sc3018237.fasttripplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class ResumoViagem : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recebe dados da tela 2
        val destino = intent.getStringExtra("destino")
        val dias = intent.getIntExtra("dias", 0)
        val orcamento = intent.getDoubleExtra("orcamento", 0.0)
        val hospedagem = intent.getStringExtra("hospedagem")

        val transporte = intent.getBooleanExtra("transporte", false)
        val alimentacao = intent.getBooleanExtra("alimentacao", false)
        val passeios = intent.getBooleanExtra("passeios", false)

        setContent {
            TelaResumo(
                destino,
                dias,
                orcamento,
                hospedagem,
                transporte,
                alimentacao,
                passeios
            )
        }
    }
}

//Desenha a tela
@Composable
fun TelaResumo(
    destino: String?,
    dias: Int,
    orcamento: Double,
    hospedagem: String?,
    transporte: Boolean,
    alimentacao: Boolean,
    passeios: Boolean
) {

    val contexto = LocalContext.current

    // Cálculo do total
    val custoBase = dias * orcamento

    //Define o multiplicador conforme a hospedagem
    val multiplicador = when (hospedagem) {
        "Econômica" -> 1.0
        "Conforto" -> 1.5
        "Luxo" -> 2.2
        else -> 1.0
    }

    var total = custoBase * multiplicador

    // Aplica o multiplicador ao serviço
    if (transporte) total += 300
    if (alimentacao) total += 50 * dias
    if (passeios) total += 120 * dias

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){

        Text("Resumo da Viagem", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Destino: ${destino ?: "Não informado"}")
        Text("Dias: $dias")
        Text("Orçamento diário: $orcamento")
        Text("Hospedagem: $hospedagem")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Extras:")

        if (transporte) Text("- Transporte")
        if (alimentacao) Text("- Alimentação")
        if (passeios) Text("- Passeios")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total: R$ $total", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Botão reiniciar
        Button(
            onClick = {
                val intent = Intent(contexto, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                contexto.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reiniciar")
        }
    }


}