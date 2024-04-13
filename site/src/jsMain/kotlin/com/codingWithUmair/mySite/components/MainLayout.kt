package com.codingWithUmair.mySite.components

import androidx.compose.runtime.*
import com.codingWithUmair.app.mySite.components.ThemeSwitchButton
import com.codingWithUmair.mySite.utils.MainMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.shapes.Rect
import com.varabyte.kobweb.silk.theme.shapes.clip
import kotlinx.browser.localStorage
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun MainLayout(
    pageCategory: MainMenuItem,
    androidImageSrc: String,
    content: @Composable (ColorMode) -> Unit
) {

    var colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()

    LaunchedEffect(colorMode) {
        val savedTheme = localStorage.getItem(Res.String.SAVED_THEME) ?: ColorMode.DARK.name
        colorMode = ColorMode.valueOf(savedTheme)
    }

    ThemeSwitchButton(
        colorMode = colorMode,
        onClick = {
            colorMode = colorMode.opposite
            localStorage.setItem(Res.String.SAVED_THEME, colorMode.name)
        }
    )

    Box(
        Modifier
            .fillMaxSize()
            .backgroundImage(
                linearGradient(
                    dir = LinearGradient.Direction.ToRight,
                    from = if (colorMode.isLight) Res.Theme.GRADIENT_ONE.color
                    else Res.Theme.GRADIENT_ONE_DARK.color,
                    to = if (colorMode.isLight) Res.Theme.GRADIENT_TWO.color
                    else Res.Theme.GRADIENT_TWO_DARK.color
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2),
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint <= Breakpoint.MD) 100.percent
                    else Res.Dimens.MAX_CARD_WIDTH.px
                )
                .thenIf(
                    condition = breakpoint > Breakpoint.MD,
                    other = Modifier.height(Res.Dimens.MAX_CARD_HEIGHT.px)
                )
                .boxShadow(
                    color = Colors.Black.copy(alpha = 10),
                    blurRadius = 50.px,
                    spreadRadius = 50.px
                )
                .padding(all = 12.px)
                .borderRadius(r = Res.Dimens.BORDER_RADIUS.px)
                .background(
                    if (colorMode.isLight) Res.Theme.LIGHT_BLUE.color else
                        Res.Theme.DARK_BLUE.color
                )
        ) {
            MainMenuLayout(pageCategory, androidImageSrc, colorMode, breakpoint)
            content(colorMode)
        }
    }
}




