package com.larkes.neurobuildermultiplatform.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf

object StringResource {
    const val APP_NAME = "Проверь.дом"
    const val LANDING_TITLE = "Проверьте репутацию застройщика"
    const val LANDING_ADD_TITLE = "за 2 минуты"
    const val LANDING_SUB_TITLE = "Все отзывы в одном месте. \n" +
            "AI-анализ надежности"

    const val TEXT_FILED_SEARCH_HINT = "Название застройщика или ЖК"
    const val POPULAR_TITLE = "Популярные застройщики"

    const val ALL_TEXT = "Все"
    const val CHOOSED_BUILDINGS = "ЖК, которые часто выбирают"
    const val BUILDING_ON_MAP = "ЖК на карте"

}

val LocalStringProvider = staticCompositionLocalOf<StringResource> {
    error("")
}