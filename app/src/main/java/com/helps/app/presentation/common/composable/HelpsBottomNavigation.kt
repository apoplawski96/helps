package com.helps.app.presentation.common.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsPadding
import com.helps.app.presentation.HelpsBottomNavTab
import com.helps.app.presentation.common.theme.HelpsTheme
import com.helps.navigation.Navigator
import com.helps.navigation.model.navigationDestinationOf

@ExperimentalAnimationApi
@Composable
fun HelpsBottomNavigation(
    navController: NavController,
    navigator: Navigator
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""
    val bottomNavRoutesList = HelpsBottomNavTab.getRoutesList()
    val bottomNavEnabled = currentRoute in bottomNavRoutesList

    AnimatedVisibility(visible = bottomNavEnabled) {
        HelpsBottomNavigationContent(
            onBottomNavClicked = {
                navigator.navigate(navigationDestinationOf(it.route))
            },
            currentRoute = currentRoute
        )
    }
}

@Composable
private fun HelpsBottomNavigationContent(
    onBottomNavClicked: (HelpsBottomNavTab) -> Unit,
    currentRoute: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color.Transparent)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.7.dp)
                .background(HelpsTheme.colors.secondaryVariant2)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp)
                .background(HelpsTheme.colors.secondary)
                .navigationBarsPadding()
        ) {
            HelpsBottomNavTab.values().forEach { bottomNavTab ->
                val currentItemRoutesList = bottomNavTab.destinationScreens.map { it.route }
                val isSelected = currentRoute in currentItemRoutesList

                HelpsBottomNavItem(
                    icon = bottomNavTab.icon,
                    scale = if (isSelected) 1.5f else 1.0f,
                    color = if (isSelected) HelpsTheme.colors.primaryVariant else HelpsTheme.colors.primary,
                    label = bottomNavTab.label,
                    onClick = {
                        if (isSelected) {
                            return@HelpsBottomNavItem
                        } else {
                            onBottomNavClicked(bottomNavTab)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun HelpsBottomNavItem(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    label: String,
    scale: Float = 1f,
    color: Color = HelpsTheme.colors.secondary,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedBottomNavIcon(
            icon = icon,
            modifier = modifier,
            scale = scale,
            color = color,
            onClick = onClick
        )
//        HelpsText(text = label, color = color, size = 12.sp)
    }
}

@Composable
private fun AnimatedBottomNavIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    scale: Float = 1f,
    color: Color = HelpsTheme.colors.secondary,
    onClick: () -> Unit
) {
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = TweenSpec(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        )
    )
    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = TweenSpec(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        )
    )

    IconButton(
        onClick = onClick,
        modifier = modifier.height(200.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = animatedColor,
            modifier = modifier.scale(animatedScale)
        )
    }
}