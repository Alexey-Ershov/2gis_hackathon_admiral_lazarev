package com.larkes.neurobuildermultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration
import com.larkes.neurobuildermultiplatform.di.PlatformSDK
import com.larkes.neurobuildermultiplatform.ui.App

fun MainViewController() = ComposeUIViewController {
    PlatformSDK.init(PlatformConfiguration())
    App()
}