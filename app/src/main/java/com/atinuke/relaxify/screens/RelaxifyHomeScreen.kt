package com.atinuke.relaxify.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.atinuke.relaxify.R
import com.atinuke.relaxify.components.AlignYourBodyRow
import com.atinuke.relaxify.components.FavoriteCollectionsGrid
import com.atinuke.relaxify.components.HomeScreen
import com.atinuke.relaxify.components.RelaxifySearchBar
import com.atinuke.relaxify.ui.theme.RelaxifyTheme

@Composable
fun RelaxifyHomeScreen(modifier: Modifier = Modifier){
    RelaxifyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(ContextCompat.getColor(LocalContext.current, R.color.light_blue))
        ) {
            Column(
                modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(Modifier.height(16.dp))
                RelaxifySearchBar(Modifier.padding(horizontal = 16.dp))
                HomeScreen(R.string.title) {
                    AlignYourBodyRow()
                }
                HomeScreen(R.string.title2) {
                    FavoriteCollectionsGrid()
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}