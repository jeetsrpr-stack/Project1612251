package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "priority_rules")
data class PriorityRule(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val ruleType: String, // SENDER, KEYWORD, TIME, CONTACT
    val ruleValue: String,
    val scoreModifier: Int, // -100 to +100
    val enabled: Boolean = true
)
