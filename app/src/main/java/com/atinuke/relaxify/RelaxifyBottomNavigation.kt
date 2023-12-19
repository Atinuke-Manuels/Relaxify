package com.atinuke.relaxify

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat

@Composable
fun RelaxifyBottomNavigation( modifier: Modifier = Modifier){
    NavigationBar(
        containerColor = Color(ContextCompat.getColor(LocalContext.current, R.color.white)),
        modifier = modifier
    ){
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
//                    tint = Color.White
                )
            },
            label = {
                Text(text = stringResource(R.string.home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
//                    tint = Color.White
                )
            },
            label = {
                Text(text = stringResource(R.string.profile))
            },
            selected = true,
            onClick = {}
        )
    }
}