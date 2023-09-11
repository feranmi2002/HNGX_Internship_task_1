package com.faithdeveloper.slackidentityhngxinternshiptask1

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun GithubScreen() {

    var loadState: LOAD_STATE by rememberSaveable {
        mutableStateOf(LOAD_STATE.LOADING)
    }

    val url = "https://www.github.com/feranmi2002"

    val context = LocalContext.current

    class MyWebViewClient : WebViewClient() {

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            loadState = LOAD_STATE.LOADED
        }
    }


    val webView = WebView(context)

    webView.layoutParams = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )

    webView.webViewClient = MyWebViewClient()

    if (loadState != LOAD_STATE.LOADED) {
        webView.loadUrl(url)
    }

    when (loadState) {
        LOAD_STATE.LOADING -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        LOAD_STATE.LOADED -> {
            AndroidView(factory = {
                webView
            }, update = {
                it.loadUrl(url)
            })
        }
    }
}

enum class LOAD_STATE {
    LOADING,
    LOADED
}