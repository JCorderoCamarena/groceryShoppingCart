package com.jorgecamarena.shoppingcart.presentation.ui.theme.type

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jorgecamarena.shoppingcart.R

val RobotoFontFamily = FontFamily(
    Font(
        resId = R.font.roboto_black,
        weight = FontWeight.W900,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.roboto_black_italic,
        weight = FontWeight.W900,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.roboto_bold,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    ),

    Font(
        resId = R.font.roboto_bold_italic,
        weight = FontWeight.W700,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.roboto_italic,
        weight = FontWeight.W500,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.roboto_light,
        weight = FontWeight.W300,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.roboto_light_italic,
        weight = FontWeight.W300,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.roboto_medium,
        weight = FontWeight.W600,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.roboto_medium_italic,
        weight = FontWeight.W600,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.roboto_regular,
        weight = FontWeight.W500,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.roboto_thin,
        weight = FontWeight.W200,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.roboto_thin_italic,
        weight = FontWeight.W200,
        style = FontStyle.Italic
    )

)

val RobotoTypography = Typography(
    defaultFontFamily = RobotoFontFamily,
    h1 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = RobotoFontFamily,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp
    ),
    caption = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)
