/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/RoomRegistrationScreen.kt
* Descrição: Tela de cadastro de salas.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 30/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.senai.cac.BuildConfig
import br.edu.senai.cac.data.models.RoomModel

/**
 * Tela de cadastro de salas.
 * @param modifier Modificador para a tela.
 * @param onNavigateBack Ação a ser executada ao clicar no botão de voltar.
 * @param onSaveRoom Ação a ser executada ao salvar a sala, recebendo o RoomModel preenchido.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomRegistrationScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onSaveRoom: (RoomModel) -> Unit
) {
    var roomNumber by remember { mutableStateOf("") }
    var roomDescription by remember { mutableStateOf("") }
    var roomIsAvailable by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Cadastrar Nova Sala",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = roomNumber,
            onValueChange = { roomNumber = it },
            label = { Text("Número da Sala (Ex: S101, LAB02)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = roomDescription,
            onValueChange = { roomDescription = it },
            label = { Text("Descrição da Sala (Ex: Laboratório de Redes)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false // Pode ser multilinha
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Checkbox(
                checked = roomIsAvailable,
                onCheckedChange = { roomIsAvailable = it }
            )
            Text("Sala disponível")
        }

        Button(
            onClick = {
                val newRoom = RoomModel(
                    roomNumber = roomNumber,
                    description = roomDescription,
                    isAvailable = roomIsAvailable
                )
                onSaveRoom(newRoom)

                if (BuildConfig.BUILD_TYPE.equals("Debug", ignoreCase = true)) {
                    Log.d("RoomRegistrationScreen", "Sala salva: $newRoom")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = roomNumber.isNotBlank() && roomDescription.isNotBlank()
        ) {
            Text("Salvar Sala")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onNavigateBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}

/**
 * Preview da tela de cadastro de salas.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewRoomRegistrationScreen() {
    MaterialTheme {
        RoomRegistrationScreen(
            onNavigateBack = {},
            onSaveRoom = { room ->
                println("Sala para salvar (Preview): $room")
            }
        )
    }
}
