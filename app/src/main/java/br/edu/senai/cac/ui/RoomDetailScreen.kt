/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/RoomDetailScreen.kt
* Descrição: Tela de detalhes de uma sala.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 30/05/2025
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.edu.senai.cac.data.models.RoomModel
import br.edu.senai.cac.ui.theme.CACTheme
import br.edu.senai.cac.ui.viewmodel.RoomDetailViewModel

/**
 * Tela de detalhes de uma sala.
 * @param modifier Modificador para a tela.
 * @param updateTitle Função para atualizar o título da tela na TopAppBar.
 * @param roomDetailViewModel ViewModel para gerir os dados das salas.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun RoomDetailScreen(
    modifier: Modifier = Modifier,
    updateTitle: (String) -> Unit,
    roomDetailViewModel: RoomDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        updateTitle("Salas Cadastradas")
    }

    val rooms by roomDetailViewModel.rooms.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (rooms.isEmpty()) {
            Text(
                text = "Nenhuma sala cadastrada no momento.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(rooms) { room ->
                    RoomItem(
                        room = room,
                        onDeleteClick = {
                            roomDetailViewModel.deleteRoom(room)
                        }
                    )
                }
            }
        }
    }
}

/**
 * Composable para exibir um item de sala na lista.
 * @param room O modelo da sala (RoomModel) a ser exibido.
 * @param onDeleteClick Callback para quando o botão "Excluir" é clicado.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun RoomItem(room: RoomModel, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Sala: ${room.roomNumber}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Descrição: ${room.description}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Disponível: ${if (room.isAvailable) "Sim" else "Não"}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = onDeleteClick) {
                    Text("Excluir")
                }
            }
        }
    }
}

/**
 * Preview da tela de detalhes de uma sala.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewRoomDetailScreen() {
    CACTheme {
        RoomDetailScreen(
            updateTitle = {}
            // Não é possível instanciar ViewModel diretamente no Preview com Hilt sem setup adicional.
            // Para previews funcionais com ViewModel, considere usar um ViewModel mock.
        )
    }
}
