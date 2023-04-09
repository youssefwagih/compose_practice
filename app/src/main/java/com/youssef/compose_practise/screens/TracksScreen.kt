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
fun TrackScreen (){
    Column(modifier = Modifier.fillMaxSize()) {
        
        TGFilterChips()
        Spacer(modifier = Modifier.size(10.dp))
        Tracks()
    }
}

@Preview
@Composable
fun Tracks() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(com.youssef.compose_practise.data.Tracks.TRACKS.size) {
            TrackItem(com.youssef.compose_practise.data.Tracks.TRACKS[it])
        }
    }
}

@Composable
fun TrackItem(trackEntity: TrackEntity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.profilepicture),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = trackEntity.title)
                Text(text = trackEntity.description)
            }
        }
        Icon(
            Icons.Filled.PlayArrow,
            contentDescription = ""
        )
    }
}

@Composable
fun TGFilterChips() {
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
fun TGFilterChip(filter: String, selected: Boolean = false) {
    FilterChip(shape = RoundedCornerShape(8.dp), onClick = {}, selected = selected) {
        Text(filter)
    }
}