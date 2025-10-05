package com.larkes.neurobuildermultiplatform.domain.models

data class ReviewBlock(
    val rating: Float,
    val reviewsCount: Int,
    val reviews: List<Review>
)

data class Review(
    val name: String,
    val imageSrc: String,
    val grade: Int,
    val date: String,
    val reviewsCount: Int,
    val text: String
)