package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val senderId: String,
    val senderName: String,
    val content: String,
    val timestamp: Long,
    val read: Boolean = false,
    val priorityScore: Int = 0,
    val source: String = "SMS"
)
