package br.edu.ifsp.scl.sc3018237.fasttripplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

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


}