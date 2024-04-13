package com.codingWithUmair.mySite.components

import androidx.compose.runtime.*
import com.codingWithUmair.mySite.utils.MainMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.shapes.Rect
import com.varabyte.kobweb.silk.theme.shapes.clip
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun MainMenuLayout(
    selectedItem: MainMenuItem,
    androidImageSrc: String,
    colorMode: ColorMode,
    breakpoint: Breakpoint,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.fillMaxSize().padding(16.px),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        MenuBackGround(
            colorMode = colorMode,
            modifier = Modifier
                .margin(top = if(breakpoint <= Breakpoint.SM) 38.px else 0.px)
        ){
            MenuItem(
                iconName = Res.Icon.USER,
                menuItem = MainMenuItem.AboutMe.name,
                isSelected = selectedItem == MainMenuItem.AboutMe,
                link = "/",
            )
            VerticalDivider()
            MenuItem(
                iconName = Res.Icon.SKILLS,
                menuItem = MainMenuItem.SkillSet.name,
                isSelected = selectedItem == MainMenuItem.SkillSet,
                link = "/android",
            )
            VerticalDivider()
            MenuItem(
                iconName = Res.Icon.PROJECTS,
                menuItem = MainMenuItem.Projects.name,
                isSelected = selectedItem == MainMenuItem.Projects,
                link = "/notify",
            )
        }

        if(breakpoint >= Breakpoint.SM){ Spacer() }

        AnimatedAndroidRobot(androidImageSrc)

    }
}

@Composable
fun MenuBackGround(
    colorMode: ColorMode,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .backgroundColor(if(colorMode.isLight) Res.Theme.DARK_BLUE.color else Res.Theme.GRADIENT_ONE_DARK.color)
            .clip(Rect(cornerRadius = 10.px))
            .padding(12.px)
            .fillMaxWidth(95.percent)
    ){
        content()
    }
}

@Composable
fun MenuItem(
    iconName: String,
    menuItem: String,
    isSelected: Boolean,
    link: String,
    modifier: Modifier = Modifier
){
    var hover by remember {
        mutableStateOf(false)
    }
    Link(link){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .margin(4.px)
                .onMouseEnter { hover = true }
                .onMouseLeave { hover = false }
        ) {
            Image(
                iconName,
                modifier = Modifier
                    .margin(bottom = 2.px)
                    .size(if(hover || isSelected) 38.px else 30.px)
            )
            SpanText(
                text = menuItem,
                modifier = Modifier
                    .color(Colors.White)
                    .fontSize(if (hover || isSelected) 24.px else 20.px)
                    .fontWeight(if(hover || isSelected) FontWeight.Bold else FontWeight.Normal)
            )
        }

    }
}

@Composable
fun AnimatedAndroidRobot(
    androidImageSrc: String,
    width: Int = 350,
    margin: CSSLengthOrPercentageNumericValue = 6.px
){

    var androidHoverState by remember {
        mutableStateOf(false)
    }
    var androidRotation by remember {
        mutableIntStateOf(0)
    }
    var positiveRotation by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(androidHoverState){
        if(androidHoverState){
            while(true){
                if(positiveRotation) androidRotation++ else androidRotation--
                delay(20)
                if (androidRotation > 15) positiveRotation = false
                if(androidRotation < -15) positiveRotation = true
            }
        }
    }

    Image(
        src = androidImageSrc,
        width = width,
        modifier = Modifier
            .onMouseEnter { androidHoverState = true }
            .onMouseLeave { androidHoverState = false; androidRotation = 0 }
            .rotate(androidRotation.deg)
            .margin(margin)
    )

}
