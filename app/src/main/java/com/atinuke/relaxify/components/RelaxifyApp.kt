package com.atinuke.relaxify.components

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Composable
fun RelaxifyApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            RelaxifyAppPotrait()
        }
        WindowWidthSizeClass.Medium -> {
            RelaxifyAppLandscape ()
        }
    }
}