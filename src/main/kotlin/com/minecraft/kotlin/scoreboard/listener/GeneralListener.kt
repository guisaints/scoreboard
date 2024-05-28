package com.minecraft.kotlin.scoreboard.listener

import com.minecraft.kotlin.scoreboard.configuration.ScoreboardConfig
import com.minecraft.kotlin.scoreboard.manager.ScoreboardManager
import fr.mrmicky.fastboard.FastBoard
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class GeneralListener : Listener{

    fun onPlayer(event: PlayerJoinEvent) {
        val player = event.player
        val scoreboardTitle = ScoreboardConfig.getScoreboardTitle()
        val scoreboardLines = ScoreboardConfig.getScoreboardLines()

        val board = FastBoard(player)

        board.updateTitle(scoreboardTitle)
        board.updateLines(scoreboardLines)

        ScoreboardManager().startScoreboardUpdateTask()
        }
    }