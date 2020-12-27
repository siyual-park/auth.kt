rootProject.name = "auth"

pluginManagement {
    val klint_version: String by settings
    val koin_version: String by settings

    plugins {
        id("org.jlleitschuh.gradle.ktlint") version klint_version
        id("koin")
    }
}
