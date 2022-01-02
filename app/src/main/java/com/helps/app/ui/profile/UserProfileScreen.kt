package com.helps.app.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.helps.app.domain.auth.model.HelpsUser
import com.helps.app.ui.common.composable.HelpsScreenScaffold
import com.helps.app.ui.common.composable.HelpsTextButton
import com.helps.app.ui.common.theme.HelpsTheme

@Composable
fun HelpsUserProfileScreen(
    viewModel: UserProfileViewModel,
) {
    Surface(color = HelpsTheme.colors.primary) {
        HelpsScreenScaffold() {
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