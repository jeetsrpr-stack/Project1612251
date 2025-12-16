package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_messages")
data class ChatMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val role: String, // USER or AI
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val conversationId: String? = null
)
