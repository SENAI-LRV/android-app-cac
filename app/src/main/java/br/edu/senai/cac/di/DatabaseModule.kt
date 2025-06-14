/*
* Projeto: CAC - Cadê a Chave?
* Arquivo: /app/src/main/java/br/edu/senai/cac/data/di/DatabaseModule.kt
* Descrição: Módulo de injeção de dependências para o banco de dados.
* Autor: Miguel Nischor <miguel@docente.senai.br>
* Data: 28/05/2025
*/
package br.edu.senai.cac.di

import android.content.Context
import androidx.room.Room
import br.edu.senai.cac.data.dao.KeyDao
import br.edu.senai.cac.data.dao.RoomDao
import br.edu.senai.cac.data.dao.SettingsDao
import br.edu.senai.cac.data.dao.TeacherDao
import br.edu.senai.cac.data.database.AppDatabase
import br.edu.senai.cac.data.repository.KeyRepository
import br.edu.senai.cac.data.repository.RoomRepository
import br.edu.senai.cac.data.repository.SettingsRepository
import br.edu.senai.cac.data.repository.TeacherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Módulo de injeção de dependências para o banco de dados.
 * Fornece instâncias do banco de dados, DAOs e repositórios.
 * @see [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
 * @author Miguel Nischor <miguel@docente.senai.br>
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "cac-db")
            .fallbackToDestructiveMigration(true)
            .build()

    @Provides
    fun provideKeyDao(db: AppDatabase): KeyDao =
        db.keyDao()

    @Provides
    fun provideKeyRepository(keyDao: KeyDao): KeyRepository =
        KeyRepository(keyDao)

    @Provides
    fun provideRoomDao(db: AppDatabase): RoomDao =
        db.roomDao()

    @Provides
    fun provideRoomRepository(roomDao: RoomDao): RoomRepository =
        RoomRepository(roomDao)

    @Provides
    fun provideTeacherDao(db: AppDatabase): TeacherDao =
        db.teacherDao()

    @Provides
    fun provideTeacherRepository(teacherDao: TeacherDao): TeacherRepository =
        TeacherRepository(teacherDao)

    @Provides
    fun provideSettingsDao(db: AppDatabase): SettingsDao =
        db.settingsDao()

    @Provides
    fun provideSettingsRepository(settingsDao: SettingsDao): SettingsRepository =
        SettingsRepository(settingsDao)
}