package com.helps.app.ui.auth.guest

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.helps.app.ui.common.composable.*
import com.helps.app.ui.HelpsDestinations
import com.helps.app.ui.common.theme.HelpsTheme

@Composable
fun HelpsGuestScreen(navController: NavController) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(topBarMode = TopBarMode.WITH_BACK_NAVIGATION) {
            HelpsGuestScreenContent(
                onGetInButtonClicked = { navController.navigate(HelpsDestinations.BottomNavRoots.home.route) }
            )
        }
    }
}

@Composable
private fun HelpsGuestScreenContent(onGetInButtonClicked: () -> Unit) {
    var usernameText by remember { mutableStateOf("") }
    var phoneNumberText by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(128.dp))
        HelpsMottoText(text = "Use it as Guest", size = 24.sp)
        HelpsTextField(
            text = usernameText,
            label = "Username",
            leadingIcon = Icons.Default.Person,
            onTextChanged = { usernameText = it }
        )
        HelpsTextField(
            text = phoneNumberText,
            label = "Phone number",
            leadingIcon = Icons.Default.Phone,
            onTextChanged = { phoneNumberText = it },
        )
        Spacer(modifier = Modifier.height(64.dp))
        HelpsButtonSecondary(label = "Get in", onClick = onGetInButtonClicked)
    }
}