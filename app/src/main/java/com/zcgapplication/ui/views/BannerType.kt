package com.zcgapplication.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.zcgapplication.model.Item

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerType(itemList: ArrayList<Item>) {
    Box(
        modifier = Modifier
            .height(240.dp)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val pagerState = rememberPagerState(pageCount = {
            itemList.size
        })
        HorizontalPager(state = pagerState) { page ->
            // Our page content
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(itemList[page].image),
                    contentDescription = itemList[page].title,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}
