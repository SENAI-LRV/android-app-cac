/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/KeyRegistrationScreen.kt
* Descrição: Tela de registro de chaves.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
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
import br.edu.senai.cac.data.models.KeyModel

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
    var keyName by remember { mutableStateOf("") }
    var keyRoomNumber by remember { mutableStateOf("") }
    var keyIsAvailable by remember { mutableStateOf(true) }
    var keyCurrentLocation by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp) // Aumentado para 16.dp
    ) {
        Text(
            text = "Cadastrar Nova Chave",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp) // Espaçamento adicional abaixo do título
        )

        OutlinedTextField(
            value = keyName,
            onValueChange = { keyName = it },
            label = { Text("Nome da Chave (Ex: Sala 101, Lab Info)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = keyRoomNumber,
            onValueChange = { keyRoomNumber = it },
            label = { Text("Número da Sala (Ex: S101, LAB02)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Adiciona espaçamento entre Checkbox e Text
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

        Button(
            onClick = {
                val newKey = KeyModel(
                    name = keyName,
                    roomNumber = keyRoomNumber,
                    isAvailable = keyIsAvailable,
                    location = keyCurrentLocation
                )
                onSaveKey(newKey)

                if (BuildConfig.BUILD_TYPE.equals("Debug", ignoreCase = true)) {
                    Log.d("KeyRegistrationScreen", "Chave salva: $newKey")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = keyName.isNotBlank() && keyRoomNumber.isNotBlank() && keyCurrentLocation.isNotBlank()
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
