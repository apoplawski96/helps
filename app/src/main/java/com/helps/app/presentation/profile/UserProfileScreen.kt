package com.helps.app.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.helps.app.domain.auth.model.HelpsUser
import com.helps.app.presentation.common.composable.HelpsScreenScaffold
import com.helps.app.presentation.common.composable.HelpsTextButton
import com.helps.app.presentation.common.theme.HelpsTheme

@Composable
fun HelpsUserProfileScreen(
    navController: NavController,
    viewModel: UserProfileViewModel,
) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold(navController = navController) {
            HelpsUserProfileScreenContent(
                user = viewModel.user.collectAsState().value,
                logout = { viewModel.logout() }
            )
        }
    }
}

@Composable
private fun HelpsUserProfileScreenContent(
    user: HelpsUser?,
    logout: () -> Unit,
) {
    Column {
        Text(text = user.toString())
        HelpsTextButton(label = "Logout", onClick = logout)
    }
}