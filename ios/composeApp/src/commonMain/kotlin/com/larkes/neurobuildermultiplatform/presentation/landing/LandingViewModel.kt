package com.larkes.neurobuildermultiplatform.presentation.landing

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.larkes.neurobuildermultiplatform.ui.models.BuilderUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//private fun createMapOptions(): MapOptions {
//    // Position for testing controls such as Indoor и Compass.
//    val cameraPosition = CameraPosition(
//        point = GeoPoint(
//            latitude = 55.760898,
//            longitude = 37.620242
//        ),
//        bearing = Bearing(20.0),
//        zoom = Zoom(17f)
//    )
//
//    return MapOptions().apply {
//        position = cameraPosition
//    }
//}


class LandingViewModel: ViewModel() {

    private val _uiState: MutableStateFlow<LandingUIState> = MutableStateFlow(LandingUIState())
    val uiState: StateFlow<LandingUIState> = _uiState

    init {

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isPopularBuildersLoading = true, isCompaniesChoosedLoading = true)
            delay(1500)
            _uiState.value = _uiState.value.copy(isPopularBuildersLoading = false, popularBuilders = (0..8).map { BuilderUiModel(
                title = "Пик",
                imageSrc = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc9APxkj0xClmrU3PpMZglHQkx446nQPG6lA&s",
                rating = 4.5f,
                isFavorite = false,
                subtitle = "8 лет на рынке   54 жк"
            ) })
            delay(500)
            _uiState.value = _uiState.value.copy(isCompaniesChoosedLoading = false, companiesChoosed = (0..8).map { BuilderUiModel(
                title = "Пик",
                imageSrc = "https://enjoyenglish-blog.com/wp-content/uploads/2017/07/%D0%A1%D0%BB%D0%BE%D0%B2%D0%B0-%D0%B8-%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D1%81%D0%BE-%D1%81%D0%BB%D0%BE%D0%B2%D0%BE%D0%BC-%C2%AB%D0%B4%D0%BE%D0%BC%C2%BB.jpg",
                rating = 4.5f,
                isFavorite = false,
                subtitle = "8 лет на рынке   54 жк",
                recommendedFrom = "от Setl Group"
            ) })
        }
    }

    fun onEvent(event: LandingUIEvent){
        when(event){
            is LandingUIEvent.SearchTextEntered -> {
                _uiState.value = _uiState.value.copy(searchText = event.text)
            }
        }
    }


}