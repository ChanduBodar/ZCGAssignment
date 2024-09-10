package com.zcgapplication.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.zcgapplication.model.Item

@Composable
fun SplitBannerType(itemList: ArrayList<Item>) {
    Box(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            content = {
                items(itemList.size) {
                    val item = itemList[it]
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .heightIn(280.dp)
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(item.image),
                            contentDescription = item.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(240.dp)
                        )
                        Text(
                            modifier = Modifier
                                .padding(4.dp)
                                .background(Color.Transparent),
                            text = item.title,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            })
    }
}
