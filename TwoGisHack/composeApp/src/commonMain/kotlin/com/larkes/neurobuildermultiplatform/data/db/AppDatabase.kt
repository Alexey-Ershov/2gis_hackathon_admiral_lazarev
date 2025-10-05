package com.larkes.neurobuildermultiplatform.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.larkes.neurobuildermultiplatform.data.db.dao.TestDao
import com.larkes.neurobuildermultiplatform.data.db.entities.TestEntity

@Database(entities = [TestEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getTestDao(): TestDao
}