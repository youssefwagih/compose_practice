package com.youssef.compose_practise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssef.compose_practise.ui.theme.Compose_practiseTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @Named("userId")
    lateinit var myString: String

    @Inject
    @Named("userId")
    lateinit var myString2: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("youssef", myString)
        Log.d("youssef2", myString2)


        setContent {
            val title = "this is the title"
            val description = "this is the description in multiline"
            val paint = painterResource(id = R.drawable.ic_launcher_foreground)
            ImageCard(paint, title, description)
        }
    }
}

@Composable
fun ImageCard(paint: Painter, title: String, description: String) {
    Card(shape = RoundedCornerShape(10.dp)) {
        Box(
            Modifier
                .background(Color.Blue)
                .height(200.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(paint, contentDescription = "")
                Text(text = title)
                Text(text = description)
            }
        }
        Box(modifier = Modifier.background(Color.Yellow).height(50.dp))
    }


}