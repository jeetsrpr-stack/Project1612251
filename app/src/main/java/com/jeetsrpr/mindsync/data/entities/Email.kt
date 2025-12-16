package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emails")
data class Email(
    @PrimaryKey
    val id: String,
    val gmailAccountId: Long,
    val from: String,
    val to: String,
    val subject: String,
    val snippet: String,
    val body: String?,
    val timestamp: Long,
    val read: Boolean = false,
    val priorityScore: Int = 0,
    val threadId: String?,
    val labels: String? // JSON array
)
