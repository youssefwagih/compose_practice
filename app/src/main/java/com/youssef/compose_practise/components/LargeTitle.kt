package com.youssef.compose_practise.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun LargeTitleTextView(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        fontSize = 30.sp,
        color = Color.White


    )
}

@Preview
@Composable
fun ss() {
    MediumTitleTextView("hello")
}


@Composable
fun MediumTitleTextView(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        fontSize = 16.sp,
        color = Color.White


    )
}