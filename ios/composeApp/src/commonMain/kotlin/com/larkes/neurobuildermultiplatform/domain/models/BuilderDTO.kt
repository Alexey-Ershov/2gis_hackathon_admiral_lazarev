package com.larkes.neurobuildermultiplatform.domain.models

import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class BuilderDTO(
    val description: String // вложенный JSON как строка
)

@kotlinx.serialization.Serializable
data class DeveloperDescription(
    val title: String,
    val image: String,
    val heading1: String,
    val listPositives: List<String>,
    val markedList: List<String>,
    val info: List<InfoItem>,
    val developer: String
)

@Serializable
data class InfoItem(
    val heading: String,
    val description: String
)
