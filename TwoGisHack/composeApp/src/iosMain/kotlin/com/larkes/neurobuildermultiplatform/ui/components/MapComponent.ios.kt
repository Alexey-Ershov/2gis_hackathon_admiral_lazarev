package com.larkes.neurobuildermultiplatform.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCSignatureOverride
import kotlinx.cinterop.readValue
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSError
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.UIKit.UIColor
import platform.UIKit.UIView
import platform.WebKit.WKNavigation
import platform.WebKit.WKNavigationDelegateProtocol
import platform.WebKit.WKWebView
import platform.WebKit.WKWebViewConfiguration
import platform.darwin.NSObject
import platform.WebKit.WKScriptMessage
import platform.WebKit.WKUserContentController
import platform.WebKit.WKScriptMessageHandlerProtocol

class LoggingNavigationDelegate : NSObject(), WKNavigationDelegateProtocol {

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFailNavigation: WKNavigation?,
        withError: NSError
    ) {
        println("❌ Navigation failed: ${withError.localizedDescription}")
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFailProvisionalNavigation: WKNavigation?,
        withError: NSError
    ) {
        println("❌ Provisional navigation failed: ${withError.localizedDescription}")
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFinishNavigation: WKNavigation?
    ) {
        println("✅ Finished navigation to: ${webView.URL?.absoluteString}")
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didStartProvisionalNavigation: WKNavigation?
    ) {
        println("ℹ️ Started loading: ${webView.URL?.absoluteString}")
    }
}



@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun MapComponent(onClick:(String) -> Unit) {


    class MarkerClickHandler : NSObject(), WKScriptMessageHandlerProtocol {
        override fun userContentController(
            userContentController: WKUserContentController,
            didReceiveScriptMessage: WKScriptMessage
        ) {
            val body = didReceiveScriptMessage.body as? Map<*, *> ?: return

            val lat = body["lat"] as? Double ?: return
            val lng = body["lng"] as? Double ?: return
            val title = body["title"] as? String ?: "Без названия"

            onClick(title)
        }
    }

    UIKitView(
        factory = {
            val config = WKWebViewConfiguration()
            val contentController = WKUserContentController()
            contentController.addScriptMessageHandler(
                scriptMessageHandler = MarkerClickHandler(),
                name = "markerClick"
            )
            config.userContentController = contentController
            val webView = WKWebView(frame = CGRectZero.readValue(), configuration = config)

            val delegate = object : NSObject(), WKNavigationDelegateProtocol {
                override fun webView(webView: WKWebView, didFinishNavigation: WKNavigation?) {
                    // ✅ Вызываем JS только после полной загрузки страницы


//                    webView.evaluateJavaScript("window.updateMarkers($json);") { result, error ->
//                        if (error != null) {
//                            println("JS Error: ${error.localizedDescription}")
//                        } else {
//                            println("✅ JS executed")
//                        }
//                    }
                }
            }

            webView.navigationDelegate = delegate

            val nsUrl = NSURL.URLWithString("http://localhost:3000/")
            val request = NSURLRequest.requestWithURL(nsUrl!!)
            webView.loadRequest(request)

            webView
        },
        modifier = Modifier.fillMaxSize()
    )
}

data class Marker(val lat: Double, val lng: Double, val title: String)

@Composable
fun UIViewContainer(
    viewFactory: () -> UIView
) {
    UIKitView(factory = viewFactory)
}