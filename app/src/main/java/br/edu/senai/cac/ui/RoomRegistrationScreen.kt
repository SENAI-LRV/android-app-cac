/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/RoomRegistrationScreen.kt
* Descrição: Tela de cadastro de salas.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Tela de cadastro de salas.
 * @param modifier Modificador para a tela.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun RoomRegistrationScreen(modifier: Modifier) {
    Box(modifier = Modifier.fillMaxSize())
}

/**
 * Preview da tela de cadastro de salas.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview
@Composable
fun PreviewRoomRegistrationScreen() {
    RoomRegistrationScreen(modifier = Modifier)
}
