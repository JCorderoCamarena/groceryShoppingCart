package com.jorgecamarena.shoppingcart.presentation.ui.theme.type

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jorgecamarena.shoppingcart.R

val ProductFontFamily = FontFamily(
    Font(
        resId = R.font.product_sans_regular,
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.product_sans_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.product_sans_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.product_sans_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    )
)

val ProductTypography = Typography(
    defaultFontFamily = ProductFontFamily,
    h1 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = ProductFontFamily,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = ProductFontFamily,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp
    ),
    caption = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = ProductFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)
