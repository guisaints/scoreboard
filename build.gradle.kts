plugins {
    kotlin("jvm") version "1.9.22"

    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"

    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.minecraft.kotlin.scoreboard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    implementation ("fr.mrmicky:fastboard:2.1.2")

    compileOnly (fileTree("libs"))

    compileOnly ("org.projectlombok:lombok:1.18.22")
    annotationProcessor ("org.projectlombok:lombok:1.18.22")
}

bukkit {
    author = "DevGui"
    main = "com.minecraft.kotlin.scoreboard.ScoreboardPlugin"
    version = "1.0.0"
    depend = listOf("PlaceholderAPI")
}


tasks.shadowJar {
    archiveFileName.set("scoreboard.jar")
}
kotlin {
    jvmToolchain(8)
}
