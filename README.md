# MindSync AI
Intelligent Android personal assistant with AI-powered communication prioritization

## Overview
MindSync AI is a sophisticated Android assistant designed specifically for Samsung Galaxy S22+ that combines artificial intelligence with intelligent communication management. Built with modern Android development practices, it provides seamless integration with Gmail, SMS, and notifications while offering priority-based organization.

## Technical Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose with Material 3 Design
- **Dependency Injection**: Hilt (Dagger)
- **Database**: Room with SQLCipher encryption
- **AI Integration**: Gemini AI for conversational assistance
- **Authentication**: Gmail OAuth (multi-account support), Biometric authentication
- **Target Device**: Samsung Galaxy S22+ with Galaxy Buds detection

## Features

### Core Functionality
- **12 Database Entities**: Comprehensive data model including User, Message, Email, SMS, Notification, Contact, PriorityRule, BiometricConfig, DeviceConfig, GmailAccount, ChatMessage, and AppSettings
- **10 UI Screens**: 
  1. Welcome - Onboarding introduction
  2. Permissions - Request necessary permissions
  3. ProfileSetup - User profile configuration
  4. GmailConnect - Multi-account Gmail OAuth
  5. Dashboard - Main hub with priority items
  6. Chat - Gemini AI conversational interface
  7. Notifications - Captured notification management
  8. Communications - Unified emails and SMS view
  9. Profile - User profile management
  10. Settings - App configuration

### Intelligent Features
- **Priority Scoring System (0-100)**: Advanced algorithm that analyzes communications based on:
  - Contact importance and interaction history
  - Content keywords (urgent, important, ASAP, etc.)
  - Custom user-defined priority rules
  - Sender patterns and time-based rules
  
- **Multi-Account Gmail Integration**: OAuth-based Gmail access supporting multiple accounts with secure token management

- **SMS/Notification Capture**: 
  - Real-time SMS interception via BroadcastReceiver
  - System-wide notification monitoring via NotificationListenerService
  - Automatic priority calculation for incoming communications

- **Biometric Authentication**: Fingerprint/Face unlock for app access with configurable timeout

- **Galaxy Buds Detection**: Bluetooth-based detection for Samsung Galaxy Buds with contextual features

### Security
- **SQLCipher Database Encryption**: All local data encrypted at rest
- **Biometric Authentication**: Secure app access
- **OAuth 2.0**: Secure Gmail account integration
- **Privacy Mode**: Enhanced privacy features for sensitive data

## Architecture

### Data Layer
- Room Database with SQLCipher for encrypted local storage
- DAOs for type-safe database access
- Repository pattern for data abstraction

### Dependency Injection
- Hilt provides compile-time dependency injection
- Modular architecture with DatabaseModule and AppModule

### UI Layer
- Jetpack Compose for declarative UI
- Material 3 Design System with dynamic theming
- Navigation component for screen management
- MVVM architecture pattern ready

### Services & Receivers
- `SmsReceiver`: Captures incoming SMS messages
- `NotificationListenerService`: Monitors system notifications
- Background processing with WorkManager (ready for implementation)

## Package Structure
```
com.jeetsrpr.mindsync/
├── data/
│   ├── entities/         # 12 Room entities
│   ├── dao/             # Data Access Objects
│   └── MindSyncDatabase # Room database configuration
├── di/                  # Hilt dependency injection modules
├── ui/
│   ├── screens/         # 10 Compose screens
│   ├── navigation/      # Navigation setup
│   ├── theme/           # Material 3 theming
│   └── components/      # Reusable UI components
├── domain/
│   ├── usecase/         # Business logic (extensible)
│   └── model/           # Domain models
├── receivers/           # Broadcast receivers
├── services/            # Android services
├── utils/               # Utility classes
└── MindSyncApplication  # Hilt application class
```

## Permissions Required
- `INTERNET` - Network access for AI and Gmail
- `READ_SMS` / `RECEIVE_SMS` - SMS capture
- `READ_CONTACTS` - Contact information
- `POST_NOTIFICATIONS` - Notification management
- `BLUETOOTH` / `BLUETOOTH_CONNECT` - Galaxy Buds detection
- `USE_BIOMETRIC` - Fingerprint/Face authentication
- `GET_ACCOUNTS` - Gmail account access
- `BIND_NOTIFICATION_LISTENER_SERVICE` - Notification monitoring

## Building the Project

### Prerequisites
- Android Studio Hedgehog or later
- JDK 17
- Android SDK 34
- Gradle 8.2+

### Setup
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Configure Gemini AI API key in settings
5. Build and run on Samsung Galaxy S22+ or compatible device

### Gradle Build
```bash
./gradlew assembleDebug
```

### Running Tests
```bash
./gradlew test
```

## Configuration
- Minimum SDK: 26 (Android 8.0)
- Target SDK: 34 (Android 14)
- Compile SDK: 34

## Future Enhancements
- Email content AI summarization
- Voice command integration
- Smart reply suggestions
- Cross-device synchronization
- Advanced analytics dashboard
- Calendar integration
- Custom notification sounds per priority level

## Repository
**Package**: `com.jeetsrpr.mindsync`  
**Repository**: jeetsrpr-stack/project141225

## License
This project is part of the MindSync AI initiative.

---
Built with ❤️ using Kotlin and Jetpack Compose
