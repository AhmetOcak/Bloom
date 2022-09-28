package com.bloom.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bloom.components.CustomScaffold
import com.bloom.data.BloomData
import com.bloom.screens.HomeScreen
import com.bloom.screens.LoginScreen
import com.bloom.screens.WelcomeScreen

@Composable
fun NavGraph(startDestination: String = NavScreen.WelcomeScreen.route) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BloomData.items.forEach { navItem ->
                if (navItem.route == currentRoute) {
                    BottomAppBar(
                        elevation = 16.dp,
                        backgroundColor = MaterialTheme.colors.primary
                    ) {
                        BloomData.items.forEach { screen ->
                            BottomNavigationItem(
                                selected = currentRoute == screen.route,
                                onClick = {
                                    if (currentRoute == screen.route) {
                                        return@BottomNavigationItem
                                    }

                                    if (currentRoute != screen.route) {
                                        navController.navigate(screen.route) {
                                            NavScreen.HomeScreen.route.let {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    }
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = screen.icon),
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = screen.labelText,
                                        color = MaterialTheme.colors.onPrimary,
                                        style = MaterialTheme.typography.caption,
                                    )
                                }
                            )
                        }
                    }
                }
            }
        },
        content = {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = startDestination
            ) {
                composable(NavScreen.WelcomeScreen.route) { WelcomeScreen() }
                composable(NavScreen.LoginScreen.route) { LoginScreen() }
                composable(NavScreen.HomeScreen.route) { HomeScreen() }
            }
        }
    )
}