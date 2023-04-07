package com.youssef.compose_practise.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssef.compose_practise.models.TrackEntity
import com.youssef.compose_practise.R

@Composable
fun PlaylistScreen (){
    Column(modifier = Modifier.fillMaxSize()) {
        TGFilterChips()
        Spacer(modifier = Modifier.size(10.dp))
        Tracks()
    }
}



@Composable
fun TGPlayListFilterChips() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(com.youssef.compose_practise.data.Tracks.TGFilters.size) {
            TGFilterChip(com.youssef.compose_practise.data.Tracks.TGFilters[it])
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TGPlayListFilterChip(filter: String, selected: Boolean = false) {
    FilterChip(shape = RoundedCornerShape(8.dp), onClick = {}, selected = selected) {
        Text(filter)
    }
}