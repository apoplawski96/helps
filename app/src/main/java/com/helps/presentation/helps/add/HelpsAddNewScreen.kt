package com.helps.presentation.helps.add

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.Camera
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helps.presentation.common.composable.*
import com.helps.presentation.helps.HelpsHeader

@Composable
fun HelpsAddNewScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {
        HelpsDestinationScaffold() {
            HelpsAddNewScreenContent()
        }
    }
}

@Composable
private fun HelpsAddNewScreenContent() {
    var messageText by remember { mutableStateOf("Type your message") }
    var hashtagsText by remember { mutableStateOf("#hashtag1 #hashtag2") }

    Column() {
        HelpsHeader(headerText = "Add new Helps")
        HelpsTextFieldBoxBig(messageText, 256.dp) { messageText = it }
        Spacer(modifier = Modifier.height(24.dp))
        HelpsTextFieldBoxBig(hashtagsText, 128.dp) { hashtagsText = it }
        Spacer(modifier = Modifier.height(24.dp))
        HelpsAddOptionsBar()
        Spacer(modifier = Modifier.height(24.dp))
        HelpsButtonSecondary(label = "Send") {
            
        }
    }
}

@Composable
private fun HelpsAddOptionsBar() {
    Card(elevation = 10.dp, modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HelpsAddOption(label = "Location", icon = Icons.Default.AddLocation) {
                
            }
            HelpsAddOption(label = "Photo", icon = Icons.Default.Camera) {
                
            }
        }
    }
}

@Composable
private fun HelpsAddOption(label: String, icon: ImageVector, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = onClick) {
                Icon(imageVector = icon, contentDescription = null)
            }
            HelpsText(text = label)
        }
    }
}
