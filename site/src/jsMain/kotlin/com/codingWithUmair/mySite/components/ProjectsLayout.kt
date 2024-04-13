package com.codingWithUmair.mySite.components

import androidx.compose.runtime.*
import com.codingWithUmair.mySite.utils.ProjectMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectLayout(
    selectedItem: ProjectMenuItem,
    imageSrc: String,
    imageWidth: CSSLengthOrPercentageNumericValue,
    link: String,
    colorMode: ColorMode,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(16.px)
    ) {
        MenuBackGround(
            colorMode = colorMode
        ){
            MenuItem(
                iconName = Res.Icon.NOTIFY_ICON,
                menuItem = ProjectMenuItem.Notify.name,
                isSelected = selectedItem == ProjectMenuItem.Notify,
                link = "/notify"
            )
            VerticalDivider()
            MenuItem(
                iconName = Res.Icon.VIDCOMPOSE_ICON,
                menuItem = ProjectMenuItem.VidCompose.name,
                isSelected = selectedItem == ProjectMenuItem.VidCompose,
                link = "/vidcompose"
            )
            VerticalDivider()
            MenuItem(
                iconName = Res.Icon.CHATTERBOX_ICON,
                menuItem = ProjectMenuItem.ChatterBox.name,
                isSelected = selectedItem == ProjectMenuItem.ChatterBox,
                link = "/chatterbox"
            )
        }
        ProjectContent(
            name = selectedItem.name,
            imageSrc = imageSrc,
            imageWidth = imageWidth,
            link = link,
            colorMode = colorMode
        )

    }
}


@Composable
fun ProjectContent(
    name: String,
    imageSrc: String,
    imageWidth: CSSLengthOrPercentageNumericValue,
    link: String,
    colorMode: ColorMode,
    modifier: Modifier = Modifier
){
    var hover by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SpanText(
            text = name,
            modifier = Modifier
                .fontFamily(Res.String.ROBOTO_CONDENSED)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .fontSize(38.px)
                .fontWeight(FontWeight.Bold)
                .margin(16.px)
        )
        Image(
            src = imageSrc,
            modifier = Modifier
                .fillMaxWidth(imageWidth)
        )
        Link(
            link,
            modifier = Modifier
                .margin(16.px)
        ) {
            Row(
                modifier = Modifier
                    .padding(6.px)
                    .borderRadius(10.px)
                    .background(if(colorMode.isLight) Res.Theme.LIGHT_BLUE.color else Res.Theme.DARK_BLUE.color),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    src = if (colorMode.isLight) Res.Icon.GITHUB_LIGHT else Res.Icon.GITHUB_DARK,
                    modifier = Modifier.size(48.px)
                )
                SpanText(
                    text = "See on GitHub",
                    modifier = Modifier
                        .onMouseEnter { hover = true }
                        .onMouseLeave { hover = false }
                        .color(Color.white)
                        .fontSize(15.px)
                        .color(if (colorMode.isLight) Colors.Black else Colors.White)
                        .fontWeight(if(hover) FontWeight.SemiBold else FontWeight.Normal)
                )
            }
        }
    }
}