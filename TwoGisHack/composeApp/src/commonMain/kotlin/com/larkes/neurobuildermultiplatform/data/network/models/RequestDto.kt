package com.larkes.neurobuildermultiplatform.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestDto(
    val name: String,
    val job: String
)