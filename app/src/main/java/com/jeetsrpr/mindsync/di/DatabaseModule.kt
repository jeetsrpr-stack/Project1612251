package com.jeetsrpr.mindsync.di

import android.content.Context
import androidx.room.Room
import com.jeetsrpr.mindsync.data.MindSyncDatabase
import com.jeetsrpr.mindsync.data.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMindSyncDatabase(@ApplicationContext context: Context): MindSyncDatabase {
        // Generate a secure passphrase for SQLCipher
        // In production, this should be stored securely (e.g., Android Keystore)
        val passphrase: ByteArray = SQLiteDatabase.getBytes("mindsync_secure_key_2024".toCharArray())
        val factory = SupportFactory(passphrase)
        
        return Room.databaseBuilder(
            context,
            MindSyncDatabase::class.java,
            "mindsync_database"
        )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(database: MindSyncDatabase): UserDao = database.userDao()

    @Provides
    fun provideMessageDao(database: MindSyncDatabase): MessageDao = database.messageDao()

    @Provides
    fun provideEmailDao(database: MindSyncDatabase): EmailDao = database.emailDao()

    @Provides
    fun provideSmsDao(database: MindSyncDatabase): SmsDao = database.smsDao()

    @Provides
    fun provideNotificationDao(database: MindSyncDatabase): NotificationDao = database.notificationDao()

    @Provides
    fun provideContactDao(database: MindSyncDatabase): ContactDao = database.contactDao()

    @Provides
    fun providePriorityRuleDao(database: MindSyncDatabase): PriorityRuleDao = database.priorityRuleDao()

    @Provides
    fun provideBiometricConfigDao(database: MindSyncDatabase): BiometricConfigDao = database.biometricConfigDao()

    @Provides
    fun provideDeviceConfigDao(database: MindSyncDatabase): DeviceConfigDao = database.deviceConfigDao()

    @Provides
    fun provideGmailAccountDao(database: MindSyncDatabase): GmailAccountDao = database.gmailAccountDao()

    @Provides
    fun provideChatMessageDao(database: MindSyncDatabase): ChatMessageDao = database.chatMessageDao()

    @Provides
    fun provideAppSettingsDao(database: MindSyncDatabase): AppSettingsDao = database.appSettingsDao()
}
