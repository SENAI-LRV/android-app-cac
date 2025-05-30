/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/viewmodel/RoomDetailViewModel.kt
* Descrição: ViewModel para gerir a lógica de negócios da tela de detalhes das salas.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 30/05/2025
*/
package br.edu.senai.cac.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.senai.cac.data.models.RoomModel
import br.edu.senai.cac.data.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para gerir a lógica de negócios da tela de detalhes das salas.
 * @param repository Acesso ao repositório para operações de banco de dados.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@HiltViewModel
class RoomDetailViewModel @Inject constructor(
    private val repository: RoomRepository
) : ViewModel() {

    val rooms: StateFlow<List<RoomModel>> =
        repository.getAllRooms()
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    /**
     * Adiciona uma nova sala ao banco de dados.
     * @param room O RoomModel da nova sala a ser inserida.
     */
    fun addRoom(room: RoomModel) {
        viewModelScope.launch {
            repository.insert(room)
        }
    }

    /**
     * Reserva uma sala existente, atualizando seu status para indisponível.
     * @param room O RoomModel da sala a ser reservada.
     */
    fun reserveRoom(room: RoomModel) {
        viewModelScope.launch {
            val updatedRoom = room.copy(
                isAvailable = false
            )
            repository.update(updatedRoom)
        }
    }

    /**
     * Deleta uma sala do banco de dados.
     * @param room O RoomModel da sala a ser deletada.
     */
    fun deleteRoom(room: RoomModel) {
        viewModelScope.launch {
            repository.delete(room)
        }
    }

    /**
     * Devolve uma sala, atualizando seu status para disponível.
     * @param room O RoomModel da sala a ser devolvida.
     */
    fun returnRoom(room: RoomModel) {
        viewModelScope.launch {
            val updatedRoom = room.copy(isAvailable = true)
            repository.update(updatedRoom)
        }
    }
}
