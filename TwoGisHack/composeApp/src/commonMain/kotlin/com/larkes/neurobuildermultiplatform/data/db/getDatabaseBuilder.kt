package com.larkes.neurobuildermultiplatform.data.db

import androidx.room.RoomDatabase
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration

expect fun getDatabaseBuilder(platformConfiguration: PlatformConfiguration): RoomDatabase.Builder<AppDatabase>