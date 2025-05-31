/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/KeyDetailScreen.kt
* Descrição: Tela de detalhes e listagem de chaves.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import br.edu.senai.cac.data.models.KeyModel
import br.edu.senai.cac.ui.theme.CACTheme
import br.edu.senai.cac.ui.viewmodel.KeyDetailViewModel

/**
 * Tela de listagem e detalhes das chaves.
 * @param modifier Modificador para a tela.
 * @param updateTitle Função para atualizar o título da tela na TopAppBar.
 * @param onNavigateBack Função para ser chamada quando o botão "Voltar" é pressionado.
 * @param keyDetailViewModel ViewModel para gerir os dados das chaves.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun KeyDetailScreen(
    modifier: Modifier = Modifier,
    updateTitle: (String) -> Unit,
    onNavigateBack: () -> Unit,
    keyDetailViewModel: KeyDetailViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    var keyToReserve by remember { mutableStateOf<KeyModel?>(null) }

    LaunchedEffect(Unit) {
        updateTitle("Chaves Disponíveis")
    }

    val keys by keyDetailViewModel.keys.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (keys.isEmpty()) {
            Text(
                text = "Nenhuma chave cadastrada ou disponível no momento.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(keys) { key ->
                    KeyItem(
                        key = key,
                        onReserveClick = {
                            keyToReserve = key
                            showDialog = true
                        },
                        onDeleteClick = {
                            keyDetailViewModel.deleteKey(key)
                        }
                    )
                }
            }
        }

        if (showDialog) {
            Dialog(onDismissRequest = {
                keyToReserve?.let { key ->
                    keyDetailViewModel.reserveKey(key)
                }
                showDialog = false
                keyToReserve = null
            }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Chave reservada com sucesso!",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        keyToReserve?.let { key ->
                            keyDetailViewModel.reserveKey(key)
                        }
                        showDialog = false
                        keyToReserve = null
                    }) {
                        Text("OK")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}

/**
 * Composable para exibir um item de chave na lista.
 * @param key O modelo da chave (RoomModel) a ser exibido.
 * @param onReserveClick Callback para quando o botão "Reservar" é clicado.
 * @param onDeleteClick Callback para quando o botão "Excluir" é clicado.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun KeyItem(key: KeyModel, onReserveClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Chave: ${key.name}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Sala: ${key.roomNumber}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Professor: ${key.isAvailable}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = onReserveClick) {
                    Text("Reservar")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = onDeleteClick) {
                    Text("Excluir")
                }
            }
        }
    }
}

/**
 * Preview da tela de detalhes da chave.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewKeyDetailScreen() {
    CACTheme {
        KeyDetailScreen(
            updateTitle = {},
            onNavigateBack = {}
        )
    }
}
