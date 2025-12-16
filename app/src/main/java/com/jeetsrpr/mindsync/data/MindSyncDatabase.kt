package com.jeetsrpr.mindsync.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeetsrpr.mindsync.data.dao.*
import com.jeetsrpr.mindsync.data.entities.*

@Database(
    entities = [
        User::class,
        Message::class,
        Email::class,
        Sms::class,
        Notification::class,
        Contact::class,
        PriorityRule::class,
        BiometricConfig::class,
        DeviceConfig::class,
        GmailAccount::class,
        ChatMessage::class,
        AppSettings::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MindSyncDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun messageDao(): MessageDao
    abstract fun emailDao(): EmailDao
    abstract fun smsDao(): SmsDao
    abstract fun notificationDao(): NotificationDao
    abstract fun contactDao(): ContactDao
    abstract fun priorityRuleDao(): PriorityRuleDao
    abstract fun biometricConfigDao(): BiometricConfigDao
    abstract fun deviceConfigDao(): DeviceConfigDao
    abstract fun gmailAccountDao(): GmailAccountDao
    abstract fun chatMessageDao(): ChatMessageDao
    abstract fun appSettingsDao(): AppSettingsDao
}
