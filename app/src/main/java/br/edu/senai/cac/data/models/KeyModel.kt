/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/models/KeyModel.kt
* Descrição: Modelo de entidade para representar uma chave no banco de dados.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 25/05/2025
*/
package br.edu.senai.cac.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Modelo de entidade para representar uma chave no banco de dados.
 *
 * @property id O identificador único da chave (gerado automaticamente).
 * @property name O nome ou identificação da chave (ex: "Chave Lab Informática 01").
 * @property roomNumber O número da sala à qual esta chave pertence.
 * @property isAvailable Indica se a chave está disponível para empréstimo.
 * @property isDisabled Indica se a chave está desativada (não pode ser emprestada).
 * @property location A localização atual da chave (ex: "Secretaria", "Com Professor X").
 * @property createdAt Timestamp de criação da chave (gerado automaticamente).
 * @property updatedAt Timestamp da última atualização da chave (gerado automaticamente).
 */
@Entity(
    tableName = "keys",
    foreignKeys = [
        ForeignKey(
            entity = RoomModel::class,
            parentColumns = ["id"],
            childColumns = ["room_number"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class KeyModel(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "key_name")
    val name: String,

    @ColumnInfo(name = "room_number")
    val roomNumber: String,

    @ColumnInfo(name = "is_available")
    var isAvailable: Boolean = true,

    @ColumnInfo(name = "is_disabled")
    var isDisabled: Boolean = false,

    @ColumnInfo(name = "current_location")
    var location: String = "Sala Técnica",

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
)