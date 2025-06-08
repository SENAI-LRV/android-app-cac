/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/models/SettingsModel.kt
* Descrição: Modelo de entidade para representar uma configuração no banco de dados.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 08/06/2025
*/
package br.edu.senai.cac.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "settings")
data class SettingsModel(
    @PrimaryKey
    val key: String = UUID.randomUUID().toString(),
    val value: String
)