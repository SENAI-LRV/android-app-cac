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
import br.edu.senai.cac.data.models.KeyModel
import br.edu.senai.cac.data.repository.KeyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para gerir a lógica de negócios da tela de detalhes das chaves.
 * @param repository Acesso ao repositório para operações de banco de dados.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@HiltViewModel
class KeyDetailViewModel @Inject constructor(
    private val repository: KeyRepository
) : ViewModel() {

    val keys: StateFlow<List<KeyModel>> =
        repository.getAllKeys()
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    /**
     * Adiciona uma nova chave ao banco de dados.
     * @param key O KeyModel da nova chave a ser inserida.
     */
    fun addKey(key: KeyModel) {
        viewModelScope.launch {
            repository.insert(key)
        }
    }

    /**
     * Reserva uma chave existente, atualizando seu status.
     * @param key O KeyModel da chave a ser reservada.
     */
    fun reserveKey(key: KeyModel) {
        viewModelScope.launch {
            val updatedKey = key.copy(isAvailable = false, location = "Reservada")
            repository.update(updatedKey)
        }
    }

    /**
     * Deleta uma chave do banco de dados.
     * @param key O KeyModel da chave a ser deletada.
     */
    fun deleteKey(key: KeyModel) {
        viewModelScope.launch {
            repository.delete(key)
        }
    }

    /**
     * Deleta uma chave pelo seu ID.
     * @param keyId O ID da chave a ser deletada.
     */
    fun deleteKeyById(keyId: String) {
        viewModelScope.launch {
            repository.deleteById(keyId)
        }
    }

    /**
     * Deleta todas as chaves fornecidas.
     * @param keys A lista de KeyModel das chaves a serem deletadas.
     */
    fun deleteAllKeys(keys: List<KeyModel>) {
        viewModelScope.launch {
            repository.deleteAll(keys)
        }
    }

    /**
     * Devolve uma chave, atualizando seu status para disponível.
     * @param key O KeyModel da chave a ser devolvida.
     */
    fun returnKey(key: KeyModel) {
        viewModelScope.launch {
            val updatedKey = key.copy(isAvailable = true, location = "Sala Técnica")
            repository.update(updatedKey)
        }
    }
}
