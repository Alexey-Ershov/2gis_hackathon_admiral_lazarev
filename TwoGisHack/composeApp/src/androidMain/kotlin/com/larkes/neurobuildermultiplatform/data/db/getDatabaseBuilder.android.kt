package com.larkes.neurobuildermultiplatform.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration

actual fun getDatabaseBuilder(platformConfiguration: PlatformConfiguration): RoomDatabase.Builder<AppDatabase> {
    val appContext = platformConfiguration.context
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}