package com.larkes.neurobuildermultiplatform.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val text: String
)