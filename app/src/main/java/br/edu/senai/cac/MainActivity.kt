/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/MainActivity.kt
* Descrição: Activity principal do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import br.edu.senai.cac.ui.navigation.AppNavGraph
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
                val navController = rememberNavController()
                var currentScreenTitle by remember { mutableStateOf("Tela inicial") }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(text = currentScreenTitle, fontWeight = FontWeight.Bold)
                            }
                        })
                    },

                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier,
                            containerColor = Color.LightGray
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 16.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(text = "v1.0.0", fontWeight = FontWeight.Bold)
                            }
                        }
                    }) { innerPadding ->
                    AppNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        updateTitle = { title -> currentScreenTitle = title })
                }
            }
        }
    }
}