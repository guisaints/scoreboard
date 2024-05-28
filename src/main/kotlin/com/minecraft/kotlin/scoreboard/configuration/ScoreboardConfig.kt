package com.minecraft.kotlin.scoreboard.configuration

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

object ScoreboardConfig {

    private var config: FileConfiguration? = null;

    fun loadConfig(plugin: JavaPlugin) {
        val configFile = File(plugin.dataFolder, "config.yml")
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false)
        }

        config = YamlConfiguration.loadConfiguration(configFile)
    }

    fun getScoreboardTitle(): String {
        return config?.getString("scoreboard.title", "") ?: ""
    }

    fun getScoreboardLines(): List<String> {
        return config?.getStringList("scoreboard.lines") ?: emptyList()
    }
}