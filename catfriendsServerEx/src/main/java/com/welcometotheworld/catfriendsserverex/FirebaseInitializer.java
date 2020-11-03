package com.welcometotheworld.catfriendsserverex;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitializer {
    private final Logger log = LoggerFactory.getLogger(FirebaseInitializer.class);
    //    @Value("${firebase.accountFile}")
    private String accountFile = "C:\\Users\\PDW\\Desktop\\wtw\\catfriendsServerEx\\src\\main\\resources\\service-account.json";

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream(accountFile);//"service-account.json"
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                log.info("Firebase application has been installed.");
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
