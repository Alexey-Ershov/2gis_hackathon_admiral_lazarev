package com.larkes.neurobuildermultiplatform.domain.models

data class BuilderDetail(
    val trustIndex: Int,
    val imageSrc: String,
    val title: String,
    val fromYear: Int,
    val complimentPeople: List<String>,
    val peopleNote: List<String>,
    val description: String
)

