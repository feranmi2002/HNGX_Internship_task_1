package com.faithdeveloper.slackidentityhngxinternshiptask1

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.delay

@Composable
fun GithubScreen() {

    var progress by remember {
        mutableIntStateOf(0)
    }

    val url = "https://www.github.com/feranmi2002"

    val context = LocalContext.current

    val webView = WebView(context)

    webView.layoutParams = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )

    webView.webViewClient = WebViewClient()

    webView.loadUrl(url)

    LaunchedEffect(key1 = progress) {
        while (progress < 100) {
            delay(1000)
            progress = webView.progress
        }
    }

    if (progress < 100) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }else{
        AndroidView(factory = {
            webView
        }, update = {
            it.loadUrl(url)
        })
    }


}