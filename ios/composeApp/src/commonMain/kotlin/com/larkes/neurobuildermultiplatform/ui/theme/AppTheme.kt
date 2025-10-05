package com.larkes.neurobuildermultiplatform.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(content:@Composable () -> Unit) {

    CompositionLocalProvider(
        LocalStringProvider provides StringResource,
        LocalColorProvider provides palette,
        content = content
    )

}

object Theme{

    val strings: StringResource
        @Composable
        get() = LocalStringProvider.current

    val colors: NeuroBuilderColors
        @Composable
        get() = LocalColorProvider.current
}