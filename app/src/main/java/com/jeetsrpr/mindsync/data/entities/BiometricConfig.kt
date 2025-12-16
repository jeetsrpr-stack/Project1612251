package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "biometric_config")
data class BiometricConfig(
    @PrimaryKey
    val id: Long = 1,
    val enabled: Boolean = false,
    val requireOnStart: Boolean = true,
    val timeoutMinutes: Int = 5,
    val lastAuthTimestamp: Long = 0
)
