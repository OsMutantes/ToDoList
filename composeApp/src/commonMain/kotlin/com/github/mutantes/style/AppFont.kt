package com.github.mutantes.style

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import todoapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import todoapp.composeapp.generated.resources.inter

@Composable
fun InterFontFamily(): FontFamily {
    return FontFamily(
        Font(
            Res.font.inter,
            weight = FontWeight.Normal
        ),
        Font(
            Res.font.inter,
            weight = FontWeight.Bold
        )
    )
}

@Composable
fun AppTypography(): Typography {
    val fontFamily = InterFontFamily()
    return Typography(
        h1 = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily
        ),
        body1 = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily
        ),
        body2 = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = fontFamily
        ),
        h2 = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.W700,
            fontFamily = fontFamily
        ),
    )
}




