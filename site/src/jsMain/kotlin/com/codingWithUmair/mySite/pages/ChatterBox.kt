package com.codingWithUmair.mySite.pages

import androidx.compose.runtime.Composable
import com.codingWithUmair.mySite.components.MainLayout
import com.codingWithUmair.mySite.components.ProjectLayout
import com.codingWithUmair.mySite.utils.MainMenuItem
import com.codingWithUmair.mySite.utils.ProjectMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.percent

@Page("/chatterbox")
@Composable
fun ChatterBoxPage(){
    MainLayout(
        pageCategory = MainMenuItem.Projects,
        androidImageSrc = Res.Image.ANDROID_ROBO_PROJECTS
    ){ colorMode ->
        ProjectLayout(
            selectedItem = ProjectMenuItem.ChatterBox,
            imageSrc = Res.Image.CHATTERBOX_COVER,
            imageWidth = 95.percent,
            link = "${Res.String.GITHUB_LINK}/ChatterBox",
            colorMode = colorMode
        )
    }
}