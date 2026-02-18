package com.notificador;

import java.util.HashSet;
import java.util.Set;
import com.notificador.entities.Notification;
import com.notificador.services.AdbService;
import com.notificador.ui.TrayManager;
import com.notificador.utils.NotificationParser;

public class App {
    public static void main(String[] args) {
        try {
            AdbService adb = new AdbService();
            NotificationParser parser = new NotificationParser();
            TrayManager tray = new TrayManager();

            Set<String> historicoIds = new HashSet<>();

            Notification initial = parser.parse(adb.fetchNotificationDump(), "");
            if (initial != null)
                historicoIds.add(initial.id());

            System.out.println("Monitorando notificações do WhatsApp...");

            while (true) {
                Notification n = parser.parse(adb.fetchNotificationDump(), "");
                if (n != null && historicoIds.add(n.id())) {
                    tray.showNotification(n);

                    if (historicoIds.size() > 100) {
                        historicoIds.clear();
                        historicoIds.add(n.id());
                    }
                }
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
