package com.notificador.services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class AdbService {

    public String fetchNotificationDump() throws IOException {
        String cmd = "adb shell dumpsys notification --noredact | grep -A 50 com.whatsapp";
        Process p = Runtime.getRuntime().exec(new String[] { "cmd", "/c", cmd });

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {
            return br.lines()
                    .collect(Collectors.joining("\n"))
                    .replaceAll("[^\\p{Print}\\n]", "");
        }
    }
}
