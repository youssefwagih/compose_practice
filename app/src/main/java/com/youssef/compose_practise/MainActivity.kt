package com.youssef.compose_practise

import android.os.Bundle
import android.widget.ImageView.ScaleType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssef.compose_practise.models.TrackEntity
import com.youssef.compose_practise.ui.theme.Compose_practiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tracks = listOf(
        TrackEntity("track 2", "artist 2"),
        TrackEntity("track 3", "artist 3"),
        TrackEntity("track 5", "artist 4"),
        TrackEntity("track 2", "artist 2"),
        TrackEntity("track 3", "artist 3"),
        TrackEntity("track 5", "artist 4"),
        TrackEntity("track 2", "artist 2"),
        TrackEntity("track 3", "artist 3"),
        TrackEntity("track 5", "artist 4"),
        TrackEntity("track 2", "artist 2"),
        TrackEntity("track 3", "artist 3"),
        TrackEntity("track 5", "artist 4")
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            Compose_practiseTheme {
                Tracks()
            }
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
            items(tracks.size) {
                TrackItem(tracks[it])
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
            Row(modifier = Modifier.padding(top = 5.dp)) {
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
}