pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://redirector.kotlinlang.org/maven/ktor-eap")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://redirector.kotlinlang.org/maven/ktor-eap")
    }
    versionCatalogs {
        create("ktorLibs").from("io.ktor:ktor-version-catalog:3.7.0-dev-plus-eap-1656")
    }
}

rootProject.name = "ktor-reload"

