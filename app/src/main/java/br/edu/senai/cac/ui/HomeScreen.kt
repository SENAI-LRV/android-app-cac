/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/HomeScreen.kt
* Descrição: Tela inicial do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 24/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Tela inicial do aplicativo.
 * @param modifier Modificador para a tela.
 * @param onLoginAction Ação a ser executada ao clicar no botão de login.
 * @param onForgotPasswordAction Ação a ser executada ao clicar no botão de esqueci minha senha.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun HomeScreen(
    modifier: Modifier,
    onLoginAction: () -> Unit,
    onForgotPasswordAction: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Usuário:",
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxWidth()
        )

        Text(
            text = "Senha:",
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxWidth()
        )

        Button(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxWidth(),
            onClick = { onLoginAction }) {
            Text(text = "Acessar")
        }

        Button(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxWidth(),
            onClick = { onForgotPasswordAction }) {
            Text(text = "Esqueci minha senha")
        }
    }
}

/**
 * Preview da tela inicial do aplicativo.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(modifier = Modifier, onLoginAction = {}, onForgotPasswordAction = {})
}
