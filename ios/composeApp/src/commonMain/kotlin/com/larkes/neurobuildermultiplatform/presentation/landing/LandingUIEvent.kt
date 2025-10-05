package com.larkes.neurobuildermultiplatform.presentation.landing


sealed class LandingUIEvent {

    data class SearchTextEntered(val text: String): LandingUIEvent()

}