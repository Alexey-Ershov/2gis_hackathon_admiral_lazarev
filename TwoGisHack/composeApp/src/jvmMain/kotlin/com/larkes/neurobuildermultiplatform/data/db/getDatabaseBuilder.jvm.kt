package com.larkes.neurobuildermultiplatform.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration
import java.io.File

actual fun getDatabaseBuilder(platformConfiguration: PlatformConfiguration): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "theory_net.db")
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}