package com.larkes.neurobuildermultiplatform.presentation.landing

import com.larkes.neurobuildermultiplatform.ui.models.BuilderUiModel


data class LandingUIState(
    val popularBuilders: List<BuilderUiModel> = listOf(),
    val companiesChoosed: List<BuilderUiModel> = listOf(),
    val isPopularBuildersLoading: Boolean = false,
    val isCompaniesChoosedLoading: Boolean = false,
    val searchText: String = ""
)