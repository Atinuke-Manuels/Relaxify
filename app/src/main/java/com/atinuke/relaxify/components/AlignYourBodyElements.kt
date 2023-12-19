package com.atinuke.relaxify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.atinuke.relaxify.R


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

val alignYourBodyData = listOf(
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



