package com.jeetsrpr.mindsync.utils

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context

object BluetoothHelper {
    
    fun isBluetoothEnabled(context: Context): Boolean {
        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        val bluetoothAdapter = bluetoothManager?.adapter
        return bluetoothAdapter?.isEnabled == true
    }
    
    fun getConnectedDevices(context: Context): List<BluetoothDevice> {
        val bluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager
        val bluetoothAdapter = bluetoothManager?.adapter
        
        return try {
            bluetoothAdapter?.bondedDevices?.toList() ?: emptyList()
        } catch (e: SecurityException) {
            emptyList()
        }
    }
    
    fun isGalaxyBudsConnected(context: Context): Boolean {
        val devices = getConnectedDevices(context)
        return devices.any { device ->
            device.name?.contains("Galaxy Buds", ignoreCase = true) == true
        }
    }
}
