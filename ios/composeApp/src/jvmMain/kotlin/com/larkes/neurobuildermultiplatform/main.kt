package com.larkes.neurobuildermultiplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration
import com.larkes.neurobuildermultiplatform.di.PlatformSDK
import com.larkes.neurobuildermultiplatform.ui.App

fun main() = application {
    PlatformSDK.init(PlatformConfiguration())
    Window(
        onCloseRequest = ::exitApplication,
        title = "NeuroBuilderMultiplatform",
    ) {
        App()
    }
}