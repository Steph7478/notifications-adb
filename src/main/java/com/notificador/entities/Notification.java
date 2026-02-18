package com.notificador.entities;

public record Notification(String title, String message) {
    public String id() {
        return title + "|" + message;
    }
}