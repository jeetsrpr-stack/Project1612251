package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sms")
data class Sms(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val phoneNumber: String,
    val content: String,
    val timestamp: Long,
    val type: String = "RECEIVED", // RECEIVED, SENT
    val read: Boolean = false,
    val priorityScore: Int = 0
)
