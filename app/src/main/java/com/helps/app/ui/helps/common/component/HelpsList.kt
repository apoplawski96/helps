package com.helps.app.ui.helps.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helps.app.ui.common.composable.HelpsText
import com.helps.app.ui.common.theme.HelpsTheme
import com.helps.app.ui.common.theme.HelpsThemeGrey
import com.helps.app.ui.helps.common.model.HelpsItemUI

@Composable
fun HelpsList(items: List<HelpsItemUI>, listHeaderText: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HelpsHeader(listHeaderText)
        LazyColumn {
            itemsIndexed(items) { index: Int, itemUI: HelpsItemUI ->
                HelpsItem(itemUI)
            }
        }
    }
}

@Composable
fun HelpsHeader(headerText: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(HelpsTheme.colors.primary)
    ) {
        HelpsText(
            text = headerText,
            size = 18.sp,
            color = HelpsTheme.colors.textOnPrimary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun HelpsItem(itemUI: HelpsItemUI) {
    Card(
        backgroundColor = HelpsTheme.colors.secondaryVariant,
        elevation = 0.dp,
        shape = MaterialTheme.shapes.large
    ) {
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                HelpsThumbnail(itemUI.imageUrl)
                HelpsInfo(itemUI)
                GoToButton { }
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(HelpsThemeGrey))
        }
    }
}

@Composable
private fun HelpsThumbnail(imageUrl: String) {
    Box(modifier = Modifier.size(100.dp))
}

@Composable
private fun HelpsInfo(itemUI: HelpsItemUI) {
    Column() {
        SponsoredText(isSponsored = itemUI.sponsored)
        TitleText(title = itemUI.title)
        SummaryText(summary = itemUI.summary)
        LocationText(location = itemUI.location)
        PublishedTimeText(publishedTime = itemUI.datePublished)
    }
}

@Composable
private fun GoToButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = Modifier.size(64.dp),
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = HelpsTheme.colors.secondaryVariant
        )
    }
}

@Composable
private fun SponsoredText(isSponsored: Boolean) {
    if (isSponsored) HelpsText(text = "Sponsored Helps", size = 10.sp, color = Color.DarkGray)
}

@Composable
private fun TitleText(title: String) {
    HelpsText(text = title, size = 16.sp, color = HelpsTheme.colors.primary)
}

@Composable
private fun SummaryText(summary: String) {
    HelpsText(text = summary, size = 12.sp, color = Color.DarkGray)
}

@Composable
private fun LocationText(location: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.MyLocation, contentDescription = null, tint = Color.DarkGray)
        HelpsText(text = location, size = 12.sp, color = Color.DarkGray)
    }
}

@Composable
private fun PublishedTimeText(publishedTime: String) {
    HelpsText(text = publishedTime, size = 14.sp, color = HelpsTheme.colors.primary)
}

@Composable
@Preview
private fun HelpsItemPreview() {
    HelpsItem(
        itemUI = HelpsItemUI(
            id = "123",
            title = "Prosze dla mnie psa wyprowadzic",
            summary = "Pies gryzie",
            location = "Belchatow ul. Jarzebinowa 4",
            datePublished = "07/09/2020 8:15",
            sponsored = true,
            imageUrl = "jakis url jebac"
        )
    )
}

@Composable
@Preview
private fun HelpsListPreview() {
    HelpsList(items = getMockItems(), listHeaderText = "Want to help someone?")
}

fun getMockItems() = listOf(
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemUI(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
)


