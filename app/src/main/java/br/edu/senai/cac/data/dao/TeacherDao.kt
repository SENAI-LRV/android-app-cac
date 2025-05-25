/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/dao/TeacherDao.kt
* Descrição: Interface DAO (Data Access Object) para a entidade TeacherModel.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 26/05/2025
*/
package br.edu.senai.cac.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.senai.cac.data.models.TeacherModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TeacherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teacher: TeacherModel)

    @Update
    suspend fun update(teacher: TeacherModel)

    @Delete
    suspend fun delete(teacher: TeacherModel)

    @Query("SELECT * FROM teachers WHERE id = :id")
    suspend fun getById(id: String): TeacherModel?

    @Query("SELECT * FROM teachers ORDER BY teacher_name ASC")
    fun getAll(): Flow<List<TeacherModel>>

    @Query("DELETE FROM teachers")
    suspend fun deleteAll()
}