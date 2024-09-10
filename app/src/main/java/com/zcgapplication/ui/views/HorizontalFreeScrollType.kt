package com.zcgapplication.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.zcgapplication.model.Item

@Composable
fun HorizontalFreeScrollType(itemList: List<Item>) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        LazyRow {
            items(itemList) {
                Column(
                    modifier = Modifier
                        .height(180.dp)
                        .padding(8.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(it.image),
                        contentDescription = it.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(124.dp)
                            .height(124.dp)

                    )
                    Text(
                        modifier = Modifier
                            .padding(4.dp)
                            .background(Color.Transparent),
                        text = it.title,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                }
            }
        }
    }
}
