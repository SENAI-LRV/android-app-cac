/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/dao/SettingsDao.kt
* Descrição: DAO para gerenciar as configurações do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 08/06/2025
*/
package br.edu.senai.cac.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.senai.cac.data.models.SettingsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settings: SettingsModel)

    @Update
    suspend fun update(settings: SettingsModel)

    @Query("SELECT * FROM settings WHERE `key` = :key")
    suspend fun getByKey(key: String): SettingsModel?

    @Query("SELECT * FROM settings")
    fun getAll(): Flow<List<SettingsModel>>

    @Query("DELETE FROM settings WHERE `key` = :key")
    suspend fun deleteByKey(key: String)

    @Query("DELETE FROM settings")
    suspend fun deleteAll()
}