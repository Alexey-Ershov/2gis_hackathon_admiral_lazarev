package com.larkes.neurobuildermultiplatform

import android.app.Application
import android.content.Context
import com.larkes.neurobuildermultiplatform.di.PlatformConfiguration
import com.larkes.neurobuildermultiplatform.di.PlatformSDK
import ru.dgis.sdk.DGis
import ru.dgis.sdk.platform.LogLevel
import ru.dgis.sdk.platform.LogOptions

class NeuroApplication: Application() {



    override fun onCreate() {
        super.onCreate()
        TwoGisContext.context = initializeDGis(this)
        PlatformSDK.init(PlatformConfiguration(this))
    }

}

fun initializeDGis(appContext: android.content.Context): ru.dgis.sdk.Context {
    return DGis.initialize(
        appContext,
        logOptions = LogOptions(
            customLevel = LogLevel.WARNING,
            customSink = null
        )
    )
}
