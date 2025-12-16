package com.jeetsrpr.mindsync.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            messages?.forEach { message ->
                val sender = message.displayOriginatingAddress
                val body = message.messageBody
                val timestamp = message.timestampMillis
                
                Log.d("SmsReceiver", "SMS received from $sender: $body")
                
                // TODO: Store in database and calculate priority score
                // Use WorkManager to process in background
            }
        }
    }
}
