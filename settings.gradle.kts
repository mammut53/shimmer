pluginManagement {
    repositories {
        mavenCentral()
        maven (  "https://maven.fabricmc.net/" )
        maven (  "https://maven.architectury.dev/" )
        maven (  "https://maven.neoforged.net/releases/" )
        gradlePluginPortal()
    }
    plugins{
        id("architectury-plugin") version ("3.4-SNAPSHOT") apply false
        id("dev.architectury.loom") version ("1.5-SNAPSHOT") apply false
        id("com.github.johnrengelman.shadow").version("8.1.1").apply(false)
    }
}

include("Common")
include("Fabric")
include("NeoForge")

rootProject.name = "Shimmer"
