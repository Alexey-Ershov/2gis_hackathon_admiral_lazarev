package com.larkes.neurobuildermultiplatform.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class NeuroBuilderColors(
    val landingLinearFirst: Color,
    val landingLinearSecond: Color,
    val title: Color,
    val secondTextColor: Color,
    val secondTitle: Color,
    val formStrokeColor: Color,
    val starColor: Color,
    val secondPrimary: Color,
)

val palette = NeuroBuilderColors(
    landingLinearFirst = Color(0xff0F6DDC),
    landingLinearSecond = Color(0xff3D95FD),
    title = Color(0xffffffff),
    secondTextColor = Color(0xff858585),
    secondTitle = Color(0xff000000),
    formStrokeColor = Color(0xffD2D2D2),
    starColor = Color(0xffFFE299),
    secondPrimary = Color(0xffEA8D0B)
)

val LocalColorProvider = staticCompositionLocalOf<NeuroBuilderColors> {
    error("")
}