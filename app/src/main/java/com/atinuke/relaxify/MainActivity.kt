package com.atinuke.relaxify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.atinuke.relaxify.components.RelaxifyApp
import com.atinuke.relaxify.components.RelaxifyAppLandscape

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            RelaxifyApp(windowSizeClass)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RelaxifyPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(ContextCompat.getColor(LocalContext.current, R.color.light_blue))
    ) {
//        val windowSizeClass = calculateWindowSizeClass(MainActivity())
//        RelaxifyApp(windowSizeClass)
        RelaxifyAppLandscape()
    }
}