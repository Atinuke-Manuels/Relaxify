package com.atinuke.relaxify.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.atinuke.relaxify.RelaxifyBottomNavigation
import com.atinuke.relaxify.RelaxifyNavigationRail
import com.atinuke.relaxify.screens.RelaxifyHomeScreen
import com.atinuke.relaxify.ui.theme.RelaxifyTheme

@Composable
fun RelaxifyAppPotrait(){
    RelaxifyTheme {
        Scaffold(
            bottomBar = { RelaxifyBottomNavigation() }
        ) {padding -> RelaxifyHomeScreen(Modifier.padding(padding))

        }
    }
}

@Composable
fun RelaxifyAppLandscape() {
    RelaxifyTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                RelaxifyNavigationRail()
                RelaxifyHomeScreen()
            }
        }
    }
}