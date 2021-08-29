package com.helps.presentation.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helps.presentation.common.theme.HelpsTheme
import com.helps.presentation.common.theme.HelpsThemeDarkGrey

@Composable
fun HelpsMottoText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(16.dp),
        style = TextStyle(
            fontSize = 24.sp,
            color = HelpsTheme.colors.secondary,
        ),
    )
}

@Composable
fun HelpsText(
    text: String,
    color: Color = HelpsTheme.colors.secondary,
    size: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null
) {
    Text(text = text, color = color, fontSize = size, fontWeight = fontWeight)
}

@Composable
fun HelpsTextField(
    text: String,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChanged: (String) -> Unit,
) {
    Column(
        modifier = Modifier.padding(vertical = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChanged,
            label = { Text(label) },
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = HelpsTheme.colors.secondary,
                unfocusedBorderColor = HelpsTheme.colors.secondary,
                focusedLabelColor = HelpsTheme.colors.secondary,
                unfocusedLabelColor = HelpsTheme.colors.secondary
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(HelpsTheme.colors.secondary)
        )
    }
}

@Composable
fun HelpsTextFieldBoxBig(text: String, height: Dp, onTextChanged: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChanged,
        label = { Text("") },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = HelpsThemeDarkGrey
        ),
        modifier = Modifier.fillMaxWidth().height(height).padding(horizontal = 24.dp)
    )
}

@Preview
@Composable
private fun HelpsTextFieldBoxBigPreview() {
    HelpsTextFieldBoxBig(text = "Type your message", height = 128.dp) { }
}