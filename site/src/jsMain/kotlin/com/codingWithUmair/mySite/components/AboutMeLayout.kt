package com.codingWithUmair.mySite.components

import androidx.compose.runtime.*
import com.codingWithUmair.mySite.utils.Res
import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.shapes.Rect
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun AboutMeLayout(
    colorMode: ColorMode,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxWidth().padding(16.px)
    ){
        ImageAndName(colorMode)
        Divider(colorMode, thickness = 2.px, modifier = Modifier.margin(top = 16.px))
        AboutMeText(colorMode)
        LogoRow(modifier = Modifier.fillMaxWidth(75.percent).margin(bottom = 74.px))
        ContactCard(
            email = Res.String.MY_EMAIL,
            phoneNo = Res.String.PHONE,
            github = Res.String.GITHUB_LINK,
            colorMode = colorMode,
        )
    }
}

@Composable
private fun ImageAndName(
    colorMode: ColorMode,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Image(
            src = Res.Image.PROFILE_PHOTO,
            modifier = Modifier
                .size(150.px)
                .clip(Rect(cornerRadius = 10.px))
                .margin(right = 12.px)
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            SpanText(
                text = Res.String.NAME,
                modifier = Modifier
                    .fontFamily(Res.String.ROBOTO_CONDENSED)
                    .color(if (colorMode.isLight) Colors.Black else Colors.White)
                    .fontSize(38.px)
                    .fontWeight(FontWeight.Bold)
            )

            SpanText(
                text = Res.String.PROFESSION,
                modifier = Modifier
                    .margin(left = 6.px)
                    .fontFamily(Res.String.ROBOTO_REGULAR)
                    .color(if (colorMode.isLight) Colors.Black else Colors.White)
                    .fontSize(18.px)
            )


        }
    }
}


@Composable
private fun AboutMeText(
    colorMode: ColorMode,
){
    SpanText(
        modifier = Modifier
            .fontFamily(Res.String.ROBOTO_REGULAR)
            .fontSize(14.px)
            .color(if (colorMode.isLight) Colors.Black else Colors.White)
            .opacity(50.percent)
            .lineHeight(2)
            .margin(bottom = 36.px),
        text = Res.String.ABOUT_ME_TEXT
    )
}

@Composable
private fun ContactCard(
    email: String,
    phoneNo: String,
    github: String,
    colorMode: ColorMode,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        ContactRow(
            imageSrc = if(colorMode.isLight) Res.Icon.PHONE_LIGHT else Res.Icon.PHONE_DARK,
            text = phoneNo,
            colorMode = colorMode,
            modifier = Modifier
        )
        Divider(colorMode, thickness = 1.px, modifier = Modifier.margin(topBottom = 4.px))
        Link(github) {
            ContactRow(
                imageSrc = if (colorMode.isLight) Res.Icon.GITHUB_LIGHT else Res.Icon.GITHUB_DARK,
                text = github,
                colorMode = colorMode,
                shouldStyle = true
            )
        }
        Divider(colorMode, thickness = 1.px, modifier = Modifier.margin(topBottom = 4.px))
        Link("mailto:${email}"){
            ContactRow(
                imageSrc = if(colorMode.isLight) Res.Icon.EMAIL_LIGHT else Res.Icon.EMAIL_DARK,
                text = email,
                colorMode = colorMode,
                shouldStyle = true
            )
        }
    }
}

@Composable
fun ContactRow(
    imageSrc: String,
    text:String,
    colorMode: ColorMode,
    shouldStyle: Boolean = false,
    modifier: Modifier = Modifier
) {
    var hover by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = modifier
            .onMouseEnter { hover = true }
            .onMouseLeave { hover = false },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(28.px),
            contentAlignment = Alignment.Center
        ) {
            Image(
                src = imageSrc,
                width = 28,
                height = 28
            )
        }
        Box(modifier = Modifier.size(8.px))
        SpanText(
            text = text,
            modifier = Modifier
                .color(Color.white)
                .fontSize(15.px)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .fontWeight(if(hover && shouldStyle) FontWeight.SemiBold else FontWeight.Normal)
        )
    }
}

@Composable
fun LogoRow(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .backgroundColor(Res.Theme.DARK_BLUE.color)
            .clip(Rect(cornerRadius = 10.px))
            .padding(12.px),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageLogo(
            src = Res.Image.KOTLIN,
            link = "https://kotlinlang.org/"
        )
        VerticalDivider()
        ImageLogo(
            src = Res.Image.ANDROID_LOGO,
            link = "https://developer.android.com/"
        )
        VerticalDivider()
        ImageLogo(
            src = Res.Image.COMPOSE,
            link = "https://developer.android.com/develop/ui/compose"
        )
        VerticalDivider()
        ImageLogo(
            src = Res.Image.ANDROID_STUDIO,
            link = "https://developer.android.com/studio"
        )
    }
}

@Composable
fun ImageLogo(
    src: String,
    link: String,
){
    var hover by remember{
        mutableStateOf(false)
    }
    Link(link){
        Image(
            src = src,
            modifier = Modifier
                .onMouseEnter { hover=true }
                .onMouseLeave { hover=false }
                .size(if(hover) 52.px else 50.px)
        )
    }

}

@Composable
private fun Divider(
    colorMode: ColorMode,
    thickness: CSSLengthNumericValue,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .height(thickness)
            .fillMaxWidth(95.percent)
            .background(
                if (colorMode.isLight) Res.Theme.BLUE.color
                else Res.Theme.LIGHT_BLUE.color
            )
    ) {}
}