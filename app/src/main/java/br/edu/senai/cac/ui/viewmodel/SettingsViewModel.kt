/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/ui/viewmodel/SettingsViewModel.kt
* Descrição: ViewModel para gerenciar as configurações da aplicação.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 08/06/2025
*/
package br.edu.senai.cac.br.edu.senai.cac.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.senai.cac.data.models.SettingsModel
import br.edu.senai.cac.data.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel para gerenciar as configurações da aplicação.
 * Este ViewModel utiliza o repositório de configurações para realizar operações CRUD
 * e expõe um fluxo de estado para a UI.
 * @param repository O repositório de configurações utilizado para acessar os dados.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: SettingsRepository
) : ViewModel() {

    private val _settingsList = MutableStateFlow<List<SettingsModel>>(emptyList())
    val settingsList: StateFlow<List<SettingsModel>> = _settingsList.asStateFlow()

    init {
        loadAllSettings()
    }

    /**
     * Carrega todas as configurações do repositório e atualiza o estado.
     * Utiliza um fluxo para observar as mudanças nas configurações.
     */
    private fun loadAllSettings() {
        viewModelScope.launch {
            repository.getAll().collect { settings ->
                _settingsList.value = settings
            }
        }
    }

    /**
     * Obtém uma configuração específica pelo seu identificador (key).
     * @param key A chave da configuração a ser buscada.
     * @param callback Função de callback para retornar o resultado.
     */
    fun getSettingByKey(key: String, callback: (SettingsModel?) -> Unit) {
        viewModelScope.launch {
            val setting = repository.getByKey(key)
            callback(setting)
        }
    }

    /**
     * Insere ou atualiza uma configuração no repositório.
     * Se a configuração já existir, ela será atualizada; caso contrário, será inserida.
     * @param key A chave da configuração.
     * @param value O valor da configuração.
     */
    fun insertOrUpdateSetting(key: String, value: String) {
        viewModelScope.launch {
            val existingSetting = repository.getByKey(key)
            if (existingSetting != null) {
                repository.update(SettingsModel(key, value))
            } else {
                repository.insert(SettingsModel(key, value))
            }
        }
    }

    /**
     * Insere uma nova configuração no repositório.
     * @param setting A configuração a ser inserida.
     */
    fun updateSetting(setting: SettingsModel) {
        viewModelScope.launch {
            repository.update(setting)
        }
    }

    /**
     * Deleta uma configuração específica pelo seu identificador (key).
     * @param key A chave da configuração a ser deletada.
     */
    fun deleteSettingByKey(key: String) {
        viewModelScope.launch {
            repository.deleteByKey(key)
        }
    }

    /**
     * Deleta todas as configurações do repositório.
     * Utilizado para limpar todas as configurações armazenadas.
     */
    fun deleteAllSettings() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}