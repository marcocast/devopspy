package org.devopspy.notificators;

public interface NotificationService {

    void send(String email, String message);
}