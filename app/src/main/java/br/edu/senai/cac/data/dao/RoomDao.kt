/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/dao/RoomDao.kt
* Descrição: Interface DAO (Data Access Object) para a entidade RoomModel.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
*/
package br.edu.senai.cac.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.senai.cac.data.models.RoomModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(room: RoomModel)

    @Update
    suspend fun update(room: RoomModel)

    @Delete
    suspend fun delete(room: RoomModel)

    @Query("SELECT * FROM rooms WHERE id = :id")
    suspend fun getById(id: String): RoomModel?

    @Query("SELECT * FROM rooms ORDER BY room_name ASC")
    fun getAll(): Flow<List<RoomModel>>

    @Query("DELETE FROM rooms")
    suspend fun deleteAll()
}