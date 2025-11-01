package com.example.meet5_inputdata.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
// INCORRECT import was java.time.format.TextStyle
import androidx.compose.ui.text.TextStyle // <-- FIX #1: Correct import
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// FIX #2: Rename variable to start with a lowercase letter
val typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other text styles to override go here */
)

private val LightColors = lightColorScheme(
    // You can use default colors or leave it empty
)

@Composable
fun Meet5_inputdataTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = typography, // <-- FIX #3: Use the renamed variable
        content = content
    )
}
