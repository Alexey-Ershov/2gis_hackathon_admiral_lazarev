package com.larkes.neurobuildermultiplatform.domain.repository

import com.larkes.neurobuildermultiplatform.data.db.entities.TestEntity

interface TestRepository {

    suspend fun saveData(testEntity: TestEntity)
    suspend fun getData(): List<TestEntity>

}