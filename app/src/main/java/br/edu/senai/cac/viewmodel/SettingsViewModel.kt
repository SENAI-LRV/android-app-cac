/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/viewmodel/SettingsViewModel.kt
* Descrição: ViewModel para a tela de configurações.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 08/06/2025
*/
package br.edu.senai.cac.viewmodel

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

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: SettingsRepository
) : ViewModel() {

    private val _settingsList = MutableStateFlow<List<SettingsModel>>(emptyList())
    val settingsList: StateFlow<List<SettingsModel>> = _settingsList.asStateFlow()

    init {
        loadAllSettings()
    }

    private fun loadAllSettings() {
        viewModelScope.launch {
            repository.getAll().collect { settings ->
                _settingsList.value = settings
            }
        }
    }

    fun getSettingByKey(key: String, callback: (SettingsModel?) -> Unit) {
        viewModelScope.launch {
            val setting = repository.getByKey(key)
            callback(setting)
        }
    }

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

    fun updateSetting(setting: SettingsModel) {
        viewModelScope.launch {
            repository.update(setting)
        }
    }

    fun deleteSettingByKey(key: String) {
        viewModelScope.launch {
            repository.deleteByKey(key)
        }
    }

    fun deleteAllSettings() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}

