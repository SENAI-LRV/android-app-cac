/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/AdminScreen.kt
* Descrição: Tela de administração do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Tela de administração do aplicativo.
 * @param modifier Modificador para a tela.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun AdminScreen(
    modifier: Modifier,
    onKeyRegistrationAction: () -> Unit,
    onTeacherRegistrationAction: () -> Unit,
    onRoomRegistrationAction: () -> Unit,
    onKeyDetailsAction: () -> Unit,
    onTeacherDetailsAction: () -> Unit,
    onRoomDetailsAction: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Cadastro",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 32.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Start
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            thickness = 2.dp,
            color = Color.Black
        )

        Button(
            onClick = { onKeyRegistrationAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text("Cadastro de Chaves")
        }

        Button(
            onClick = { onTeacherRegistrationAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text("Cadastro de Professores")
        }

        Button(
            onClick = { onRoomRegistrationAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text("Cadastro de Salas")
        }

        Text(
            text = "Detalhes",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 32.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Start
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            thickness = 2.dp,
            color = Color.Black
        )

        Button(
            onClick = { onKeyDetailsAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text("Detalhes de Chaves")
        }

        Button(
            onClick = { onTeacherDetailsAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text("Detalhes de Professores")
        }

        Button(
            onClick = { onRoomDetailsAction() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text("Detalhes de Salas")
        }
    }
}

/**
 * Preview da tela de administração do aplicativo.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview
@Composable
fun PreviewAdminScreen() {
    AdminScreen(
        modifier = Modifier,
        onKeyRegistrationAction = {},
        onTeacherRegistrationAction = {},
        onRoomRegistrationAction = {},
        onKeyDetailsAction = {},
        onTeacherDetailsAction = {},
        onRoomDetailsAction = {})
}
