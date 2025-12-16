package com.jeetsrpr.mindsync.data.dao

import androidx.room.*
import com.jeetsrpr.mindsync.data.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users LIMIT 1")
    fun getUser(): Flow<User?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    
    @Update
    suspend fun updateUser(user: User)
}

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages ORDER BY timestamp DESC")
    fun getAllMessages(): Flow<List<Message>>
    
    @Query("SELECT * FROM messages WHERE priorityScore >= :minScore ORDER BY priorityScore DESC, timestamp DESC")
    fun getHighPriorityMessages(minScore: Int = 70): Flow<List<Message>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: Message)
    
    @Update
    suspend fun updateMessage(message: Message)
}

@Dao
interface EmailDao {
    @Query("SELECT * FROM emails ORDER BY timestamp DESC")
    fun getAllEmails(): Flow<List<Email>>
    
    @Query("SELECT * FROM emails WHERE gmailAccountId = :accountId ORDER BY timestamp DESC")
    fun getEmailsByAccount(accountId: Long): Flow<List<Email>>
    
    @Query("SELECT * FROM emails WHERE priorityScore >= :minScore ORDER BY priorityScore DESC, timestamp DESC")
    fun getHighPriorityEmails(minScore: Int = 70): Flow<List<Email>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmail(email: Email)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmails(emails: List<Email>)
    
    @Update
    suspend fun updateEmail(email: Email)
}

@Dao
interface SmsDao {
    @Query("SELECT * FROM sms ORDER BY timestamp DESC")
    fun getAllSms(): Flow<List<Sms>>
    
    @Query("SELECT * FROM sms WHERE priorityScore >= :minScore ORDER BY priorityScore DESC, timestamp DESC")
    fun getHighPrioritySms(minScore: Int = 70): Flow<List<Sms>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSms(sms: Sms)
}

@Dao
interface NotificationDao {
    @Query("SELECT * FROM notifications WHERE dismissed = 0 ORDER BY timestamp DESC")
    fun getActiveNotifications(): Flow<List<Notification>>
    
    @Query("SELECT * FROM notifications ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentNotifications(limit: Int = 50): Flow<List<Notification>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotification(notification: Notification)
    
    @Update
    suspend fun updateNotification(notification: Notification)
}

@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts ORDER BY importance DESC, name ASC")
    fun getAllContacts(): Flow<List<Contact>>
    
    @Query("SELECT * FROM contacts WHERE id = :contactId")
    fun getContact(contactId: String): Flow<Contact?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact)
    
    @Update
    suspend fun updateContact(contact: Contact)
}

@Dao
interface PriorityRuleDao {
    @Query("SELECT * FROM priority_rules WHERE enabled = 1")
    fun getEnabledRules(): Flow<List<PriorityRule>>
    
    @Query("SELECT * FROM priority_rules")
    fun getAllRules(): Flow<List<PriorityRule>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRule(rule: PriorityRule)
    
    @Update
    suspend fun updateRule(rule: PriorityRule)
    
    @Delete
    suspend fun deleteRule(rule: PriorityRule)
}

@Dao
interface BiometricConfigDao {
    @Query("SELECT * FROM biometric_config LIMIT 1")
    fun getConfig(): Flow<BiometricConfig?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfig(config: BiometricConfig)
    
    @Update
    suspend fun updateConfig(config: BiometricConfig)
}

@Dao
interface DeviceConfigDao {
    @Query("SELECT * FROM device_config LIMIT 1")
    fun getConfig(): Flow<DeviceConfig?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConfig(config: DeviceConfig)
    
    @Update
    suspend fun updateConfig(config: DeviceConfig)
}

@Dao
interface GmailAccountDao {
    @Query("SELECT * FROM gmail_accounts WHERE isActive = 1 ORDER BY addedAt ASC")
    fun getActiveAccounts(): Flow<List<GmailAccount>>
    
    @Query("SELECT * FROM gmail_accounts WHERE id = :accountId")
    fun getAccount(accountId: Long): Flow<GmailAccount?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: GmailAccount)
    
    @Update
    suspend fun updateAccount(account: GmailAccount)
    
    @Delete
    suspend fun deleteAccount(account: GmailAccount)
}

@Dao
interface ChatMessageDao {
    @Query("SELECT * FROM chat_messages ORDER BY timestamp ASC")
    fun getAllMessages(): Flow<List<ChatMessage>>
    
    @Query("SELECT * FROM chat_messages WHERE conversationId = :conversationId ORDER BY timestamp ASC")
    fun getMessagesByConversation(conversationId: String?): Flow<List<ChatMessage>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: ChatMessage)
    
    @Query("DELETE FROM chat_messages")
    suspend fun deleteAllMessages()
}

@Dao
interface AppSettingsDao {
    @Query("SELECT * FROM app_settings LIMIT 1")
    fun getSettings(): Flow<AppSettings?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(settings: AppSettings)
    
    @Update
    suspend fun updateSettings(settings: AppSettings)
}
