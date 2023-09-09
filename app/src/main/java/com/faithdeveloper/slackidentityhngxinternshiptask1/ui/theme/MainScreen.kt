package com.faithdeveloper.slackidentityhngxinternshiptask1.ui.theme

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faithdeveloper.slackidentityhngxinternshiptask1.R

@Composable
fun MainScreen(onGithubClick:() -> Unit) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Faith Oluwaoyehun", style = MaterialTheme.typography.displaySmall)
            Text(
                text = "Slack Name",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.onBackground, CircleShape),
                bitmap = BitmapFactory.decodeStream(context.resources.openRawResource(R.raw.profile_picture))
                    .asImageBitmap(),
                contentScale = ContentScale.Crop,
                contentDescription = "My profile picture"
            )
            Text(
                text = "Slack Display Picture",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
        }

        Button(onClick = {
            onGithubClick.invoke()
        }) {
            Text(
                modifier = Modifier.wrapContentSize(align = Alignment.Center),
                text = "OPEN GITHUB"
            )
        }
    }
}