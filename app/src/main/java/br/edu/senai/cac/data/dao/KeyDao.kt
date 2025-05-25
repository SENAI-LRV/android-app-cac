/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/dao/KeyDao.kt
* Descrição: Interface DAO (Data Access Object) para a entidade KeyModel.
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
import br.edu.senai.cac.data.models.KeyModel
import kotlinx.coroutines.flow.Flow

@Dao
interface KeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(key: KeyModel)

    @Update
    suspend fun update(key: KeyModel)

    @Delete
    suspend fun delete(key: KeyModel)

    @Query("SELECT * FROM keys WHERE id = :id")
    suspend fun getById(id: String): KeyModel?

    @Query("SELECT * FROM keys")
    fun getAll(): Flow<List<KeyModel>>

    @Query("DELETE FROM keys")
    suspend fun deleteAll()
}