package com.faithdeveloper.slackidentityhngxinternshiptask1

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun GithubScreen() {
    val url = "https://www.github.com/feranmi2002"
    val context = LocalContext.current
    val webView = WebView(context)
    webView.layoutParams = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
    webView.webViewClient = WebViewClient()
    webView.loadUrl(url)
    AndroidView(factory = {
        webView
    }, update = {
        it.loadUrl(url)
    })

}