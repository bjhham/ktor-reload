
plugins {
    alias(libs.plugins.kotlin.jvm)
    id("io.ktor.plugin") version "3.7.0-dev-mode-plus-eap-202"
}

group = "com.acme"
version = "1.0.0-SNAPSHOT"

application {
    mainClass = "com.acme.MainKt"
}

kotlin {
    jvmToolchain(21)
}
dependencies {
    implementation(ktorLibs.server.core)
    implementation(ktorLibs.server.htmlBuilder)
    implementation(ktorLibs.server.netty)
    implementation(libs.kotlinx.kotlinxHtml)
    implementation(libs.logback.classic)

    testImplementation(kotlin("test"))
    testImplementation(ktorLibs.server.testHost)
}
