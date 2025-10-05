package com.larkes.neurobuildermultiplatform.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual fun getDatabaseBuilder(platformConfiguration: PlatformConfiguration): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = documentDirectory() + "/theory_net.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}