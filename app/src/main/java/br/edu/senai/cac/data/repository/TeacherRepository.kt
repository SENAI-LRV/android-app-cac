/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/repository/TeacherRepository.kt
* Descrição: Repositório para a entidade TeacherModel.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
*/
package br.edu.senai.cac.data.repository

import br.edu.senai.cac.data.dao.TeacherDao
import br.edu.senai.cac.data.models.TeacherModel
import kotlinx.coroutines.flow.Flow

class TeacherRepository(private val teacherDao: TeacherDao) {

    suspend fun insert(teacher: TeacherModel) {
        teacherDao.insert(teacher)
    }

    suspend fun update(teacher: TeacherModel) {
        teacherDao.update(teacher)
    }

    suspend fun delete(teacher: TeacherModel) {
        teacherDao.delete(teacher)
    }

    suspend fun getTeacherById(id: String): TeacherModel? {
        return teacherDao.getById(id)
    }

    fun getAllTeachers(): Flow<List<TeacherModel>> {
        return teacherDao.getAll()
    }

    suspend fun deleteAllTeachers() {
        teacherDao.deleteAll()
    }
}