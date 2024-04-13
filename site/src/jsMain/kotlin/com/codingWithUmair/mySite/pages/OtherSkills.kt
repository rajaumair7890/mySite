package com.codingWithUmair.mySite.pages

import androidx.compose.runtime.Composable
import com.codingWithUmair.mySite.components.MainLayout
import com.codingWithUmair.mySite.components.SkillSetLayout
import com.codingWithUmair.mySite.utils.MainMenuItem
import com.codingWithUmair.mySite.utils.Res
import com.codingWithUmair.mySite.utils.SkillMenuItem
import com.varabyte.kobweb.core.Page

@Page("/others")
@Composable
fun OthersSkillsPage(){
    MainLayout(
        pageCategory = MainMenuItem.SkillSet,
        androidImageSrc = Res.Image.ANDROID_ROBO_SKILLS
    ){ colorMode ->
        SkillSetLayout(
            title = Res.String.OTHER_SKILLS_HEADING,
            list = Res.otherSkills,
            selectedItem = SkillMenuItem.Others,
            colorMode = colorMode
        )
    }
}