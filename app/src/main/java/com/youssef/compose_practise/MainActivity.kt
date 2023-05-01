package com.youssef.compose_practise

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
                MainScreenView()
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreenView() {
        Column(modifier = Modifier.fillMaxHeight()) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    ),
                label = { Text("Input") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Yellow,
                    backgroundColor = Blue
                ),
            )
        }
/*        OutlinedTextField(
            value = null,
            onValueChange = {},
            label = {},
            textStyle = TextStyle(fontSize = 18.sp),
            Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .background(
                    color = SnackbarDefaults.backgroundColor
                )
        )*/
/*        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavigation(navController = navController) }
        ) {
            NavigationGraph(navController = navController)
        }*/
    }

    @Composable
    fun BottomNavigation(navController: NavController) {
        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.Search,
            BottomNavItem.Library
        )
        BottomNavigation(
            backgroundColor = Color.Black.copy(0.4f),
            contentColor = Color.White
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 9.sp
                        )
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.screen_route,
                    onClick = {
                        navController.navigate(item.screen_route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
        object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
        object Search : BottomNavItem("Search", R.drawable.ic_my_network, "my_network")
        object Library : BottomNavItem("Library", R.drawable.ic_post, "add_post")
    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
            composable(BottomNavItem.Home.screen_route) {
                TrackScreen()
            }
            composable(BottomNavItem.Search.screen_route) {
                PlaylistScreen()
            }
            composable(BottomNavItem.Library.screen_route) {
                Text(
                    text = "TG Radio app",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp)
                )
            }
        }
    }
}