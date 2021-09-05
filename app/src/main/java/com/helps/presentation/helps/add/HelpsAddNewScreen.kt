package com.helps.presentation.helps.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MyLocation
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.helps.presentation.common.composable.*
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.helps.HelpsHeader

@Composable
fun HelpsAddNewScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(
            navController = navController,
            topBarMode = TopBarMode.WITH_BACK_NAVIGATION
        ) {
            HelpsAddNewScreenContent()
        }
    }
}

@Composable
private fun HelpsAddNewScreenContent() {
    var messageText by remember { mutableStateOf("") }
    var hashtagsText by remember { mutableStateOf("") }

    Column() {
        HelpsHeader(headerText = "Add new Helps")
        Spacer(modifier = Modifier.height(8.dp))
        HelpsTextFieldRoundedBox(
            text = messageText,
            placeholderText = "I'm moving and I need some to help me handle all of the heavy objects. I offer money and a smile!",
            labelText = "Description",
            height = 256.dp,
            onTextChanged = { messageText = it }
        )
        Spacer(modifier = Modifier.height(24.dp))
        HelpsTextFieldRoundedBox(
            text = hashtagsText,
            placeholderText = "#hashtag1 #hashtag2",
            labelText = "Hashtags",
            height = 128.dp,
            onTextChanged = { hashtagsText = it }
        )
        Spacer(modifier = Modifier.height(24.dp))
        HelpsAddOptionsBar()
        Spacer(modifier = Modifier.height(24.dp))
        HelpsButtonSecondary(label = "Send") {

        }
    }
}

@Composable
private fun HelpsAddOptionsBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .background(HelpsTheme.colors.primaryVariant)
    ) {
        HelpsAddOption(label = "Location", icon = Icons.Outlined.MyLocation, size = 60.dp) {

        }
        HelpsAddOption(label = "Photo", icon = Icons.Outlined.PhotoCamera, size = 60.dp) {

        }
    }
}

@Composable
private fun HelpsAddOption(label: String, icon: ImageVector, size: Dp, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = onClick, modifier = Modifier.size(size)) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = HelpsTheme.colors.secondary,
                    modifier = Modifier.size(size)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            HelpsText(text = label, size = 12.sp, fontWeight = FontWeight.Medium)
        }
    }
}
