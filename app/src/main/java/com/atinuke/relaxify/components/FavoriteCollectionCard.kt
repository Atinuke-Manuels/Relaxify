package com.atinuke.relaxify.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.atinuke.relaxify.R

data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)



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
