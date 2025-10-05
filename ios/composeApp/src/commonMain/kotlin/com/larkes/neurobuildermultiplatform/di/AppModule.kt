package com.larkes.neurobuildermultiplatform.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.larkes.neurobuildermultiplatform.data.db.AppDatabase
import com.larkes.neurobuildermultiplatform.data.db.dao.TestDao
import com.larkes.neurobuildermultiplatform.data.db.getDatabaseBuilder
import com.larkes.neurobuildermultiplatform.data.network.HttpEngineFactory
import com.larkes.neurobuildermultiplatform.data.network.source.TestNetworkDataSource
import com.larkes.neurobuildermultiplatform.data.repository.TestRepositoryImpl
import com.larkes.neurobuildermultiplatform.domain.repository.TestRepository
import com.larkes.neurobuildermultiplatform.presentation.builder_detail.BuilderDetailViewModel
import com.larkes.neurobuildermultiplatform.presentation.landing.LandingViewModel
import com.larkes.neurobuildermultiplatform.presentation.test.TestViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module{
//    single<AppDatabase> {
//
//        val appContext: Context = get()
//        val dbFile = appContext.getDatabasePath("my_room.db")
//
//        val builder = Room.databaseBuilder<AppDatabase>(
//            context = appContext,
//            name = dbFile.absolutePath
//        )
//        builder
//            .setDriver(BundledSQLiteDriver())
//            .setQueryCoroutineContext(Dispatchers.IO)
//            .build()
//    }

    single<AppDatabase> {
        val builder = getDatabaseBuilder(get())
        builder
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    factory {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 159000
                requestTimeoutMillis = 500000
            }
        }
    }

    factory<TestDao> {
        val database: AppDatabase = get()
        database.getTestDao()
    }
    factory {
        TestNetworkDataSource(get())
    }

    factory<TestRepository> {
        TestRepositoryImpl(get(), get())
    }

    factory {
        TestViewModel(get())
    }

    factory {
        LandingViewModel()
    }
    factory {
        BuilderDetailViewModel(get())
    }



}