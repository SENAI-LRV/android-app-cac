/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/viewmodel/KeyDetailViewModel.kt
* Descrição: ViewModel para gerir a lógica de negócios da tela de detalhes das chaves.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 30/05/2025
*/
package br.edu.senai.cac.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.senai.cac.data.models.TeacherModel
import br.edu.senai.cac.data.repository.TeacherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para gerir a lógica de negócios da tela de detalhes dos professores.
 * @param repository Acesso ao repositório para operações de banco de dados.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@HiltViewModel
class TeacherDetailViewModel @Inject constructor(
    private val repository: TeacherRepository
) : ViewModel() {

    val teachers: StateFlow<List<TeacherModel>> =
        repository.getAllTeachers()
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    /**
     * Adiciona um novo professor ao banco de dados.
     * @param teacher O TeacherModel do novo professor a ser inserido.
     */
    fun addTeacher(teacher: TeacherModel) {
        viewModelScope.launch {
            repository.insert(teacher)
        }
    }

    /**
     * Atualiza um professor existente no banco de dados.
     * @param teacher O TeacherModel do professor a ser atualizado.
     */
    fun updateTeacher(teacher: TeacherModel) {
        viewModelScope.launch {
            repository.update(teacher)
        }
    }

    /**
     * Deleta um professor do banco de dados.
     * @param teacher O TeacherModel do professor a ser deletado.
     */
    fun deleteTeacher(teacher: TeacherModel) {
        viewModelScope.launch {
            repository.delete(teacher)
        }
    }
}
