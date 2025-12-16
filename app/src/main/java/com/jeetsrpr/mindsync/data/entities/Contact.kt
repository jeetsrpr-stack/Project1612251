package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey
    val id: String,
    val name: String,
    val phoneNumber: String?,
    val email: String?,
    val lastInteraction: Long?,
    val interactionCount: Int = 0,
    val importance: Int = 0
)
