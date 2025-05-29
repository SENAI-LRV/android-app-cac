/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/database/AppDatabase.kt
* Descrição: Classe abstrata que representa o banco de dados Room do aplicativo.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
*/
package br.edu.senai.cac.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.senai.cac.data.dao.KeyDao
import br.edu.senai.cac.data.dao.RoomDao
import br.edu.senai.cac.data.dao.TeacherDao
import br.edu.senai.cac.data.models.KeyModel
import br.edu.senai.cac.data.models.RoomModel
import br.edu.senai.cac.data.models.TeacherModel

@Database(entities = [KeyModel::class, RoomModel::class, TeacherModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun keyDao(): KeyDao
    abstract fun roomDao(): RoomDao
    abstract fun teacherDao(): TeacherDao
}