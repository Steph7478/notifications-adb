package com.notificador.ui;

import java.awt.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import com.notificador.entities.Notification;

public class TrayManager {
    private TrayIcon trayIcon;

    public TrayManager() throws Exception {
        if (!SystemTray.isSupported())
            throw new RuntimeException("System Tray não suportado");

        Image icon = ((ImageIcon) FileSystemView.getFileSystemView()
                .getSystemIcon(new File("C:\\Windows\\explorer.exe"))).getImage();

        this.trayIcon = new TrayIcon(icon, "Mobile Bridge");
        this.trayIcon.setImageAutoSize(true);
        SystemTray.getSystemTray().add(trayIcon);
    }

    public void showNotification(Notification n) {
        trayIcon.displayMessage(n.title(), n.message(), TrayIcon.MessageType.INFO);
    }
}