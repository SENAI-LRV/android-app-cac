/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/repository/RoomRepository.kt
* Descrição: Repositório para a entidade RoomModel.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
*/
package br.edu.senai.cac.data.repository

import br.edu.senai.cac.data.dao.RoomDao
import br.edu.senai.cac.data.models.RoomModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Repositório para a entidade RoomModel.
 * Fornece métodos para inserir, atualizar, deletar e consultar salas.
 * @property roomDao Acesso ao DAO para operações de banco de dados.
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
class RoomRepository @Inject constructor(
    private val roomDao: RoomDao
) {

    suspend fun insert(room: RoomModel) {
        roomDao.insert(room)
    }

    suspend fun update(room: RoomModel) {
        roomDao.update(room)
    }

    suspend fun delete(room: RoomModel) {
        roomDao.delete(room)
    }

    suspend fun getRoomById(id: String): RoomModel? {
        return roomDao.getById(id)
    }

    fun getAllRooms(): Flow<List<RoomModel>> {
        return roomDao.getAll()
    }

    suspend fun deleteAllRooms() {
        roomDao.deleteAll()
    }
}