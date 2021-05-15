package com.jorgecamarena.shoppingcart.presentation.ui.theme.type

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jorgecamarena.shoppingcart.R

val QuickSand = FontFamily(
    Font(
        resId = R.font.quicksand_light,
        weight = FontWeight.W300,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.quicksand_regular,
        weight = FontWeight.W400,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.quicksand_medium,
        weight = FontWeight.W500,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.quicksand_semibold,
        weight = FontWeight.W600,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.quicksand_bold,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    ),
)

val QuickSandTypography = Typography(
    defaultFontFamily = QuickSand,
    h1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSand,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp
    ),
    caption = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)