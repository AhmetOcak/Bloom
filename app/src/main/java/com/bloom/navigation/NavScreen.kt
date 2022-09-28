package com.bloom.navigation

import com.bloom.utils.NavRoutes

sealed class NavScreen(val route: String) {
    object WelcomeScreen: NavScreen(NavRoutes.welcomeScreen)
    object LoginScreen: NavScreen(NavRoutes.loginScreen)
    object HomeScreen: NavScreen(NavRoutes.homeScreen)
    object FavoritesScreen: NavScreen(NavRoutes.favoritesScreen)
    object ProfileScreen: NavScreen(NavRoutes.profileScreen)
    object CartScreen: NavScreen(NavRoutes.cartScreen)
}
