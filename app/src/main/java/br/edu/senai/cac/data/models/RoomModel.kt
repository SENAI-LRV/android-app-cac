/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/models/RoomModel.kt
* Descrição: Modelo de entidade para representar uma sala no banco de dados.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 27/05/2025
*/
package br.edu.senai.cac.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Modelo de entidade para representar uma sala no banco de dados.
 *
 * @property id O identificador único da sala (gerado automaticamente).
 * @property roomNumber O número ou identificação da sala (ex: "101", "Lab. Informática 02").
 * @property description Uma breve descrição da sala (ex: "Laboratório de Informática com 20 computadores").
 */
@Entity(tableName = "rooms")
data class RoomModel(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "room_number")
    val roomNumber: String,

    @ColumnInfo(name = "room_description")
    val description: String
)