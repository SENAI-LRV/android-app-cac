/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/SettingsScreen.kt
* Descrição: Tela de configurações do aplicativo.
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.edu.senai.cac.data.models.SettingsModel
import br.edu.senai.cac.viewmodel.SettingsViewModel

/**
 * Tela de configurações do aplicativo.
 * @param modifier Modificador para a tela.
 * @param viewModel ViewModel para gerenciar os dados de configurações.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val settingsList by viewModel.settingsList.collectAsState()
    var currentKey by remember { mutableStateOf("") }
    var currentValue by remember { mutableStateOf("") }
    var isEditing by remember { mutableStateOf<SettingsModel?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Configurações do Aplicativo", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = currentKey,
            onValueChange = { currentKey = it },
            label = { Text("Chave da Configuração") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = isEditing != null
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = currentValue,
            onValueChange = { currentValue = it },
            label = { Text("Valor da Configuração") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (currentKey.isNotBlank() && currentValue.isNotBlank()) {
                    viewModel.insertOrUpdateSetting(currentKey, currentValue)
                    currentKey = ""
                    currentValue = ""
                    isEditing = null
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isEditing == null) "Adicionar Configuração" else "Atualizar Configuração")
        }

        if (isEditing != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    currentKey = ""
                    currentValue = ""
                    isEditing = null
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors()
            ) {
                Text("Cancelar Edição")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Configurações Salvas:", style = MaterialTheme.typography.titleMedium)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(settingsList) { setting ->
                SettingItem(
                    setting = setting,
                    onEdit = {
                        currentKey = it.key
                        currentValue = it.value
                        isEditing = it
                    },
                    onDelete = {
                        viewModel.deleteSettingByKey(it.key)
                        if (isEditing?.key == it.key) {
                            currentKey = ""
                            currentValue = ""
                            isEditing = null
                        }
                    }
                )
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun SettingItem(
    setting: SettingsModel,
    onEdit: (SettingsModel) -> Unit,
    onDelete: (SettingsModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Chave: ${setting.key}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Valor: ${setting.value}", style = MaterialTheme.typography.bodyMedium)
        }
        Row {
            IconButton(onClick = { onEdit(setting) }) {
                Icon(Icons.Filled.Edit, contentDescription = "Editar")
            }
            IconButton(onClick = { onDelete(setting) }) {
                Icon(Icons.Filled.Delete, contentDescription = "Excluir")
            }
        }
    }
}

/**
 * Preview da tela de configurações do aplicativo.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    MaterialTheme {
        SettingsScreen(modifier = Modifier)
    }
}
