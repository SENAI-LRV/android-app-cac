/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/models/TeacherModel.kt
* Descrição: Modelo de entidade para representar um professor no banco de dados.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 26/05/2025
*/
package br.edu.senai.cac.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Modelo de entidade para representar um professor no banco de dados.
 *
 * @property id O identificador único do professor (gerado automaticamente).
 * @property name O nome completo do professor.
 * @property email O endereço de e-mail do professor.
 * @property phone O número de telefone do professor.
 */
@Entity(tableName = "teachers")
data class TeacherModel(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "teacher_name")
    val name: String,

    @ColumnInfo(name = "teacher_email")
    val email: String,

    @ColumnInfo(name = "teacher_phone")
    val phone: String
)