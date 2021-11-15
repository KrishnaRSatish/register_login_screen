package com.example.login_register.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.example.login_register.ui.theme.Shapes

private val DarkColorPalette = darkColors(
    primary = YellowAccent,
    background = DarkGrey,
    onBackground = TextWhite,
    onPrimary = DarkGrey,
    surface = MediumGrey,
    onSurface = LightGrey,
)


@Composable
fun Login_registerTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}