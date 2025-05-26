/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/KeyRegistrationScreen.kt
* Descrição: Tela de registro de chaves.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
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
import br.edu.senai.cac.data.models.KeyModel // Certifique-se de que este é o caminho correto para KeyModel

/**
 * Tela de registro de chaves.
 * @param modifier Modificador para a tela.
 * @param onNavigateBack Ação a ser executada ao clicar no botão de voltar.
 * @param onSaveKey Ação a ser executada ao salvar a chave, recebendo o KeyModel preenchido.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeyRegistrationScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onSaveKey: (KeyModel) -> Unit
) {
    var keyId by remember { mutableStateOf("") }
    var keyName by remember { mutableStateOf("") }
    var keyRoomNumber by remember { mutableStateOf("") }
    var keyIsAvailable by remember { mutableStateOf(true) }
    var keyCurrentLocation by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = keyId,
            onValueChange = { keyId = it },
            label = { Text("Identificador da Chave (Ex: TAG001)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = keyName,
            onValueChange = { keyName = it },
            label = { Text("Nome da Chave (Ex: Sala 101, Lab Info)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = keyIsAvailable,
                onCheckedChange = { keyIsAvailable = it }
            )
            Text("Chave disponível")
        }

        OutlinedTextField(
            value = keyCurrentLocation,
            onValueChange = {
                keyCurrentLocation = it
            },
            label = { Text("Localização Atual da Chave (Ex: S101, LAB02)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newKey = KeyModel(
                    id = keyId,
                    name = keyName,
                    roomNumber = keyRoomNumber,
                    isAvailable = keyIsAvailable,
                    location = keyCurrentLocation
                )
                onSaveKey(newKey)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = keyId.isNotBlank() && keyName.isNotBlank() && keyCurrentLocation.isNotBlank()
        ) {
            Text("Salvar Chave")
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
 * Preview da tela de registro de chaves.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewKeyRegistrationScreen() {
    MaterialTheme {
        KeyRegistrationScreen(
            onNavigateBack = {},
            onSaveKey = { key ->
                println("Chave para salvar (Preview): $key")
            }
        )
    }
}
