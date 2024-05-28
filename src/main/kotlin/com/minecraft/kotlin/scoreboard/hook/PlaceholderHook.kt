package com.minecraft.kotlin.scoreboard.hook

import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.entity.Player

class PlaceholderHook : PlaceholderExpansion() {

    override fun getIdentifier(): String = "score"

    override fun getAuthor(): String = "DevGui"

    override fun getVersion(): String = "1.0"

    override fun onPlaceholderRequest(player: Player, identifier: String): String? {
        return when (identifier.toLowerCase()) {
            "player" -> player.name
            else -> null
        }
    }
}