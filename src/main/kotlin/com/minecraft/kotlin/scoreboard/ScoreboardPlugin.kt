package com.minecraft.kotlin.scoreboard

import com.minecraft.kotlin.scoreboard.configuration.ScoreboardConfig
import com.minecraft.kotlin.scoreboard.hook.PlaceholderHook
import com.minecraft.kotlin.scoreboard.listener.GeneralListener
import com.minecraft.kotlin.scoreboard.manager.ScoreboardManager
import fr.mrmicky.fastboard.FastBoard
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class ScoreboardPlugin : JavaPlugin() {
    private lateinit var scoreboardManager: ScoreboardManager
    private lateinit var placeholderHook: PlaceholderHook

    companion object {
        private lateinit var instance: ScoreboardPlugin

        @JvmStatic
        fun getInstance(): ScoreboardPlugin {
            return instance
        }
    }

    override fun onEnable() {
        saveDefaultConfig()
        logger.info("plugin enabled.")

        instance = this

        server.pluginManager.registerEvents(GeneralListener(), this)

        ScoreboardConfig.loadConfig(this)

        scoreboardManager = ScoreboardManager()

        placeholderHook = PlaceholderHook()

        scoreboardManager.startScoreboardUpdateTask()

        placeholderHook.register()
    }

    override fun onDisable() {
        logger.info("plugin disabled.")
        scoreboardManager.stopScoreboardUpdateTask()
    }
}