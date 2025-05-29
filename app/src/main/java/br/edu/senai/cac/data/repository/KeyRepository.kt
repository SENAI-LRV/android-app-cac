/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/repository/KeyRepository.kt
* Descrição: Repositório para a entidade KeyModel.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
*/
package br.edu.senai.cac.data.repository

import br.edu.senai.cac.data.dao.KeyDao
import br.edu.senai.cac.data.models.KeyModel
import kotlinx.coroutines.flow.Flow

/**
 * Repositório para a entidade KeyModel.
 * Este repositório fornece métodos para inserir, atualizar, deletar e recuperar chaves do banco de dados.
 * @property keyDao A instância do DAO para operações com KeyModel.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
class KeyRepository(private val keyDao: KeyDao) {

    suspend fun insert(key: KeyModel) {
        keyDao.insert(key)
    }

    suspend fun update(key: KeyModel) {
        keyDao.update(key)
    }

    suspend fun delete(key: KeyModel) {
        keyDao.delete(key)
    }

    suspend fun getKeyById(id: String): KeyModel? {
        return keyDao.getById(id)
    }

    fun getAllKeys(): Flow<List<KeyModel>> {
        return keyDao.getAll()
    }

    suspend fun deleteAllKeys() {
        keyDao.deleteAll()
    }
}