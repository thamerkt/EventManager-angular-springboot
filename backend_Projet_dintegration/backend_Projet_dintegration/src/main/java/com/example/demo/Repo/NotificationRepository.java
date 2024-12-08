package com.example.demo.Repo;

import com.example.demo.Entité.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Ajouter ici des méthodes personnalisées pour la recherche de notifications
}
