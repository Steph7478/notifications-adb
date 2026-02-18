package com.notificador.utils;

import java.util.Arrays;
import java.util.regex.*;
import com.notificador.entities.Notification;

public class NotificationParser {

    private static final Pattern REGEX_TEXT_LINES = Pattern.compile(
            "android\\.textLines=CharSequence\\[\\]\\s+\\(\\d+\\)\\s+(.*?)\\s+android\\.", Pattern.DOTALL);
    private static final Pattern REGEX_INDIVIDUAL_LINE = Pattern.compile("\\[\\d+\\]\\s+(.*)");
    private static final Pattern REGEX_TITLE = Pattern.compile("android\\.title=String\\s+\\((.*?)\\)");

    public Notification parse(String dump, String lastId) {
        String title = extractTitle(dump);
        String message = extractMessage(dump, lastId);

        if (title.isEmpty() || message.isEmpty())
            return null;

        if (message.contains(": ")) {
            String[] partes = message.split(": ", 2);
            return new Notification(partes[0], partes[1]);
        }
        return new Notification(title, message);
    }

    private String extractTitle(String dump) {
        Matcher m = REGEX_TITLE.matcher(dump);
        String lastFound = "";
        while (m.find()) {
            String t = m.group(1).trim();
            if (!t.equalsIgnoreCase("WhatsApp")) {
                lastFound = t.replaceAll("\\(\\d+.*?\\)", "").trim();
            }
        }
        return lastFound;
    }

    private String extractMessage(String dump, String lastId) {
        Matcher mBlock = REGEX_TEXT_LINES.matcher(dump);
        if (!mBlock.find())
            return "";

        String[] lines = mBlock.group(1).split("\n");

        return Arrays.stream(lines)
                .map(String::trim)
                .map(REGEX_INDIVIDUAL_LINE::matcher)
                .filter(Matcher::find)
                .map(m -> m.group(1).trim())
                .filter(s -> !s.isEmpty() && !s.equals(lastId))
                .reduce((first, second) -> second)
                .orElse("");
    }
}
