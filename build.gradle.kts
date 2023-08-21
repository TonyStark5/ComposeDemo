import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.0"
    id("org.jetbrains.compose") version "1.4.3"
}

group = "com.tony"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}


dependencies {
    implementation(compose.desktop.currentOs)
//    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.11")
}


kotlin {
    jvmToolchain(17)


    sourceSets {
        
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ComposeDemo"
            packageVersion = "1.0.0"
        }
    }
}