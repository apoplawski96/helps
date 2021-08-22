package com.helps.presentation.helps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helps.presentation.common.composable.HelpsText

@Composable
fun HelpsList(items: List<HelpsItemContent>, listHeaderText: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ListHeader(listHeaderText)
        LazyColumn {
            itemsIndexed(items) { index: Int, itemContent: HelpsItemContent ->
                HelpsItem(itemContent)
            }
        }
    }
}

@Composable
private fun HelpsItem(itemContent: HelpsItemContent) {
    Card(backgroundColor = MaterialTheme.colors.secondaryVariant) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            HelpsThumbnail(itemContent.imageUrl)
            HelpsInfo(itemContent)
            GoToButton { }
        }
    }
}

@Composable
private fun ListHeader(listHeaderText: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
    ) {
        HelpsText(text = listHeaderText, size = 18.sp, color = MaterialTheme.colors.onPrimary)
    }
}

@Composable
private fun HelpsThumbnail(imageUrl: String) {
    Box(modifier = Modifier.size(100.dp))
}

@Composable
private fun HelpsInfo(itemContent: HelpsItemContent) {
    Column() {
        SponsoredText(isSponsored = itemContent.sponsored)
        TitleText(title = itemContent.title)
        SummaryText(summary = itemContent.summary)
        LocationText(location = itemContent.location)
        PublishedTimeText(publishedTime = itemContent.datePublished)
    }
}

@Composable
private fun GoToButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = Modifier.size(64.dp),
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null
        )
    }
}

@Composable
private fun SponsoredText(isSponsored: Boolean) {
    if (isSponsored) HelpsText(text = "Sponsored Helps", size = 10.sp, color = Color.DarkGray)
}

@Composable
private fun TitleText(title: String) {
    HelpsText(text = title, size = 16.sp, color = MaterialTheme.colors.primary)
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
        Icon(imageVector = Icons.Default.MyLocation, contentDescription = null)
        HelpsText(text = location, size = 12.sp, color = Color.DarkGray)
    }
}

@Composable
private fun PublishedTimeText(publishedTime: String) {
    HelpsText(text = publishedTime, size = 14.sp, color = MaterialTheme.colors.primary)
}

@Composable
@Preview
private fun HelpsItemPreview() {
    HelpsItem(
        itemContent = HelpsItemContent(
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
    HelpsItemContent(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemContent(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemContent(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemContent(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    ),
    HelpsItemContent(
        id = "123",
        title = "Prosze dla mnie psa wyprowadzic",
        summary = "Pies gryzie",
        location = "Belchatow ul. Jarzebinowa 4",
        datePublished = "07/09/2020 8:15",
        sponsored = true,
        imageUrl = "jakis url jebac"
    )
)


