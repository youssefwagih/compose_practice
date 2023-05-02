package com.youssef.compose_practise

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.youssef.compose_practise.screens.PlaylistScreen
import com.youssef.compose_practise.screens.TrackScreen
import com.youssef.compose_practise.ui.theme.Compose_practiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compose_practiseTheme {
                OutlinedTextField(value = "hello", onValueChange = {})
            }
        }
        reverseString("abcde".toCharArray())
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreenView() {

    }

    private fun reverseString(s: CharArray): Unit {
        for (i in s.indices) {
            val temp = s[i]
            s[i] = s[s.size-1-i]
            s[s.size-1-i] = temp

            if((i+1) >= (s.size)/2) {
                return
            }
        }


    }
}
