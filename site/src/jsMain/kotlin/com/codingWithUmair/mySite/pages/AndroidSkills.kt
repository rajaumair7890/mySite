package com.codingWithUmair.mySite.pages

import androidx.compose.runtime.Composable
import com.codingWithUmair.mySite.components.MainLayout
import com.codingWithUmair.mySite.components.SkillSetLayout
import com.codingWithUmair.mySite.utils.MainMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.codingWithUmair.mySite.utils.SkillMenuItem
import com.varabyte.kobweb.core.Page

@Page("/android")
@Composable
fun AndroidSkillsPage(){
    MainLayout(
        pageCategory = MainMenuItem.SkillSet,
        androidImageSrc = Res.Image.ANDROID_ROBO_SKILLS
    ){ colorMode ->
        SkillSetLayout(
            title = Res.String.ANDROID_SKILLS_HEADING,
            list = Res.skillSetList,
            selectedItem = SkillMenuItem.Android,
            colorMode = colorMode
        )
    }
}