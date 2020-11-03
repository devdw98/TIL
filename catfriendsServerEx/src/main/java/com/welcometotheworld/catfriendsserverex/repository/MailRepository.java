package com.welcometotheworld.catfriendsserverex.repository;

import com.welcometotheworld.catfriendsserverex.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
}
