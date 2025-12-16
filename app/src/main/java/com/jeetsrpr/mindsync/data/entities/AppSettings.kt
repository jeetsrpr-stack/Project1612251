package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_settings")
data class AppSettings(
    @PrimaryKey
    val id: Long = 1,
    val theme: String = "SYSTEM", // LIGHT, DARK, SYSTEM
    val notificationsEnabled: Boolean = true,
    val aiEnabled: Boolean = true,
    val autoSyncEnabled: Boolean = true,
    val syncIntervalMinutes: Int = 15,
    val geminiApiKey: String?,
    val privacyMode: Boolean = false
)
