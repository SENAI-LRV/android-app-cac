/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/TeacherDetailScreen.kt
* Descrição: Tela de detalhes do professor.
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
 * Tela de detalhes do professor.
 * @param modifier Modificador para a tela.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun TeacherDetailScreen(modifier: Modifier) {
    Box(modifier = Modifier.fillMaxSize())
}

/**
 * Preview da tela de detalhes do professor.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview
@Composable
fun PreviewTeacherDetailScreen() {
    TeacherDetailScreen(modifier = Modifier)
}
