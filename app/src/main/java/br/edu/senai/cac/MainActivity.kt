/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/MainActivity.kt
* Descrição: Activity principal do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
package br.edu.senai.cac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.edu.senai.cac.ui.theme.CACTheme

/**
 * Atividade principal do aplicativo.
 * Esta atividade é responsável por configurar a interface do usuário e gerenciar o ciclo de vida do aplicativo.
 * @constructor Cria uma nova instância da atividade principal.
 * @see [ComponentActivity]
 * @see [CACTheme]
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CACTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}