/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/TeacherRegistrationScreen.kt
* Descrição: Tela de cadastro de professores.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 30/05/2025
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package br.edu.senai.cac.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.senai.cac.BuildConfig
import br.edu.senai.cac.data.models.TeacherModel

/**
 * Tela de cadastro de professores.
 * @param modifier Modificador para a tela.
 * @param onNavigateBack Ação a ser executada ao clicar no botão de voltar.
 * @param onSaveTeacher Ação a ser executada ao salvar o professor, recebendo o TeacherModel preenchido.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeacherRegistrationScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onSaveTeacher: (TeacherModel) -> Unit
) {
    var teacherName by remember { mutableStateOf("") }
    var teacherEmail by remember { mutableStateOf("") }
    var teacherPhone by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Cadastrar Novo Professor",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = teacherName,
            onValueChange = { teacherName = it },
            label = { Text("Nome Completo do Professor") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = teacherEmail,
            onValueChange = { teacherEmail = it },
            label = { Text("E-mail do Professor") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = teacherPhone,
            onValueChange = { teacherPhone = it },
            label = { Text("Telefone do Professor (Ex: (XX) XXXXX-XXXX)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Button(
            onClick = {
                val newTeacher = TeacherModel(
                    name = teacherName,
                    email = teacherEmail,
                    phone = teacherPhone
                )
                onSaveTeacher(newTeacher)

                if (BuildConfig.BUILD_TYPE.equals("Debug", ignoreCase = true)) {
                    Log.d("TeacherRegistrationScreen", "Professor salvo: $newTeacher")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = teacherName.isNotBlank() && teacherEmail.isNotBlank() && teacherPhone.isNotBlank()
        ) {
            Text("Salvar Professor")
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
 * Preview da tela de cadastro de professores.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewTeacherRegistrationScreen() {
    MaterialTheme {
        TeacherRegistrationScreen(
            onNavigateBack = {},
            onSaveTeacher = { teacher ->
                println("Professor para salvar (Preview): $teacher")
            }
        )
    }
}
