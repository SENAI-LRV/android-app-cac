/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/repository/SettingsRepository.kt
* Descrição: Repositório para gerenciar as configurações do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 08/06/2025
*/
package br.edu.senai.cac.data.repository

import br.edu.senai.cac.data.dao.SettingsDao
import br.edu.senai.cac.data.models.SettingsModel
import kotlinx.coroutines.flow.Flow

class SettingsRepository(private val settingsDao: SettingsDao) {

    suspend fun insert(settings: SettingsModel) {
        settingsDao.insert(settings)
    }

    suspend fun update(settings: SettingsModel) {
        settingsDao.update(settings)
    }

    suspend fun getByKey(key: String): SettingsModel? {
        return settingsDao.getByKey(key)
    }

    fun getAll(): Flow<List<SettingsModel>> {
        return settingsDao.getAll()
    }

    suspend fun deleteByKey(key: String) {
        settingsDao.deleteByKey(key)
    }

    suspend fun deleteAll() {
        settingsDao.deleteAll()
    }
}