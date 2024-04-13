package com.codingWithUmair.mySite.components

import androidx.compose.runtime.Composable
import com.codingWithUmair.mySite.utils.Res
import com.codingWithUmair.mySite.utils.SkillMenuItem
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul

@Composable
fun SkillSetLayout(
    title: String,
    list: List<String>,
    selectedItem: SkillMenuItem,
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
            Box(modifier = Modifier.size(28.px))
            MenuItem(
                iconName = Res.Image.ANDROID_LOGO,
                menuItem = SkillMenuItem.Android.name,
                isSelected = selectedItem == SkillMenuItem.Android,
                link = "/android"
            )
            VerticalDivider()
            MenuItem(
                iconName = Res.Image.COMPOSE,
                menuItem = SkillMenuItem.Others.name,
                isSelected = selectedItem == SkillMenuItem.Others,
                link = "/others"
            )
            Box(modifier = Modifier.size(28.px))
        }

        SkillsList(
            title = title,
            list = list,
            colorMode = colorMode
        )

    }
}


@Composable
fun SkillsList(
    title: String,
    list: List<String>,
    colorMode: ColorMode,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        SpanText(
            text = title,
            modifier = Modifier
                .fontFamily(Res.String.ROBOTO_CONDENSED)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .fontSize(38.px)
                .fontWeight(FontWeight.Bold)
        )
        Ul {
            list.forEach { skill ->
                Li {
                    SpanText(
                        text = skill,
                        modifier = Modifier
                            .color(if (colorMode.isLight) Colors.Black else Colors.White)
                            .fontSize(18.px)
                    )
                }

            }
        }
    }
}

