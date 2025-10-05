package com.larkes.neurobuildermultiplatform.ui.components

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.larkes.neurobuildermultiplatform.R
import com.larkes.neurobuildermultiplatform.TwoGisContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import ru.dgis.sdk.DGis
import ru.dgis.sdk.compose.map.MapComposable
import ru.dgis.sdk.compose.map.MapComposableState
import ru.dgis.sdk.map.Map
import ru.dgis.sdk.platform.LogLevel
import ru.dgis.sdk.platform.LogMessage
import ru.dgis.sdk.platform.LogOptions
import ru.dgis.sdk.platform.LogSink

import ru.dgis.sdk.compose.map.controls.CompassComposable
import ru.dgis.sdk.compose.map.controls.IndoorComposable
import ru.dgis.sdk.compose.map.controls.MyLocationComposable
import ru.dgis.sdk.compose.map.controls.TrafficComposable
import ru.dgis.sdk.compose.map.controls.ZoomComposable
import ru.dgis.sdk.coordinates.Bearing
import ru.dgis.sdk.coordinates.GeoPoint
import ru.dgis.sdk.geometry.GeoPointWithElevation
import ru.dgis.sdk.map.CameraPosition
import ru.dgis.sdk.map.Color
import ru.dgis.sdk.map.LogicalPixel
import ru.dgis.sdk.map.MapObjectManager
import ru.dgis.sdk.map.MapOptions
import ru.dgis.sdk.map.Marker
import ru.dgis.sdk.map.MarkerOptions
import ru.dgis.sdk.map.SimpleClusterObject
import ru.dgis.sdk.map.SimpleClusterOptions
import ru.dgis.sdk.map.SimpleClusterRenderer
import ru.dgis.sdk.map.TextStyle
import ru.dgis.sdk.map.Zoom
import ru.dgis.sdk.map.imageFromResource







// Данные метки
data class MarkerData(val id: String, val lat: Double, val lon: Double)

class JSBridge {
    @JavascriptInterface
    fun onMarkerClick(data: String) {
        Log.d("WebView", "Clicked marker: $data")
    }
}
@Composable
actual fun MapComponent(onClick:(String) -> Unit) {
//    AndroidView(
//        modifier = Modifier.fillMaxSize(),
//        factory = { context ->
//            WebView(context).apply {
//                settings.javaScriptEnabled = true
//                settings.domStorageEnabled = true
//                webChromeClient = WebChromeClient()
//                webViewClient = object : WebViewClient() {
//                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                        super.onPageStarted(view, url, favicon)
//                        Log.d("WebView", "🔄 onPageStarted: $url")
//                    }
//
//                    override fun onPageFinished(view: WebView?, url: String?) {
//                        super.onPageFinished(view, url)
//                        Log.d("WebView", "✅ onPageFinished: $url")
//                    }
//
//                    override fun shouldInterceptRequest(
//                        view: WebView?,
//                        request: WebResourceRequest?
//                    ): WebResourceResponse? {
//                        return super.shouldInterceptRequest(view, request)
//                    }
//                    override fun onReceivedError(
//                        view: WebView?,
//                        request: WebResourceRequest?,
//                        error: WebResourceError?
//                    ) {
//                        Log.e(
//                            "WebView", "❌ onReceivedError: ${error?.description} on ${request?.url}"
//                        )
//                    }
//
//                    override fun onReceivedHttpError(
//                        view: WebView?,
//                        request: WebResourceRequest?,
//                        errorResponse: WebResourceResponse?
//                    ) {
//                        Log.e(
//                            "WebView", "⚠️ onReceivedHttpError: ${errorResponse?.statusCode} ${request?.url}"
//                        )
//                    }
//
//                    override fun shouldOverrideUrlLoading(
//                        view: WebView?,
//                        request: WebResourceRequest?
//                    ): Boolean {
//                        val url = request?.url.toString()
//                        Log.d("WebView", "🔗 shouldOverrideUrlLoading: $url")
//                        return false // не перехватываем загрузку — даём WebView обрабатывать
//                    }
//                }
//
//               settings.javaScriptEnabled = true
//             settings.domStorageEnabled = true
//               settings.allowFileAccess = true
//              settings.allowContentAccess = true
//              settings.useWideViewPort = true
//               settings.loadWithOverviewMode = true
//
//                loadUrl("http://172.20.10.3:3000")
//
//
////                addJavascriptInterface(JSBridge(), "AndroidBridge")
////
////
////                val markers = listOf(
////                    MarkerData("m1", 55.75393, 37.620795),
////                    MarkerData("m2", 55.749722, 37.537222)
////                )
////                MapBridge(this).addMarkers(markers)
//            }
//        }
//    )
}


fun mySimpleClusterRenderer(): SimpleClusterRenderer {
    return object : SimpleClusterRenderer {
        override fun renderCluster(cluster: SimpleClusterObject): SimpleClusterOptions {
            return SimpleClusterOptions(
                icon = null,
                iconWidth = LogicalPixel(30f),
                text = cluster.objectCount.toString(),
                textStyle = TextStyle(
                    fontSize = LogicalPixel(15f)
                ),
                userData = null
            )
        }
    }
}


@Composable
fun MapControls(map: Map) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TrafficComposable(map)
        }
        Column(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ZoomComposable(map)
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CompassComposable(map)
            MyLocationComposable(map)
        }
        Column(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IndoorComposable(map)
        }
    }
}
