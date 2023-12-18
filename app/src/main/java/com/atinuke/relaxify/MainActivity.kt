package com.atinuke.relaxify

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.atinuke.relaxify.ui.theme.RelaxifyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var windowSizeClass = calculateWindowSizeClass(this)
            RelaxifyApp(windowSizeClass)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar( modifier: Modifier = Modifier ){
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun HomeScreen(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
){
    Column (modifier){
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        )
        content()
    }
}

@Composable
fun AlignYourBodyElements(
    item: DrawableStringPair,
    modifier: Modifier = Modifier
)
{
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .padding(8.dp)
    ){
    Image(painter = painterResource(item.drawable),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(88.dp)
            .clip(CircleShape)
        )
    Text(text = stringResource(item.text),
        modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
        style = MaterialTheme.typography.bodyMedium
        )
}
}

private val alignYourBodyData = listOf(
    R.drawable.img1 to R.string.img1,
    R.drawable.img2 to R.string.img2,
    R.drawable.img3 to R.string.img3,
    R.drawable.image2 to R.string.image2,
    R.drawable.image3 to R.string.backTwist,
    R.drawable.images4 to R.string.spineAlign,
    R.drawable.push1 to R.string.push1,
    R.drawable.squatimg to R.string.squat,
    R.drawable.weightlift to R.string.WeightLift,
    R.drawable.fullpushup to R.string.fullPushUp,
    R.drawable.legup to R.string.legUp,
    R.drawable.family1 to R.string.motherAndChild
).map { DrawableStringPair(it.first, it.second) }


data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(alignYourBodyData){ item ->
            AlignYourBodyElements(item)
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    item: DrawableStringPair,
    modifier: Modifier = Modifier
)
    {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ){
            Image(painter = painterResource(item.drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
                )
            Text(text = stringResource(item.text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
                )
        }
    }

}

private val favoriteCollectionsData = listOf(
    R.drawable.squatimg to R.string.squat,
    R.drawable.weightlift to R.string.WeightLift,
    R.drawable.fullpushup to R.string.fullPushUp,
    R.drawable.legup to R.string.legUp,
    R.drawable.family1 to R.string.motherAndChild,
    R.drawable.images4 to R.string.spineAlign,
    R.drawable.img1 to R.string.img1,
    R.drawable.img2 to R.string.img2,
    R.drawable.img3 to R.string.img3,
    R.drawable.image2 to R.string.image2,
    R.drawable.image3 to R.string.backTwist,
    R.drawable.squatimg to R.string.squat,
).map { DrawableStringPair(it.first, it.second) }

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(8 .dp),
        rows = GridCells.Fixed(4),
        modifier = modifier.height(440.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item, Modifier.height(120.dp))
        }
    }
}

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
                SearchBar(Modifier.padding(horizontal = 16.dp))
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

@Composable
private fun RelaxifyBottomNavigation( modifier: Modifier = Modifier){
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelaxifyAppPotrait(){
    RelaxifyTheme {
        Scaffold(
            bottomBar = {RelaxifyBottomNavigation()}
        ) {padding -> RelaxifyHomeScreen(Modifier.padding(padding))

        }
    }
}

@Composable
fun RelaxifyNavigationRail(modifier: Modifier = Modifier){
    NavigationRail (
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ){
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
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
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
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
}

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
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