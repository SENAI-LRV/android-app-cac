/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/TeacherDetailScreen.kt
* Descrição: Tela de detalhes do professor.
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
import br.edu.senai.cac.data.models.TeacherModel
import br.edu.senai.cac.ui.theme.CACTheme
import br.edu.senai.cac.ui.viewmodel.TeacherDetailViewModel

/**
 * Tela de detalhes do professor.
 * @param modifier Modificador para a tela.
 * @param updateTitle Função para atualizar o título da tela na TopAppBar.
 * @param teacherDetailViewModel ViewModel para gerir os dados dos professores.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun TeacherDetailScreen(
    modifier: Modifier = Modifier,
    updateTitle: (String) -> Unit,
    teacherDetailViewModel: TeacherDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        updateTitle("Professores Cadastrados")
    }

    val teachers by teacherDetailViewModel.teachers.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (teachers.isEmpty()) {
            Text(
                text = "Nenhum professor cadastrado no momento.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(teachers) { teacher ->
                    TeacherItem(
                        teacher = teacher,
                        onDeleteClick = {
                            teacherDetailViewModel.deleteTeacher(teacher)
                        }
                    )
                }
            }
        }
    }
}

/**
 * Composable para exibir um item de professor na lista.
 * @param teacher O modelo do professor (TeacherModel) a ser exibido.
 * @param onDeleteClick Callback para quando o botão "Excluir" é clicado.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Composable
fun TeacherItem(teacher: TeacherModel, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Professor: ${teacher.name}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Email: ${teacher.email}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Telefone: ${teacher.phone}", style = MaterialTheme.typography.bodyMedium)
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
 * Preview da tela de detalhes do professor.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Preview(showBackground = true)
@Composable
fun PreviewTeacherDetailScreen() {
    CACTheme {
        TeacherDetailScreen(
            updateTitle = {}
            // Não é possível instanciar ViewModel diretamente no Preview com Hilt sem setup adicional.
            // Para previews funcionais com ViewModel, considere usar um ViewModel mock.
        )
    }
}
