package com.example.demo.services;

import com.example.demo.Entité.Notification;
import com.example.demo.Entité.User; // Utiliser le bon User
import com.example.demo.Repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    // Créer et envoyer une notification
    public Notification createNotification(String message, User user) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setUser(user);
        notification.setRead(false); // Notification initialisée comme non lue

        // Sauvegarde de la notification
        Notification savedNotification = notificationRepository.save(notification);

        // Envoi de l'email
        sendEmailToUser(user, message);

        return savedNotification;
    }

    // Envoyer un email à un utilisateur
    public void sendEmailToUser(User user, String message) {
        String subject = "Nouvelle notification";
        String body = "Bonjour " + user.getFirstName() + " " + user.getLastName() + ",\n\n" + message;
        emailService.sendEmail(user.getEmail(), subject, body);
    }
}
