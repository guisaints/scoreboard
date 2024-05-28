package com.minecraft.kotlin.scoreboard.manager

import com.minecraft.kotlin.scoreboard.ScoreboardPlugin
import com.minecraft.kotlin.scoreboard.configuration.ScoreboardConfig
import fr.mrmicky.fastboard.FastBoard
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

class ScoreboardManager() {

    private var scoreboardTask: BukkitTask? = null
    private lateinit var board: FastBoard

    fun startScoreboardUpdateTask() {
        scoreboardTask = object : BukkitRunnable() {
            override fun run() {
                val scoreboardTitle = ScoreboardConfig.getScoreboardTitle()
                val scoreboardLines = ScoreboardConfig.getScoreboardLines()

                board.updateTitle(scoreboardTitle)
                board.updateLines(scoreboardLines)
            }
        }.runTaskTimer(ScoreboardPlugin.getInstance(), 20L, 20L)
    }

    fun stopScoreboardUpdateTask() {
        scoreboardTask?.cancel()
    }
}