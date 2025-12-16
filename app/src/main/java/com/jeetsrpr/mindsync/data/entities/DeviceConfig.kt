package com.jeetsrpr.mindsync.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device_config")
data class DeviceConfig(
    @PrimaryKey
    val id: Long = 1,
    val deviceName: String,
    val galaxyBudsConnected: Boolean = false,
    val galaxyBudsDeviceAddress: String?,
    val lastBudsConnectionTimestamp: Long = 0,
    val autoReadOnBudsConnect: Boolean = false
)
