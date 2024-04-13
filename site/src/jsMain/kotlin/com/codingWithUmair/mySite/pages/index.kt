package com.codingWithUmair.mySite.pages

import androidx.compose.runtime.Composable
import com.codingWithUmair.mySite.components.AboutMeLayout
import com.codingWithUmair.mySite.components.MainLayout
import com.codingWithUmair.mySite.utils.MainMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.varabyte.kobweb.core.Page

@Page("/")
@Composable
fun AboutMePage(){
    MainLayout(
        pageCategory = MainMenuItem.AboutMe,
        androidImageSrc = Res.Image.ANDROID_ROBO_HOME
    ){ colorMode ->
        AboutMeLayout(colorMode)
    }
}

