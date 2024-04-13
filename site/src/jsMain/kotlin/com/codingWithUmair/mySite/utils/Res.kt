package com.codingWithUmair.mySite.utils

import com.varabyte.kobweb.compose.ui.graphics.Color


object Res {
    enum class Theme(val color: Color) {
        BLUE(color = Color.rgb(r = 33, g = 150, b = 243)),
        LIGHT_BLUE(color = Color.rgb(r = 168, g = 236, b = 255)),
        DARK_BLUE(color = Color.rgb(r = 34, g = 63, b = 94)),
        SOCIAL_ICON_BACKGROUND_LIGHT(color = Color.rgb(r = 230, g = 230, b = 230)),
        SOCIAL_ICON_BACKGROUND_DARK(color = Color.rgb(r = 48, g = 82, b = 118)),
        GRADIENT_ONE(color = Color.rgb(r = 161, g = 196, b = 253)),
        GRADIENT_ONE_DARK(color = Color.rgb(r = 19, g = 38, b = 58)),
        GRADIENT_TWO(color = Color.rgb(r = 194, g = 233, b = 251)),
        GRADIENT_TWO_DARK(color = Color.rgb(r = 20, g = 46, b = 73))
    }

    object Icon {
        const val PHONE_LIGHT = "phone_light.png"
        const val PHONE_DARK = "phone_dark.png"
        const val EMAIL_LIGHT = "mail_light.png"
        const val EMAIL_DARK = "mail_dark.png"
        const val GITHUB_LIGHT = "github_light.png"
        const val GITHUB_DARK = "github_dark.png"
        const val SUN = "sun.svg"
        const val MOON = "moon.svg"
        const val USER = "userIcon.svg"
        const val SKILLS = "skillsIcon.svg"
        const val PROJECTS = "projectsIcon.svg"
        const val CHATTERBOX_ICON = "chatterBoxIcon.png"
        const val NOTIFY_ICON = "notifyIcon.png"
        const val VIDCOMPOSE_ICON = "vidComposeIcon.png"
    }

    object Image {
        const val PROFILE_PHOTO = "photo.jpg"
        const val ANDROID_LOGO = "android_logo.png"
        const val ANDROID_ROBO_HOME = "androidHome.png"
        const val ANDROID_ROBO_SKILLS = "androidSkills.png"
        const val ANDROID_ROBO_PROJECTS = "androidProjects.png"
        const val ANDROID_STUDIO = "studio_logo.png"
        const val KOTLIN = "kotlin_logo.png"
        const val COMPOSE = "jetpack_compose_icon.png"
        const val NOTIFY_COVER = "NotifyCover.png"
        const val CHATTERBOX_COVER = "ChatterBoxCover.png"
        const val VIDCOMPOSE_COVER = "VidComposeCover.png"
    }

    object String {
        const val NAME = "Umair Abdullah"
        const val PROFESSION = "Android Developer"
        const val ABOUT_ME_TEXT =
            "Self taught Native Android developer! With 4+ years of coding expertise, including 2 years in Native Android app development, I specialize in crafting top-notch, high-quality mobile applications."
        const val BUTTON_TEXT = "Get in touch"
        const val ROBOTO_CONDENSED = "RobotoCondensedBold"
        const val ROBOTO_REGULAR = "RobotoRegular"
        const val MY_EMAIL = "umairabdullah78901@gmail.com"
        const val GITHUB_LINK = "https://github.com/rajaumair7890"
        const val SAVED_THEME = "theme"
        const val PHONE = "+92 335 597 1817"
        const val WELCOME = "Welcome Visitor"
        const val ANDROID_SKILLS_HEADING = "Android Skills:"
        const val OTHER_SKILLS_HEADING = "Other Skills:"
    }

    object MenuString{
        const val HOME = "Home:"
        const val ABOUT_ME = "About Me"
        const val SKILLS = "Skills:"
        const val ANDROID_SKILLS = "Android Skills"
        const val OTHER_SKILLS = "Other Skills"
        const val PROJECTS = "Projects:"
        const val NOTIFY = "Notify"
        const val CHATTERBOX = "ChatterBox"
        const val VIDCOMPOSE = "VidCompose"
    }

    object Dimens {
        const val BORDER_RADIUS = 8
        const val MAX_CARD_WIDTH = 1000
        const val MAX_CARD_HEIGHT = 600
        const val ICON_SIZE = 24
        const val ICON_SIZE_LG = 32
    }

    val skillSetList = listOf(
        "✨ Jetpack_Compose",
        "📦 Room Database",
        "🤖 Android SDK",
        "🚀Android Jetpack: Navigation, ViewModels, WorkManager, DataStore",
        "🏡 Android Lifecycle Components",
        "💻 Kotlin: Standard Library, Flows, Coroutines",
        "📡 MongoDB Realm Database",
        "🔥 Firebase SDK & Cloud Firestore",
        "🎬 Android Media 3",
        "🧬 MVVM: Modern Android Architecture",
        "🏗 Multi-Module Architecture",
        "🌐 RESTful APIs",
        "🔄 Retrofit",
        "🧰 Android Studio",
        "🖼️ Coil image loading library",
        "💻 Kotlin Ktor Backend"
    )

    val otherSkills = listOf(
        "🐍 Python: Pygame, Kivy, Tkinter, PIL, Django",
        "💻 Kotlin Ktor Backend",
        "🍵 Java",
        "🕸️ Kotlin/Js + Compose/html: Kobweb",
        "🌐 Html, CSS, JavaScript"
    )
}