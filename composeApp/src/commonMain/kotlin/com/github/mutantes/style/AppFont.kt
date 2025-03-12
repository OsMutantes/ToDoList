package com.github.mutantes.style

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import todoapp.composeapp.generated.resources.`Inter_VariableFont_opsz,wght`
import todoapp.composeapp.generated.resources.Res

@Composable
fun InterFontFamily(): FontFamily {
    return FontFamily(
        org.jetbrains.compose.resources.Font(
            Res.font.`Inter_VariableFont_opsz,wght`,
            FontWeight.Bold
        ),
        org.jetbrains.compose.resources.Font(
            Res.font.`Inter_VariableFont_opsz,wght`,
            FontWeight.Normal)
    )
}

@Composable
fun AppTypography(): Typography {
    val fontFamily = InterFontFamily()
    return Typography(

        h1 = TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,

            fontFamily = fontFamily
        ),
        h2 = TextStyle(
            fontSize = 24.sp,
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
        subtitle1 = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily
        )

    )
}




