package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gmail_accounts")
data class GmailAccount(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val email: String,
    val displayName: String?,
    val accessToken: String?,
    val refreshToken: String?,
    val tokenExpiryTime: Long = 0,
    val isActive: Boolean = true,
    val lastSyncTimestamp: Long = 0,
    val addedAt: Long = System.currentTimeMillis()
)
