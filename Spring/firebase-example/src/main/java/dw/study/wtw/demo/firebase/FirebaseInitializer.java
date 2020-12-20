package dw.study.wtw.demo.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
//@NoArgsConstructor
public class FirebaseInitializer {
    private final Logger log = LoggerFactory.getLogger(FirebaseInitializer.class);
    @Value("${firebase.accountFile}")
    private String accountFile;

//    @PostConstruct
//    public void initialize(){
//        try{
//            FileInputStream serviceAccount = new FileInputStream(accountFile);
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.getApplicationDefault())
////                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
//                    .build();
//            if(FirebaseApp.getApps().isEmpty()){
//                FirebaseApp.initializeApp(options);
//                log.info("Firebase application has been initialized");
//            }
//        }catch (IOException e){
//            log.error(e.getMessage());
//        }
//    }
@PostConstruct
public void initialize(){
    try{
        FileInputStream serviceAccount = new FileInputStream(accountFile);//"service-account.json"
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
            log.info("Firebase application has been installed.");
        }

    }catch (IOException e){
        log.error(e.getMessage());
    }
}

}
