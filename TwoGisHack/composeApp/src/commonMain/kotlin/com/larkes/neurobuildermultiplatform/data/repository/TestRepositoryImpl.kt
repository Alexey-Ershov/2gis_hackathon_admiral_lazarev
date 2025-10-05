package com.larkes.neurobuildermultiplatform.data.repository

import com.larkes.neurobuildermultiplatform.data.db.dao.TestDao
import com.larkes.neurobuildermultiplatform.data.db.entities.TestEntity
import com.larkes.neurobuildermultiplatform.data.network.models.RequestDto
import com.larkes.neurobuildermultiplatform.data.network.source.TestNetworkDataSource
import com.larkes.neurobuildermultiplatform.domain.repository.TestRepository
import kotlin.uuid.Uuid

class TestRepositoryImpl(
    private val testNetworkDataSource: TestNetworkDataSource,
    private val testDao: TestDao
): TestRepository {
    override suspend fun saveData(testEntity: TestEntity) {
      //  testNetworkDataSource.testGetRequest()
        testDao.insert(testEntity)
    }

    override suspend fun getData(): List<TestEntity> {
        return testDao.get()
    }
}