package com.larkes.neurobuildermultiplatform.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.larkes.neurobuildermultiplatform.data.db.entities.TestEntity

@Dao
interface TestDao {

    @Insert
    suspend fun insert(item: TestEntity)
    @Query("SELECT * FROM TestEntity")
    suspend fun get(): List<TestEntity>

}