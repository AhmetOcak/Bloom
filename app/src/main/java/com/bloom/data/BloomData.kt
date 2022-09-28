package com.bloom.data

import androidx.annotation.DrawableRes
import com.bloom.R
import com.bloom.data.models.GardenItem
import com.bloom.data.models.ThemeItem
import com.bloom.utils.NavRoutes

object BloomData {
    val themeData = listOf(
        ThemeItem(R.drawable.pexels_quang_nguyen_vinh_2132227, "Desert chic"),
        ThemeItem(R.drawable.pexels_katarzyna_modrzejewska_1400375, "Tiny terrariums"),
        ThemeItem(R.drawable.pexels_volkan_vardar_5699665, "Jungle vibes"),
        ThemeItem(R.drawable.pexels_vladimir_gladkov_6208086, "Easy care"),
        ThemeItem(R.drawable.pexels_sid_maia_3511755, "Statements")
    )

    val gardenData = listOf<GardenItem>(
        GardenItem(R.drawable.pexels_huy_phan_3097770, "Monstera"),
        GardenItem(R.drawable.pexels_karolina_grabowska_4751978, "Aglaonema"),
        GardenItem(R.drawable.pexels_melvin_vito_4425201, "Peace lily"),
        GardenItem(R.drawable.pexels_vladimir_gladkov_6208087, "Fiddle leaf"),
        GardenItem(R.drawable.pexels_fabian_stroobants_2123482, "Snake plant"),
        GardenItem(R.drawable.pexels_faraz_ahmad_1084199, "Pothos"),
    )

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Profile,
        BottomNavItem.Cart
    )

    sealed class BottomNavItem(
        val route: String,
        val labelText: String,
        @DrawableRes val icon: Int
    ) {
        object Home : BottomNavItem(
            route = NavRoutes.homeScreen,
            labelText = "Home",
            icon = R.drawable.ic_baseline_home
        )

        object Favorites : BottomNavItem(
            route = NavRoutes.favoritesScreen,
            labelText = "Favorites",
            icon = R.drawable.ic_baseline_favorite_border
        )

        object Profile : BottomNavItem(
            route = NavRoutes.profileScreen,
            labelText = "Profile",
            icon = R.drawable.ic_baseline_account_circle
        )

        object Cart : BottomNavItem(
            route = NavRoutes.cartScreen,
            labelText = "Cart",
            icon = R.drawable.ic_baseline_shopping_cart
        )
    }
}