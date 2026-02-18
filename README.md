# 📱 notifications-adb
> **Mirror your Android notifications to your Desktop System Tray via ADB.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

---

## ✨ Overview
**notifications-adb** is a lightweight bridge that monitors your Android device's notifications (optimized for WhatsApp) and displays them as native desktop alerts in the Windows System Tray. No heavy apps, no cloud syncing—just the pure power of **ADB**.

> [!IMPORTANT]
> **Compatibility:** Designed for **Windows** host and **Android** devices.
> **Authorization:** You must enable **Developer Options** and either **USB Debugging** or **Wireless Debugging** on your phone.

---

## 🛠️ Requirements

| Tool | Version | Purpose |
| :--- | :--- | :--- |
| **JDK** | 8 or higher | Java Runtime Environment |
| **ADB** | Latest | Command bridge (PC-Android) |
| **Maven** | 3.6+ | Build and dependency management |

---

## 🚀 Quick Start (Automation via `.bat`)

The project includes a `mobile-bridge.bat` script that automates the entire connection process:

1. **Prepare your Phone:** Enable debugging (USB or Wi-Fi).
2. **Run `mobile-bridge.bat`**:
   - The script will restart the ADB server to ensure stability.
   - **For USB Mode:** Simply press **ENTER** when prompted for an IP.
   - **For Wireless Mode:** Type your phone's IP address (e.g., `192.168.0.15`) and press **ENTER**.
3. **Done!** The script will clear old logs and automatically start the Java application.

---

## ⚙️ How it Works



1. **Data Capture**: The app executes `adb shell dumpsys notification --noredact` to read the Android system's notification buffer.
2. **Regex Intelligence**: 
   - It filters specific notification blocks from `com.whatsapp`.
   - It extracts the **Sender** using `android.title`.
   - It retrieves message history via `android.textLines`.
3. **Desktop Notification**: If a new message is detected, the System Tray icon triggers a Windows info toast.

---
