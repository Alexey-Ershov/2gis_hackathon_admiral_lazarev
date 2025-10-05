package com.larkes.neurobuildermultiplatform.ui.models

data class BuilderUiModel(
    val imageSrc: String,
    val rating: Float,
    val isFavorite: Boolean,
    val title: String,
    val subtitle: String,
    val recommendedFrom: String? = null
)