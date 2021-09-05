package com.helps.presentation.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
fun HelpsMottoText(text: String, size: TextUnit = 22.sp) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(16.dp),
        style = TextStyle(
            fontSize = size,
            color = HelpsTheme.colors.secondary,
            lineHeight = 30.sp
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
    leadingIcon: ImageVector,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onTextChanged: (String) -> Unit,
) {
    Column(
        modifier = Modifier.padding(vertical = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = onTextChanged,
            label = { Text(label) },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "",
                    tint = HelpsTheme.colors.secondary
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = HelpsTheme.colors.textOnPrimary,
                focusedIndicatorColor = HelpsTheme.colors.secondary,
                unfocusedIndicatorColor = HelpsTheme.colors.secondary,
                unfocusedLabelColor = HelpsTheme.colors.secondary,
                focusedLabelColor = HelpsTheme.colors.secondaryVariant,
                backgroundColor = HelpsTheme.colors.primaryVariant,
                textColor = HelpsTheme.colors.textOnPrimary,
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

//    Column(
//        modifier = Modifier.padding(vertical = 24.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        HelpsText(text = label)
//        OutlinedTextField(
//            value = text,
//            onValueChange = onTextChanged,
//            label = { Text(label) },
//            visualTransformation = visualTransformation,
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Color.Transparent,
//                unfocusedBorderColor = Color.Transparent,
//                focusedLabelColor = Color.Transparent,
//                unfocusedLabelColor = Color.Transparent
//            )
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(0.5.dp)
//                .background(HelpsTheme.colors.secondary)
//        )
//    }
}

@Composable
fun HelpsTextFieldRoundedBox(
    text: String,
    placeholderText: String,
    labelText: String,
    height: Dp, onTextChanged: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onTextChanged,
        label = {
            HelpsText(
                text = labelText,
                color = HelpsTheme.colors.primary,
                fontWeight = FontWeight.Medium
            )
        },
        shape = RoundedCornerShape(16.dp),
        placeholder = {
            HelpsText(
                text = placeholderText,
                color = HelpsTheme.colors.secondaryVariant2
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = 24.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = HelpsThemeDarkGrey,
            cursorColor = HelpsThemeDarkGrey,
            focusedLabelColor = HelpsTheme.colors.primaryVariant,
            unfocusedLabelColor = HelpsTheme.colors.primaryVariant
        ),
    )
}

@Preview
@Composable
private fun HelpsTextFieldBoxBigPreview() {
    HelpsTextFieldRoundedBox(
        text = "Type your message",
        height = 128.dp,
        placeholderText = "Type your message",
        labelText = "Hashtags"
    ) { }
}