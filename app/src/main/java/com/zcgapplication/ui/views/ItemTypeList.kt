package com.zcgapplication.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zcgapplication.ui.views.BannerType
import com.zcgapplication.viewmodel.BlockViewModel

@Composable
fun ItemTypeList(viewModel: BlockViewModel) {
    val blocks by viewModel.blocks.collectAsState()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {

        items(blocks) { block ->
            if (block.sectionType == "banner") {
                BannerType(block.items)
            } else if (block.sectionType == "horizontalFreeScroll") {
                HorizontalFreeScrollType(block.items)
            } else if (block.sectionType == "splitBanner") {
                SplitBannerType(block.items)
            }
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
    DisposableEffect(Unit) {
        viewModel.getBlocks()
        onDispose {}
    }
}